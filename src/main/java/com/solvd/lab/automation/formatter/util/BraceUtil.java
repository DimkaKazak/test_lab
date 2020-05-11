package com.solvd.lab.automation.formatter.util;

public class BraceUtil {

    public static String normalizeSharpBraces(String input) {

        StringBuilder result = new StringBuilder();

        char[] copiedCharArray = input.toCharArray();
        for (int i = 0; i < copiedCharArray.length; i++){

            if (copiedCharArray[i] == '{'){

                if (copiedCharArray[i - 1] == ' '){
                    result.append("{\n");
                } else {
                    result.append(" {\n");
                }

            } else if (copiedCharArray[i] == '}'){
                result.append("\n}");
            } else {
                result.append(copiedCharArray[i]);
            }

        }

        return String.valueOf(result);
    }
}