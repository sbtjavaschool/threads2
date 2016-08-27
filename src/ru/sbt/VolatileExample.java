package ru.sbt;

public class VolatileExample {
    private volatile boolean keepRunning = true;

    public void doLoop() {
        long counter = 0;

        while (keepRunning) {
            ++counter;
        }

        System.out.println(counter);
    }

    public void stop() {
        keepRunning = false;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample example = new VolatileExample();

        new Thread(example::doLoop).start();

        Thread.sleep(12);

        new Thread(example::stop).start();
    }

}