package com.homeTask.basicKnowledge.TasksFiles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static Character firstNonRepeatingLetter(String word) {;
        List<String> letters = Arrays.stream(word.split("")).collect(Collectors.toList());
        for (int i = 0; i < word.length(); i++) {
            String letter = letters.remove(0);
            if (!(letters.contains(letter.toLowerCase()) || letters.contains(letter.toUpperCase()))) {
                return letter.charAt(0);
            }
            letters.add(letter);
        }
        return null;
    }
}
