package com.solvd.lab.automation.formatter;

import com.solvd.lab.automation.formatter.util.*;

public class Formatter {
    public static void main(String[] args) {
        String input = "public class NoSuchTransport extends Exception{public NoSuchTransport(String message) {super(message);if(aaa){aaa+b=5;return b;}}}";
        
        input = BraceUtil.normalizeSharpBraces(input);
        input = StatementUtil.normalizeStatement(input, "if");
        input = StatementUtil.normalizeStatement(input, "for");
        input = StatementUtil.normalizeSemicolons(input);

        input = OperatorUtil.normalizeByOperator(input, '+');
        input = OperatorUtil.normalizeByOperator(input, '-');
        input = OperatorUtil.normalizeByOperator(input, '*');
        input = OperatorUtil.normalizeByOperator(input, '/');
        input = OperatorUtil.normalizeByOperator(input, '=');

        // input = SpaceUtil.normalizeSpaces(input);
        input = TabUtil.normalizeTabs(input);

        System.out.println(input);

    }
}
