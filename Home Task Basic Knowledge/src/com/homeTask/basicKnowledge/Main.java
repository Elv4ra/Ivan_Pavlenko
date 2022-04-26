package com.homeTask.basicKnowledge;

import com.homeTask.basicKnowledge.AdditionalTasksFiles.AdditionalTask1;
import com.homeTask.basicKnowledge.AdditionalTasksFiles.AdditionalTask2;
import com.homeTask.basicKnowledge.TasksFiles.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nTask 1:");
        System.out.println("{1, 2, \"a\", \"1\"} => " + Task1.getIntegersFromList(Arrays.asList(1, 2, "a", "1")));
        System.out.println("{\"Hello\", 1, 123, \"a\", \"world\", \"3\", 2} => " + Task1.getIntegersFromList(Arrays.asList("Hello", 1, 123, "a", "world", "3", 2)));
        System.out.println("{\"Hello\", \"a\", \"world\", \"3\"} => " + Task1.getIntegersFromList(Arrays.asList("Hello", "a", "world", "3")));
        System.out.println("{1, 2, 3, 47} => " + Task1.getIntegersFromList(Arrays.asList(1, 2, 3, 47)));


        System.out.println("\nTask 2:");
        System.out.println("hello => " + Task2.firstNonRepeatingLetter("hello"));
        System.out.println("stress => " + Task2.firstNonRepeatingLetter("stress"));
        System.out.println("ss => " + Task2.firstNonRepeatingLetter("ss"));
        System.out.println("sss => " + Task2.firstNonRepeatingLetter("sss"));
        System.out.println("123 => " + Task2.firstNonRepeatingLetter("123"));
        System.out.println("1123235 => " + Task2.firstNonRepeatingLetter("1123235"));
        System.out.println("@#@#$%$* => " + Task2.firstNonRepeatingLetter("@#@#$%$*"));
        System.out.println("sTreSS => " + Task2.firstNonRepeatingLetter("sTreSS"));


        System.out.println("\nTask 3:");
        System.out.println("16 => " + Task3.getDigitalRoot(16));
        System.out.println("942 => " + Task3.getDigitalRoot(942));
        System.out.println("132189 => " + Task3.getDigitalRoot(132189));
        System.out.println("493193 => " + Task3.getDigitalRoot(493193));
        System.out.println("111111 => " + Task3.getDigitalRoot(111111));
        System.out.println("101010 => " + Task3.getDigitalRoot(101010));
        System.out.println("900009 => " + Task3.getDigitalRoot(900009));


        System.out.println("\nTask 4:");
        System.out.println("{1, 3, 6, 2, 2, 0, 4, 5} => " + Task4.countNumberOfPairs(new Integer[]{1, 3, 6, 2, 2, 0, 4, 5}, 5)); //4
        System.out.println("{1, 5, 7, -1} => " + Task4.countNumberOfPairs(new Integer[]{1, 5, 7, -1}, 6)); //2
        System.out.println("{1, 5, 7, -1, 5} => " + Task4.countNumberOfPairs(new Integer[]{1, 5, 7, -1, 5}, 6)); //3
        System.out.println("{1, 1, 1, 1} => " + Task4.countNumberOfPairs(new Integer[]{1, 1, 1, 1}, 2)); //6
        System.out.println("{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1} => " +
                Task4.countNumberOfPairs(new Integer[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}, 11)); //9


        System.out.println("\nTask 4 (stream api):");
        System.out.println("{1, 3, 6, 2, 2, 0, 4, 5} => " + Task4.countNumberOfPairsByStream(new Integer[]{1, 3, 6, 2, 2, 0, 4, 5}, 5)); //4
        System.out.println("{1, 5, 7, -1} => " + Task4.countNumberOfPairsByStream(new Integer[]{1, 5, 7, -1}, 6)); //2
        System.out.println("{1, 5, 7, -1, 5} => " + Task4.countNumberOfPairsByStream(new Integer[]{1, 5, 7, -1, 5}, 6)); //3
        System.out.println("{1, 1, 1, 1} => " + Task4.countNumberOfPairsByStream(new Integer[]{1, 1, 1, 1}, 2)); //6
        System.out.println("{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1} => " +
                Task4.countNumberOfPairsByStream(new Integer[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}, 11)); //9



        System.out.println("\nTask 5:");
        String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjorn:Tornbull;Raphael:Corwill;Alfred:Corwill;Ivan:Pavlenko;Mykola:Pavlenko";
        System.out.println(s + " =>\n" + Task5.convertInvitationList(s));

        System.out.println("\nAdditional Task 1:");
        System.out.println("12 => " + AdditionalTask1.nextBigger(12));
        System.out.println("513 => " + AdditionalTask1.nextBigger(513));
        System.out.println("2017 => " + AdditionalTask1.nextBigger(2017));
        System.out.println("111 => " + AdditionalTask1.nextBigger(111));
        System.out.println("9 => " + AdditionalTask1.nextBigger(9));
        System.out.println("1234 => " + AdditionalTask1.nextBigger(1234));
        System.out.println("4321 => " + AdditionalTask1.nextBigger(4321));
        System.out.println("536479 => " + AdditionalTask1.nextBigger(536479));


        System.out.println("\nAdditional Task 2:");
        System.out.println("2149583361 => " + AdditionalTask2.getIpAddress(2149583361L));
        System.out.println("4294967295 => " + AdditionalTask2.getIpAddress(4294967295L));
        System.out.println("4294967296 => " + AdditionalTask2.getIpAddress(4294967296L));
        System.out.println("32 => " + AdditionalTask2.getIpAddress(32L));
        System.out.println("0 => " + AdditionalTask2.getIpAddress(0L));
    }
}
