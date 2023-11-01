package com.tdd.incubyte.tddforincubyte.utils.string;

public class StringCalculatorUtils {
    public static int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            delimiter = parts[0].substring(2);
            numbers = parts[1];
        }

        String[] nums = numbers.split(delimiter);
        int sum = 0;
        StringBuilder negativeNumbers = new StringBuilder();

        for (String num : nums) {
            int n = Integer.parseInt(num);
            if (n < 0) {
                if (negativeNumbers.length() > 0) {
                    negativeNumbers.append(", ");
                }
                negativeNumbers.append(n);
            } else if (n <= 1000) {
                sum += n;
            }
        }

        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }

        return sum;
    }
}
