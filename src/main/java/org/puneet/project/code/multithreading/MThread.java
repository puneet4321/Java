package org.puneet.project.code.multithreading;

public class MThread extends Thread {
    @Override
    public void run() {
        System.out.println("puneet");
    }

    public static void main(String[] args) throws InterruptedException {
        MThread mThread = new MThread();
        mThread.start();

        MThread1 mThread1 = new MThread1();
        mThread1.run();

        Thread t1 = new Thread(new MThread1());
        t1.start();

        Thread t = new Thread(() -> {
            System.out.println("Child");
        });

        t.start();
        t.join();
        System.out.println("Main");
    }

}

class MThread1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread through interface");
    }
}
