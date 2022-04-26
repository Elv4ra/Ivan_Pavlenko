package com.homeTask.basicKnowledge.TasksFiles;

import java.util.Arrays;

public class Task3 {
    public static Integer getDigitalRoot(Integer number) {
        while (number / 10 >= 1) {
            number = Arrays.stream(number.toString().split("")).mapToInt(Integer::valueOf).sum();
        }
        return number;
    }
}
