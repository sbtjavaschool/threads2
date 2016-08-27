package ru.sbt;

public class Barrier {
    private final int nThread;
    private int currentThread;

    public Barrier(int nThread) {
        this.nThread = nThread;
    }

    public synchronized void await() {
        if (++currentThread == nThread) {
            notifyAll();
            return;
        }

        while (currentThread < nThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
