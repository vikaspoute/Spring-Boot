package org.self.learn;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        System.out.println(mt.getState());
        mt.start();
        System.out.println(mt.getState());
        Thread.sleep(1000);
        System.out.println(mt.getState());
        mt.join();
        System.out.println(mt.getState());
    }
}
