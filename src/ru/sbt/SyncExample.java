package ru.sbt;

public class SyncExample {
    private boolean keepRunning = true;

    public void doLoop() {
        long counter = 0;

        while (isKeepRunning()) {
            ++counter;
        }

        System.out.println(counter);
    }

    private synchronized boolean isKeepRunning() {
        return keepRunning;
    }

    public synchronized void stop() {
        keepRunning = false;
    }

    public static void main(String[] args) throws InterruptedException {
        SyncExample example = new SyncExample();

        new Thread(example::doLoop).start();

        Thread.sleep(12);

        new Thread(example::stop).start();
    }

}