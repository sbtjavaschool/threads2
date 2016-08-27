package ru.sbt;

public class Main {
    synchronized void m1() {
        m2();
    }

    synchronized void m2() {
        m3();
    }

    synchronized void m3() {
    }
}