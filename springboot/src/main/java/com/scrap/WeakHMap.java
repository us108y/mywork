package com.scrap;

import java.util.Map;
import java.util.WeakHashMap;

//Quick notes for a Weak Hashmap example
/**
 * Created by Ujjwal on 12/23/2016.
 */
public class WeakHMap {
    public static void main(String[] args) {
        Map<Order, Integer> orders = new WeakHashMap<Order, Integer>();
//        adding objects with weak refrences
        orders.put(new Order(1, "this is 1"),100);
        orders.put(new Order(2, "this is new order"), 200);

        Order o3 = new Order(2, "this is order with strong refrence");
        orders.put(o3, 300);

        System.out.println("Orders size " + orders.size());
//        check value of size before and after

        System.gc(); //gc may or may no occur
        System.out.println("Orders size after " + orders.size());

    }

    public static void concurentExceptionExample(String[] args) {

    }
}

class Order {
    int orderId;
    String someDetail;

    public Order(int orderId, String someDetail) {
        this.orderId = orderId;
        this.someDetail = someDetail;
    }
}
