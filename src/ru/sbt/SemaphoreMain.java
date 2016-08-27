package ru.sbt;

public class SemaphoreMain {
    Semaphore semaphore = new Semaphore(5);

    public void doHardJob() {

    }

    public void run() {
        semaphore.enter();
        try {
            doHardJob();
        } finally {
            semaphore.exit();
        }
    }

    public static void main(String[] args) {




    }
}
