package com.homeTask.basicKnowledge.TasksFiles;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Task5 {
    public static String convertInvitationList(String invitationList) {
        StringBuilder result = new StringBuilder();
        Arrays.stream(invitationList.toUpperCase().split(";")).collect(
                        TreeMap::new,
                        (TreeMap<String, TreeSet<String>> map, String s) -> map.put(s.split(":")[1],
                                map.containsKey(s.split(":")[1]) ?
                                        map.get(s.split(":")[1]).add(s.split(":")[0]) ? map.get(s.split(":")[1]) : null :
                                        new TreeSet<>(List.of(s.split(":")[0]))),
                        TreeMap::putAll)
                .forEach((key, values) -> values.forEach(value -> result.append("(").append(key).append(", ").append(value).append(")")));
        return result.toString();
    }
}
