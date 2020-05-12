package com.solvd.lab.automation.formatter.util;

public class StatementUtil {

    public static String normalizeStatement(String input, String statement){
        StringBuilder result = new StringBuilder();

        char[] copiedCharArray = input.toCharArray();
        for (int i = 0; i < copiedCharArray.length; i++) {

            if (validateStatement(copiedCharArray, i, statement)){

                switch (statement){
                    case "if": result.append("if "); break;
                    case "for": result.append("for "); break;
                }

                int indexOfBrace = input.indexOf('{', i);
                result.append( input.substring( i + statement.length(), indexOfBrace ) );

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

    private static boolean validateStatement(char[] elem, int pos, String statement){
        switch (statement){
            case "for": return elem[pos] == 'f' && elem[pos + 1] == 'o' && elem[pos + 2] == 'r'
                    && (elem[pos + 3] == ' ' || elem[pos + 3] == '(');

            case "if": return elem[pos] == 'i' && elem[pos + 1] == 'f'
                    && (elem[pos + 2] == ' ' || elem[pos + 2] == '(');

            default: return false;
        }
    }
}
