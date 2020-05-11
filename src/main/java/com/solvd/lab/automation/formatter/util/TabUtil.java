package com.solvd.lab.automation.formatter.util;

public class TabUtil {

    public static String normalizeTabs(String input) {
        String[] resultArray = input.split("\n");

        for (int i = resultArray.length - 1; i > 0; i--){

            if(resultArray[i].contains("}")){
                int leftBracketsCounter = 0;
                int rightBracketsCounter = 1;
                int j = i - 1;

                while (leftBracketsCounter != rightBracketsCounter){

                    resultArray[j] = "\t" + resultArray[j];

                    if (resultArray[j].contains("{")){
                        leftBracketsCounter++;
                    }

                    if (resultArray[j].contains("}")){
                        rightBracketsCounter++;
                    }
                    j--;
                }
            }
        }

        for (int i = 0; i < resultArray.length; i++){
            if(resultArray[i].contains("{")){
                resultArray[i] = resultArray[i].replaceFirst("\t", "");
            }
        }

        StringBuilder result = new StringBuilder();
        for (String element : resultArray){
            result.append(element);
            result.append("\n");
        }

        return String.valueOf(result);
    }
}