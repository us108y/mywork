package com.scrap;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ujjwal on 12/23/2016.
 */
public class Singelton {
//    private static Singelton soleInstane = new Singelton();  // eagar instance creation
    private static Singelton soleInstane = null;
    private Singelton() {
        System.out.println("creating instance ...");
    }

public static Singelton getInstance(){
        if (null == soleInstane) {
            soleInstane = new Singelton();
        }
        return soleInstane;
}
}

class TestwithThreads {
    static void useSingelton() {
        Singelton singelton = Singelton.getInstance();
        TestObjcreation.print("singelton", singelton);
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(TestwithThreads::useSingelton);
        service.submit(TestwithThreads::useSingelton);

        service.shutdown();
    }
}
class TestObjcreation{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singelton s1 = Singelton.getInstance();
        Singelton s2 = Singelton.getInstance();

        //same object
        print ("s1", s1);
        print ("s2", s2);

        //now hack using reflection
        // Reflection
        Class clazz = Class.forName("com.scrap.Singelton");
        Constructor<Singelton> constrct = clazz.getDeclaredConstructor();
        //hacking in and setting constructor true
        constrct.setAccessible(true);

        Singelton s3 = constrct.newInstance();
        print ("s3", s3);

    }
    static void print(String name, Singelton obj) {
        System.out.println(String.format("Object is :%s, Hashcode: %d", name, obj.hashCode()));
    }
}
