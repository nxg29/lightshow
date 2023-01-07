package com.event.lightshow.util;

import com.event.lightshow.receiver.CustomDisplay;
import com.event.lightshow.receiver.Display;
import com.event.lightshow.receiver.SimpleDisplay;

import static com.event.lightshow.receiver.Display.DISPLAY_SIZE;
import static com.event.lightshow.receiver.Display.DisplayType.CUSTOM_DISPLAY;
import static com.event.lightshow.receiver.Display.DisplayType.SIMPLE_DISPLAY;

public class DisplayFactory {
    public static Display getDisplay(String displayType) {
        var display = new int[DISPLAY_SIZE][DISPLAY_SIZE];
        if (SIMPLE_DISPLAY.name().equalsIgnoreCase(displayType)) {
            return new SimpleDisplay(display);
        } else if (CUSTOM_DISPLAY.name().equalsIgnoreCase(displayType)) {
            return new CustomDisplay(display);
        }
        throw new RuntimeException("Invalid displayType");
    }
}
