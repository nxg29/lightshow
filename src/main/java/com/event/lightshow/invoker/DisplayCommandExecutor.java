package com.event.lightshow.invoker;


import com.event.lightshow.command.DisplayCommand;
import com.event.lightshow.util.Point;

public class DisplayCommandExecutor {
    public void executeOperation(DisplayCommand command, Point leftPoint, Point rightPoint) {
        command.execute(leftPoint, rightPoint);
    }

}
