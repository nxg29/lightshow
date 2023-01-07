package com.event.lightshow.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class InputParser {
    public static List<Integer> getCoordinates(String line) {
        line = line.replaceAll("[^0-9]", " ");
        line = line.replaceAll(" +", " ");
        var tokens = line.trim().split(" ");
        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
