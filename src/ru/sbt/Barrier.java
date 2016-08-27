package ru.sbt;

public class Barrier {
    private final int nThread;
    private int currentThread;
    private int round = 0;

    public Barrier(int nThread) {
        this.nThread = nThread;
    }

    public synchronized void await() {
        if (++currentThread % nThread == 0) {
            notifyAll();
            return;
        }

        while (currentThread % nThread != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
