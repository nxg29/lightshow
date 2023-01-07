package com.event.lightshow;

import com.event.lightshow.receiver.SimpleDisplay;
import com.event.lightshow.util.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.event.lightshow.receiver.Display.DISPLAY_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleDisplayTest {

    private SimpleDisplay simpleDisplay;

    @BeforeEach
    void init() {
        var display = new int[DISPLAY_SIZE][DISPLAY_SIZE];
        simpleDisplay = new SimpleDisplay(display);
    }

    @Test
    void turnOnTest() {
        simpleDisplay.turnOn(new Point(10, 10), new Point(49, 49));
        var lightsOn = simpleDisplay.computeLightsOn();
        assertEquals(1600, lightsOn);
    }

    @Test
    void turnOffTest() {
        simpleDisplay.turnOn(new Point(0, 0), new Point(99, 99));
        simpleDisplay.turnOff(new Point(0, 0), new Point(9, 9));
        var lightsOn = simpleDisplay.computeLightsOn();
        assertEquals(9900, lightsOn);
    }

    @Test
    void toggleTest() {
        simpleDisplay.turnOn(new Point(0, 0), new Point(99, 99));
        simpleDisplay.toggle(new Point(50, 60), new Point(79, 89));
        var lightsOn = simpleDisplay.computeLightsOn();
        assertEquals(9100, lightsOn);
    }

    @Test
    void computeLightsTest() {
        simpleDisplay.turnOn(new Point(0, 0), new Point(999, 999));
        var lightsOn = simpleDisplay.computeLightsOn();
        assertEquals(1000000, lightsOn);
    }
}
