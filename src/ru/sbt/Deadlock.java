package ru.sbt;

public class Deadlock {
    private Object l1;
    private Object l2;

    public void thread() {
        synchronized (l1) {
            System.out.println("111");
            synchronized (l2) {
                System.out.printf("2222");
            }
        }
    }
    public void thread2() {
        synchronized (l2) {
            System.out.println("33333");
            synchronized (l1) {
                System.out.println("44444");
            }
        }
    }
}
