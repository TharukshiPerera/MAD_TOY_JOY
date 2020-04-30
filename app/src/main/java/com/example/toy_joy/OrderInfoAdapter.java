package com.example.toy_joy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class OrderInfoAdapter extends ArrayAdapter<Order> {
    private Activity context;
    private List<Order> orderList;

    public OrderInfoAdapter(Activity context,List<Order>orderList){
        super(context,R.layout.list_view,orderList);
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.list_view,null,true);

        TextView ordercuname = (TextView)listView.findViewById(R.id.cuname);
        TextView ordercuphone = (TextView)listView.findViewById(R.id.cuphone);
        TextView ordercuaddress = (TextView)listView.findViewById(R.id.cuaddress);
        TextView ordercoid = (TextView)listView.findViewById(R.id.coid);
        TextView ordercopay = (TextView)listView.findViewById(R.id.copay);
        TextView ordercuvehino = (TextView)listView.findViewById(R.id.cuvehino);

        Order order = orderList.get(position);
        ordercuname.setText(order.getCuname());
        ordercuphone.setText(order.getCuphone());
        ordercuaddress.setText(order.getCuaddress());
        ordercoid.setText(order.getCoid());
        ordercopay.setText(order.getCopay());
        ordercuvehino.setText(order.getCuvehino());

        return listView;

    }
}
