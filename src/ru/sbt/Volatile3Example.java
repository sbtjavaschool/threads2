package ru.sbt;

import java.awt.*;

public class Volatile3Example {
    private volatile Point point = new Point();

    private void setXY(int x, int y) {
        point = new Point(x, y);
    }

    public static void main(String[] args) {
        Volatile3Example example = new Volatile3Example();
        example.setXY(10, 10);
        ///thread1

        example.setXY(3, 3);
        //thread3

        ///thread2
        double x = example.point.getX();
        double y = example.point.getY();

    }
}