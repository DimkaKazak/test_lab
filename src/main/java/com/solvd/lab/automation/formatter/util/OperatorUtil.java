package com.solvd.lab.automation.formatter.util;

public class OperatorUtil {

    public static String normalizeByOperator(String input, char operator){
        StringBuilder result = new StringBuilder();

        char[] copiedCharArray = input.toCharArray();

        for (int i = 0; i < copiedCharArray.length; i++) {

            if(validateOperator(copiedCharArray, i, operator)){
                result.append(' ');
                result.append(operator);
                result.append(' ');
            }
            else {
                result.append(copiedCharArray[i]);
            }

        }

        return String.valueOf(result);
    }

    private static boolean validateOperator(char[] elems, int pos ,char operator){
        if (operator == '='){
            return elems[pos] == '=' && (elems[pos + 1] != '=' || elems[pos + 2] != '=');
        }

        return elems[pos] == operator;
    }
}
