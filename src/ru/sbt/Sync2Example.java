package ru.sbt;

public class Sync2Example {
    private volatile boolean finish = false;
    private volatile int counter;

    public void doLoop() {
        synchronized (this) {
            while (!finish) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println(counter);
    }

    public void stop(int counter) {
        this.counter = counter;
        finish = true;

        synchronized (this) {
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Sync2Example example = new Sync2Example();

        new Thread(example::doLoop).start();

        Thread.sleep(2000);

        new Thread(() -> example.stop(500)).start();
    }
}