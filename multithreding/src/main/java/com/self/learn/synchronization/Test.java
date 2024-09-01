package com.self.learn.synchronization;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread mt1 = new MyThread(counter);
        MyThread mt2 = new MyThread(counter);
        mt1.start();
        mt2.start();

        mt1.join();
        mt2.join();
        System.out.println("Final count: " + counter.getCount());
    }
}
