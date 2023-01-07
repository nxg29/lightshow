package com.event.lightshow.command;


import com.event.lightshow.receiver.Display;
import com.event.lightshow.util.Point;

public class ToggleCommand implements DisplayCommand {

    private final Display display;
    public static final String TOGGLE_COMMAND_NAME = "toggle";

    public ToggleCommand(Display display) {
        this.display = display;
    }

    @Override
    public void execute(Point leftCorner, Point rightCorner) {
        display.toggle(leftCorner, rightCorner);
    }

}
