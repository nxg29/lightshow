package com.event.lightshow;

import com.event.lightshow.util.InputParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputParserTest {

    @Test
    void getCoordinatesTest() {
        var line = "turn on 268,631 through 735,814";
        var expectedCoordinates = List.of(268, 631, 735, 814);
        var actualCoordinates = InputParser.getCoordinates(line);
        assertEquals(expectedCoordinates, actualCoordinates);
    }
}
