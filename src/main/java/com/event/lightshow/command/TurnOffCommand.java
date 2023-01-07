package com.event.lightshow.command;


import com.event.lightshow.receiver.Display;
import com.event.lightshow.util.Point;

public class TurnOffCommand implements DisplayCommand {

    private final Display display;
    public static final String TURN_OFF_COMMAND_NAME = "turn off";

    public TurnOffCommand(Display display) {
        this.display = display;
    }

    @Override
    public void execute(Point leftCorner, Point rightCorner) {
        display.turnOff(leftCorner, rightCorner);
    }

}
