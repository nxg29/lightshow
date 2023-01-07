package com.event.lightshow;

import com.event.lightshow.receiver.CustomDisplay;
import com.event.lightshow.util.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.event.lightshow.receiver.Display.DISPLAY_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomDisplayTest {

    private CustomDisplay customDisplay;

    @BeforeEach
    void init() {
        var display = new int[DISPLAY_SIZE][DISPLAY_SIZE];
        customDisplay = new CustomDisplay(display);
    }

    @Test
    void turnOnTest() {
        customDisplay.turnOn(new Point(10, 10), new Point(49, 49));
        customDisplay.turnOn(new Point(10, 10), new Point(49, 49));
        var lightsOn = customDisplay.computeLightsOn();
        assertEquals(3200, lightsOn);
    }

    @Test
    void turnOffTest() {
        customDisplay.turnOn(new Point(0, 0), new Point(99, 99));
        customDisplay.turnOn(new Point(10, 10), new Point(99, 99));
        customDisplay.turnOff(new Point(0, 0), new Point(109, 109));
        var lightsOn = customDisplay.computeLightsOn();
        assertEquals(8100, lightsOn);
    }

    @Test
    void toggleTest() {
        customDisplay.turnOn(new Point(0, 0), new Point(99, 99));
        customDisplay.toggle(new Point(50, 60), new Point(79, 89));
        var lightsOn = customDisplay.computeLightsOn();
        assertEquals(11800, lightsOn);
    }

    @Test
    void computeLightsTest() {
        customDisplay.turnOn(new Point(0, 0), new Point(999, 999));
        customDisplay.turnOn(new Point(0, 0), new Point(999, 999));
        var lightsOn = customDisplay.computeLightsOn();
        assertEquals(2000000, lightsOn);
    }
}
