package com.event.lightshow.receiver;


import com.event.lightshow.util.Point;

public class SimpleDisplay implements Display {

    private final int[][] display;

    public SimpleDisplay(int[][] display) {
        this.display = display;
    }

    @Override
    public void turnOn(Point leftCorner, Point rightCorner) {
        for (int i = leftCorner.getX(); i <= rightCorner.getX(); i++) {
            for (int j = leftCorner.getY(); j <= rightCorner.getY(); j++) {
                display[i][j] = 1;
            }
        }
    }

    @Override
    public void turnOff(Point leftCorner, Point rightCorner) {
        for (int i = leftCorner.getX(); i <= rightCorner.getX(); i++) {
            for (int j = leftCorner.getY(); j <= rightCorner.getY(); j++) {
                display[i][j] = 0;
            }
        }
    }

    @Override
    public void toggle(Point leftCorner, Point rightCorner) {
        for (int i = leftCorner.getX(); i <= rightCorner.getX(); i++) {
            for (int j = leftCorner.getY(); j <= rightCorner.getY(); j++) {
                var toggleLight = display[i][j] == 0 ? 1 : 0;
                display[i][j] = toggleLight;
            }
        }
    }

    @Override
    public int computeLightsOn() {
        int sum = 0;
        for (int i = 0; i < DISPLAY_SIZE; i++) {
            for (int j = 0; j < DISPLAY_SIZE; j++) {
                if (display[i][j] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
