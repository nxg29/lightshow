package com.event.lightshow.command;


import com.event.lightshow.util.Point;

public interface DisplayCommand {
    void execute(Point leftCorner, Point rightCorner);
}
