package com.solvd.lab.automation.formatter.util;

public class StatementUtil {

    public static String normalizeIfs(String input) {

        StringBuilder result = new StringBuilder();

        char[] copiedCharArray = input.toCharArray();
        for (int i = 0; i < copiedCharArray.length; i++) {

            if (copiedCharArray[i] == 'i' && copiedCharArray[i + 1] == 'f'
                    && (copiedCharArray[i + 2] == ' ' || copiedCharArray[i + 2] == '(')) {

                result.append("if ");
                int indexOfBrace = input.indexOf('{', i);
                result.append( input.substring( i + 2, indexOfBrace ) );

                if(copiedCharArray[indexOfBrace - 1] == ' '){
                    result.append("{");
                } else {
                    result.append(" {");
                }


                i = indexOfBrace;
            }
            else {
                result.append(copiedCharArray[i]);
            }
        }

        return String.valueOf(result);
    }



    public static String normalizeFors(String input) {
        StringBuilder result = new StringBuilder();

        char[] copiedCharArray = input.toCharArray();
        for (int i = 0; i < copiedCharArray.length; i++) {

            if (copiedCharArray[i] == 'f' && copiedCharArray[i + 1] == 'o' && copiedCharArray[i + 2] == 'r'
                    && (copiedCharArray[i + 3] == ' ' || copiedCharArray[i + 3] == '(')) {

                result.append("for ");
                int indexOfBrace = input.indexOf('{', i);
                result.append( input.substring( i + 3, indexOfBrace ) );

                if(copiedCharArray[indexOfBrace - 1] == ' '){
                    result.append("{");
                } else {
                    result.append(" {");
                }


                i = indexOfBrace;
            }
            else {
                result.append(copiedCharArray[i]);
            }
        }

        return String.valueOf(result);
    }

    public static String normalizeSemicolons(String input) {
        StringBuilder result = new StringBuilder();

        char[] copiedCharArray = input.toCharArray();
        for (int i = 0; i < copiedCharArray.length; i++) {

            if (copiedCharArray[i] == ';') {

                if(copiedCharArray[i + 1] != '\n'){
                    result.append(";\n");
                } else {
                    result.append(";");
                }

            }
            else {
                result.append(copiedCharArray[i]);
            }
        }

        return String.valueOf(result);
    }
}
