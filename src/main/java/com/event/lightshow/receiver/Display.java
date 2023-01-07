package com.event.lightshow.receiver;


import com.event.lightshow.util.Point;

public interface Display {
    enum DisplayType {
        SIMPLE_DISPLAY, CUSTOM_DISPLAY
    }

    int DISPLAY_SIZE = 1000;

    void turnOn(Point leftCorner, Point rightCorner);

    void turnOff(Point leftCorner, Point rightCorner);

    void toggle(Point leftCorner, Point rightCorner);

    int computeLightsOn();


}
