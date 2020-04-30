package com.example.toy_joy;

public class Order {
    private String orderId;
    private String ordercuname;
    private String ordercuphone;
    private String ordercuaddress;
    private String ordercoid;
    private String ordercopay;
    private String ordercuvehino;

    public Order(){

    }

    public Order (String orderId,String ordercuname,String ordercuphone,String ordercuaddress,String ordercoid,String ordercopay,String ordercuvehino) {
        this.orderId = orderId;
        this.ordercuname = ordercuname;
        this.ordercuphone = ordercuphone;
        this.ordercuaddress = ordercuaddress;
        this.ordercoid = ordercoid;
        this.ordercopay = ordercopay;
        this.ordercuvehino = ordercuvehino;

    }

    public String getCuname() {
        return ordercuname;
    }

    public String getCuphone() {
        return ordercuphone;
    }

    public String getCuaddress() {
        return ordercuaddress;
    }

    public String getCoid() {
        return ordercoid;
    }

    public String getCopay() {
        return ordercopay;
    }

    public String getCuvehino() {
        return ordercuvehino;
    }
}
