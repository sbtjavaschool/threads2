package ru.sbt;

public class Runner {
    private final int distance;
    private final double speed;

    public Runner(int distance, double speed) {
        this.distance = distance;
        this.speed = speed;
    }

    public void run() {
        double distance = this.distance;
        while (distance > 0) {
            doSleep();
            distance -= speed;
        }

        System.out.println(Thread.currentThread().getName());
    }

    private void doSleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int distance = 1000;
        Runner bolt = new Runner(distance, 10);
        Runner vasya = new Runner(distance, 2);
        Runner myDog = new Runner(distance, 30);

        newThread("vasya", distance, 2).start();
        newThread("bolt", distance, 10).start();
        newThread("myDog", distance, 30).start();
    }

    private static Thread newThread(String name, int distance, int speed) {
        Thread thread = new Thread(() -> new Runner(distance, speed).run());
        thread.setName(name);
        return thread;
    }
}
