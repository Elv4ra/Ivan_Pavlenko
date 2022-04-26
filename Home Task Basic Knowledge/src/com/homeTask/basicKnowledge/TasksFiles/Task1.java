package com.homeTask.basicKnowledge.TasksFiles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static List<Integer> getIntegersFromList(List<?> list) {
        return list.stream().filter(o -> o instanceof Integer).collect(ArrayList::new,
                (intList, item) -> intList.add((Integer) item),
                ArrayList::addAll);
    }
}
