package com.scrap;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ujjwal on 12/23/2016.
 */
public class ConcurrentHmapExample {
    static Map<String,Long> orders = new ConcurrentHashMap <>();

    //can solve the problem with Atomic Long or Atomic Object provided by Java 5 onwards
    // making the Operations safe
    //    static Map<String,AtomicLong> orders = new ConcurrentHashMap <>();

    static void processOrders(){
        for(String city: orders.keySet()) {
            for (int i=0;i<50;i++){
                Long oldOrder = orders.get(city);// doing get and put at same place
                orders.put(city, oldOrder+1); // won't through a Concurrent exception
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        orders.put("NewYork", 0l);
        orders.put("Seattle", 16l);
        orders.put("London", 10l);
        orders.put("Paris", 5l);

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(ConcurrentHmapExample::processOrders);
        service.submit(ConcurrentHmapExample::processOrders);

        service.awaitTermination(1, TimeUnit.SECONDS);
        service.shutdown();

        System.out.println(orders);
    }
}
