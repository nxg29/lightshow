package com.event.lightshow.command;


import com.event.lightshow.receiver.Display;
import com.event.lightshow.util.Point;

public class TurnOnCommand implements DisplayCommand {

    private final Display display;
    public static final String TURN_ON_COMMAND_NAME = "turn on";

    public TurnOnCommand(Display display) {
        this.display = display;
    }

    @Override
    public void execute(Point leftCorner, Point rightCorner) {
        display.turnOn(leftCorner, rightCorner);
    }

}
