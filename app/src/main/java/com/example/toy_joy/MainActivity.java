package com.example.toy_joy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private  EditText cuname,cuphone,cuaddress,coid,copay,cuvehino;
    private  Button send;
    private Button btnlist;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listbtn
        btnlist = (Button) findViewById(R.id.btnlist);
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDataRetrieved();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("order");

        cuname = (EditText)findViewById(R.id.cuname);
        cuphone = (EditText)findViewById(R.id.cuphone);
        cuaddress = (EditText)findViewById(R.id.cuaddress);
        coid = (EditText)findViewById(R.id.coid);
        copay = (EditText)findViewById(R.id.copay);
        cuvehino = (EditText)findViewById(R.id.cuvehino);
        send = (Button)findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"Data has been sent",Toast.LENGTH_LONG).show();
                addOrder();
            }
        });


    }


    public void addOrder(){
        String ordercuname = cuname.getText().toString();
        String ordercuphone = cuphone.getText().toString();
        String ordercuaddress = cuaddress.getText().toString();
        String ordercoid = coid.getText().toString();
        String ordercopay = copay.getText().toString();
        String ordercuvehino = cuvehino.getText().toString();

        if(!TextUtils.isEmpty(ordercuname) && !TextUtils.isEmpty(ordercuphone) && !TextUtils.isEmpty(ordercuaddress) && !TextUtils.isEmpty(ordercoid)
                && !TextUtils.isEmpty(ordercopay) && !TextUtils.isEmpty(ordercuvehino)){


            String id = databaseReference.push().getKey();
            Order order = new Order(id,ordercuname,ordercuphone,ordercuaddress,ordercoid,ordercopay,ordercuvehino);

            databaseReference.child(id).setValue(order);
            cuname.setText("");
            cuphone.setText("");
            cuaddress.setText("");
            coid.setText("");
            copay.setText("");
            cuvehino.setText("");
        }
        else {
            Toast.makeText(MainActivity.this, "fill this ",Toast.LENGTH_LONG).show();
        }
    }
    /////
    public void openDataRetrieved(){
        Intent intent = new Intent(this, DataRetrieved.class);
        startActivity(intent);
    }

}





