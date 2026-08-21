package com.javaplayground.multithreading.threads.test;

public class ThreadMain {

    public static void main(String args[]){

        System.out.println(Thread.currentThread().getName()+" is running");

        for(int count =1;count<=3;count++)
        {
                FirstThread thread1 = new FirstThread(count);
                thread1.start();
        }



        // MyRunnable myRunnable = new MyRunnable();
        // Thread thread2 = new Thread(myRunnable);
        // thread2.start();
    }

}
