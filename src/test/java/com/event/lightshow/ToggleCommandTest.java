package com.event.lightshow;

import com.event.lightshow.command.ToggleCommand;
import com.event.lightshow.command.TurnOnCommand;
import com.event.lightshow.receiver.Display;
import com.event.lightshow.util.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ToggleCommandTest {

    @Mock
    private Display display;
    @InjectMocks
    private ToggleCommand toggleCommand;

    @Test
    void turnOnCommandTest() {
        toggleCommand.execute(new Point(0, 0), new Point(99, 99));
        verify(display).toggle(any(Point.class), any(Point.class));
    }

}
