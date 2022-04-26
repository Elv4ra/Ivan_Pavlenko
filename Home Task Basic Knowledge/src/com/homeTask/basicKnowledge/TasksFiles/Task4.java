package com.homeTask.basicKnowledge.TasksFiles;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Task4 {
    public static Integer countNumberOfPairs(Integer[] array, Integer target) {
        HashMap<Integer, Integer> amountOfNumbers = new HashMap<>();
        Integer result = 0;
        for (Integer number : array) {
            if (amountOfNumbers.containsKey(number)) {
                amountOfNumbers.put(number, amountOfNumbers.get(number)+1);
                continue;
            }
            amountOfNumbers.put(number, 1);
        }
        for (Integer number : array) {
            if (amountOfNumbers.get(target - number) != null) {
                result +=amountOfNumbers.get(target-number);
            }
            if (target - number == number) {
                result--;
            }
        }
        return result / 2;
    }

    public static Long countNumberOfPairsByStream(Integer[] array, Integer target) {
        return IntStream.range(0, array.length)
                .mapToLong(i -> IntStream.range(i+1, array.length)
                        .filter(j -> i != j && array[i] + array[j] == target).count()).sum();
    }
}
