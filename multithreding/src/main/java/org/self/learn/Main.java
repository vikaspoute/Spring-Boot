package org.self.learn;

public class Main {
    public static void main(String[] args) {

        // using thread class
        World world = new World();
        world.start();

        // using runnable class
        Runnable run = new Run();
        Thread thread = new Thread(run);
        thread.start();


        for (; ; ) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}