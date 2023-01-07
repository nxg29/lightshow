package com.event.lightshow;

import com.event.lightshow.command.DisplayCommand;
import com.event.lightshow.command.TurnOnCommand;
import com.event.lightshow.receiver.Display;
import com.event.lightshow.receiver.SimpleDisplay;
import com.event.lightshow.util.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TurnOnCommandTest {

    @Mock
    private Display display;
    @InjectMocks
    private TurnOnCommand turnOnCommand;

    @Test
    void turnOnCommandTest() {
        turnOnCommand.execute(new Point(0, 0), new Point(99, 99));
        verify(display).turnOn(any(Point.class), any(Point.class));
    }

}
