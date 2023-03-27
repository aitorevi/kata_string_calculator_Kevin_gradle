package org.example;

        import org.apache.commons.lang3.StringUtils;

        import java.util.Arrays;

public class StringCalculatorKevinGradle {
    public StringCalculatorKevinGradle() {
        throw new UnsupportedOperationException();
    }
    public static Integer sum(String expression) {
        String delimiter = ",";
        final String customDelimiterPrefix = "//";
        if (expression.startsWith(customDelimiterPrefix)) {
            delimiter = getCustomDelimiter(expression);
            expression = removeCustomDelimiter(expression);
        }
        return sumNumbers(expression, delimiter);
    }

    private static String getCustomDelimiter(String expression) {
        final int customDelimiterPosition = 2;
        return expression.split("")[customDelimiterPosition];
    }

    private static String removeCustomDelimiter(String expression) {
        final int lastCustomDelimiterPosition = 4;
        expression = expression.substring(lastCustomDelimiterPosition);
        return expression;
    }

    private static Integer sumNumbers(String expression, String delimiter) {
        return Arrays.stream(expression.split(delimiter))
                .map(String::trim)
                .filter(StringUtils::isNumeric)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}