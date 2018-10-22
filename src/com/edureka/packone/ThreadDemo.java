package com.edureka.packone;


import java.sql.Date;
import java.sql.Time;

class MyTask extends Thread{
    public void run(){
        Time time = new Time(System.currentTimeMillis());
        for (int i =1 ; i <= 10 ; i++){
            System.out.println("++My Task++"+time.toString());
        }
    }
}
class A{

}
class YourTask extends A implements Runnable{
    public void run(){

        Time time = new Time(System.currentTimeMillis());
        for (int i= 1 ; i <= 10 ; i++){
            System.out.println("++Your Task ++"+time.toString());
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args){
        System.out.println("*** Main Started ***");



        MyTask mRef = new MyTask();

        Runnable r = new YourTask();

        Thread yRef = new Thread(r);
        mRef.setPriority(Thread.MAX_PRIORITY);
        yRef.setPriority(Thread.MIN_PRIORITY);
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY);

        mRef.setName("MyThread");
        yRef.setName("YourThread");
        Thread.currentThread().setName("MainThread");


        mRef.start();
        yRef.start();

        System.out.println("My Task:"+mRef.getName()+" Priority "+mRef.getPriority());
        System.out.println("Your Task:"+yRef.getName()+" Priority "+yRef.getPriority());
        System.out.println("Main Name:"+Thread.currentThread().getName()+" Priority "+Thread.currentThread().getPriority());

        System.out.println("*** Main Finished ***");



    }

}
