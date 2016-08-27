package ru.sbt;

public class Runner {
    private final int laps;
    private final int distance;
    private final double speed;
    private final Barrier barrier;

    public Runner(int laps, int distance, double speed, Barrier barrier) {
        this.laps = laps;
        this.distance = distance;
        this.speed = speed;
        this.barrier = barrier;
    }

    public void run() {
        for (int i = 0; i < laps; i++) {
            double distance = this.distance;
            while (distance > 0) {
                doSleep();
                distance -= speed;
            }
            System.out.println(Thread.currentThread().getName());

            barrier.await();
        }

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

        Barrier barrier = new Barrier(3);
        newThread("vasya", distance, 3, barrier).start();
        newThread("bolt", distance, 10, barrier).start();
        newThread("myDog", distance, 30, barrier).start();
    }

    private static Thread newThread(String name, int distance, int speed, Barrier barrier) {
        Thread thread = new Thread(() -> new Runner(10, distance, speed, barrier).run());
        thread.setName(name);
        return thread;
    }
}
