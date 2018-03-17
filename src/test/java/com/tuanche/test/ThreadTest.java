package com.tuanche.test;

import com.tuanche.base.TuancheThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by sosma on 2018/2/2.
 */
public class ThreadTest {


    volatile static int i;

    private static ExecutorService newFixedThreadPool_1 = Executors.newFixedThreadPool(20);

    private static ExecutorService newFixedThreadPool_2 = Executors.newFixedThreadPool(20, new TuancheThreadFactory("Tuanche--ThreadPool--", true));

    private static ExecutorService newSingleThreadPool_1 = Executors.newCachedThreadPool();

    private static ExecutorService newSingleThreadPool_2 = Executors.newCachedThreadPool();


    public static void main(String[] args) {

        testExecutor(30);
    }


    private static void testExecutor(final int threadCoount) {

        for (int i = 0; i < threadCoount; i++) {
            newFixedThreadPool_1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程名称-->" + Thread.currentThread().getName() + ",当前线程id--->" + Thread.currentThread().getId());
                    try {
                        for(int j = 0;j < threadCoount*100; j++) {
                            if(false) {
                                int a = j/0;
                                System.out.println("异常计算*******" + a);
                            } else {
                                System.out.println(Thread.currentThread().getId() + "正常除法…………" + j/1);
                            }
                        }
                    } catch (Exception e) {
                        Thread.currentThread().getThreadGroup().uncaughtException(Thread.currentThread(), new Exception("线程出现异常…………", e));
                    } finally {
                        System.out.println("线程终结-----当前线程名称-->" + Thread.currentThread().getName() + ",当前线程id--->" + Thread.currentThread().getId());
                        // 关闭当前线程资源
                        newFixedThreadPool_1.shutdown();
                    }

                }
            });
        }
    }

    /**
     * @param
     * @return
     * @description 测试volatile 锁定变量
     * @author ants·ht
     * @date 2018/2/13 21:37
     */
    private static void testVolatile() {
        new Thread(() -> {
            for (int a = 0; a <= 100; a++) {
                i = a;
            }
        }).start();

        new Thread(() -> {
            for (int a = 0; a <= 100; a++) {
                i = a;
            }
        }).start();

        new Thread(() -> {
            for (int a = 0; a <= 100; a++) {
                i = a;
            }
        }).start();


        System.out.println(i);
    }
}
