package com.tuanche.test;

/**
 * Created by sosma on 2018/2/2.
 */
public class LambdaTest {


    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadId" + Thread.currentThread().getId()+"--->" + Thread.currentThread().getName());
                System.out.println("Threead -- start");
            }
        }).start();


        new Thread(() -> System.out.println("lambad - threadId" + Thread.currentThread().getId()+"--->" + Thread.currentThread().getName())).start();
    }
}
