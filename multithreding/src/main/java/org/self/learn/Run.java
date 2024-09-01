package org.self.learn;

public class Run implements Runnable {
    @Override
    public void run() {
        for (; ; ) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}