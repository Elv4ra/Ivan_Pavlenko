package com.homeTask.basicKnowledge.AdditionalTasksFiles;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AdditionalTask1 {
    public static Integer nextBigger(Integer number) {
        Integer[] numberArr = Arrays.stream(number.toString().split("")).map(Integer::valueOf).toArray(Integer[]::new);
        int lowerElementIndex = 0;
        for (int i = numberArr.length - 1; i > 0; i--) {
            if (numberArr[i] > numberArr[i-1]) {
                lowerElementIndex = i;
                break;
            }
        }
        if (lowerElementIndex == 0) {
            return -1;
        }
        int lowerElement = numberArr[lowerElementIndex - 1], minElementIndex = lowerElementIndex;
        for (int j = lowerElementIndex + 1; j < numberArr.length; j++) {
            if (numberArr[j] > lowerElement && numberArr[j] < numberArr[minElementIndex]) {
                minElementIndex = j;
            }
        }
        numberArr[lowerElementIndex - 1] = numberArr[minElementIndex];
        numberArr[minElementIndex] = lowerElement;
        Arrays.sort(numberArr, lowerElementIndex, numberArr.length);
        return Integer.valueOf(Arrays.stream(numberArr).map(String::valueOf).collect(Collectors.joining()));
    }
}
