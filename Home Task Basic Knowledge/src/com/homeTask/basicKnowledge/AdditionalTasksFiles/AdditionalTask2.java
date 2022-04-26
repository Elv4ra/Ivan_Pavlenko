package com.homeTask.basicKnowledge.AdditionalTasksFiles;

public class AdditionalTask2 {
    public static String getIpAddress(Long number) {
        StringBuilder result = new StringBuilder();
        result.append(Long.toBinaryString(number));
        while (result.length() < 32) {
            result.insert(0, '0');
        }
        if (result.length() > 32) {
            result.deleteCharAt(0);
        }
        String binaryCode = result.substring(0, 32);
        result.delete(0, result.length());
        for (int i = 0; i < 4; i++) {
            result.append(Integer.parseInt(binaryCode.substring(8*i, 8*i+8), 2)).append(".");
        }
        return result.deleteCharAt(result.lastIndexOf(".")).toString();
    }
}
