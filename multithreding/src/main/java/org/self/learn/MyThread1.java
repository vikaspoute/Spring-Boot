package org.self.learn;

public class MyThread1 extends Thread {

    MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            for (long j = 0; j < 10000000000L; j++) {

            }

            System.out.println(
                    Thread.currentThread().getName() +
                            " -> " +
                            "Priority" +
                            " -> " +
                            Thread.currentThread().getPriority() +
                            " -> " +
                            "Counter" +
                            " -> " +
                            i
            );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyThread1 mt1 = new MyThread1("Low Priority Thread");
        MyThread1 mt2 = new MyThread1("Medium Priority Thread");
        MyThread1 mt3 = new MyThread1("High Priority Thread");
        mt1.setPriority(Thread.MIN_PRIORITY);
        mt2.setPriority(Thread.NORM_PRIORITY);
        mt3.setPriority(Thread.MAX_PRIORITY);
        mt1.start();
        mt2.start();
        mt3.start();

    }
}
