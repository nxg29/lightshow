package com.event.lightshow.receiver;


import com.event.lightshow.util.Point;

public class CustomDisplay implements Display {
    private final int[][] display;

    public CustomDisplay(int[][] display) {
        this.display = display;
    }

    @Override
    public void turnOn(Point leftCorner, Point rightCorner) {
        for (int i = leftCorner.getX(); i <= rightCorner.getX(); i++) {
            for (int j = leftCorner.getY(); j <= rightCorner.getY(); j++) {
                display[i][j]++;
            }
        }
    }

    @Override
    public void turnOff(Point leftCorner, Point rightCorner) {
        for (int i = leftCorner.getX(); i <= rightCorner.getX(); i++) {
            for (int j = leftCorner.getY(); j <= rightCorner.getY(); j++) {
                if (display[i][j] > 0)
                    display[i][j]--;
            }
        }
    }

    @Override
    public void toggle(Point leftCorner, Point rightCorner) {
        for (int i = leftCorner.getX(); i <= rightCorner.getX(); i++) {
            for (int j = leftCorner.getY(); j <= rightCorner.getY(); j++) {
                display[i][j] += 2;
            }
        }
    }

    @Override
    public int computeLightsOn() {
        int sum = 0;
        for (int i = 0; i < DISPLAY_SIZE; i++) {
            for (int j = 0; j < DISPLAY_SIZE; j++) {
                sum += display[i][j];
            }
        }
        return sum;
    }
}
