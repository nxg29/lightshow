package com.event.lightshow.client;

import com.event.lightshow.command.DisplayCommand;
import com.event.lightshow.command.ToggleCommand;
import com.event.lightshow.command.TurnOffCommand;
import com.event.lightshow.command.TurnOnCommand;
import com.event.lightshow.invoker.DisplayCommandExecutor;
import com.event.lightshow.receiver.Display;
import com.event.lightshow.util.DisplayFactory;
import com.event.lightshow.util.InputParser;
import com.event.lightshow.util.Point;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static com.event.lightshow.command.ToggleCommand.TOGGLE_COMMAND_NAME;
import static com.event.lightshow.command.TurnOffCommand.TURN_OFF_COMMAND_NAME;
import static com.event.lightshow.command.TurnOnCommand.TURN_ON_COMMAND_NAME;
import static com.event.lightshow.receiver.Display.DisplayType.SIMPLE_DISPLAY;

@Slf4j
public class LightShow {
    public static void main(String[] args) throws IOException {
        // process arguments
        String fileName;
        String displayType;
        String line;

        if (args.length != 2) {
            fileName = "src/main/resources/coding_challenge_input.txt";
            displayType = SIMPLE_DISPLAY.name();
        } else {
            fileName = args[0];
            displayType = args[1];
        }

        if (Arrays.stream(Display.DisplayType.values()).map(Enum::name).noneMatch(x -> x.equalsIgnoreCase(displayType))) {
            log.error("Invalid displayType");
            throw new RuntimeException("Invalid displayType");
        }

        // process file
        var display = DisplayFactory.getDisplay(displayType);
        var turnOn = new TurnOnCommand(display);
        var turnOff = new TurnOffCommand(display);
        var toggle = new ToggleCommand(display);
        var commandExecutor = new DisplayCommandExecutor();

        var file = new File(fileName);
        var br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            var coordinates = InputParser.getCoordinates(line);
            var leftPoint = new Point(coordinates.get(0), coordinates.get(1));
            var rightPoint = new Point(coordinates.get(2), coordinates.get(3));
            DisplayCommand command;

            if (line.startsWith(TURN_ON_COMMAND_NAME)) {
                command = turnOn;
            } else if (line.startsWith(TURN_OFF_COMMAND_NAME)) {
                command = turnOff;
            } else if (line.startsWith(TOGGLE_COMMAND_NAME)) {
                command = toggle;
            } else {
                log.error("Command from line {} is not supported!", line);
                throw new RuntimeException("Invalid command");
            }

            commandExecutor.executeOperation(command, leftPoint, rightPoint);
        }

        System.out.println("RESULT = " + display.computeLightsOn());
    }
}
