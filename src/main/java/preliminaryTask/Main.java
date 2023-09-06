package main.java.preliminaryTask;
import main.java.preliminaryTask.util.RomanNumerals;
import java.util.Scanner;

public class Main {
    static String rim = "^(I|II|III|IV|V|VI|VII|VIII|IX|X)$+";
    static String arab = "^[1-9]|10$";
    static String errorCheck = "^\\d+(?:\\.\\d+)?(?:[-+]\\d+(?:\\.\\d+)?)+$";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            System.out.println(calc(input));
        }
    }

    public static String calc(String input) {
        String[] arrayInput = input.split("[+\\-*/]");
        String answerFin = "";
        if ((arrayInput.length == 2 && arrayInput[0].matches(arab) && arrayInput[1].matches(arab))
                || (arrayInput.length == 2 && arrayInput[0].matches(rim) &&
                arrayInput[1].matches(rim))) {
            if (input.contains("+")) {
                String[] str = input.split("\\+");
                if (str[0].matches(arab) && str[1].matches(arab)) {
                    answerFin = (Integer.parseInt(str[0]) + Integer.parseInt(str[1])) + "";
                } else if (str[0].matches(rim) &&
                        str[1].matches(rim)) {
                    int num0 = RomanNumerals.valueOf("NUM" + str[0]).getRomanNum();
                    int num1 = RomanNumerals.valueOf("NUM" + str[1]).getRomanNum();
                    int result = num0 + num1;
                    answerFin = arabToRim(result);
                }
            } else if (input.contains("-")) {
                String[] str = input.split("-");
                if (str[0].matches(arab) && str[1].matches(arab)) {
                    answerFin = (Integer.parseInt(str[0]) - Integer.parseInt(str[1])) + "";
                } else if (str[0].matches(rim) &&
                        str[1].matches(rim)) {
                    int num0 = RomanNumerals.valueOf("NUM" + str[0]).getRomanNum();
                    int num1 = RomanNumerals.valueOf("NUM" + str[1]).getRomanNum();
                    if (num0 <= num1) {
                        throw new IllegalArgumentException("в римской системе нет отрицательных чисел ( и нуля)");
                    }
                    int result = num0 - num1;
                    answerFin = arabToRim(result);
                }
            } else if (input.contains("*")) {
                String[] str = input.split("\\*");
                if (str[0].matches(arab) && str[1].matches(arab)) {
                    answerFin = (Integer.parseInt(str[0]) * Integer.parseInt(str[1])) + "";
                } else if (str[0].matches(rim) &&
                        str[1].matches(rim)) {
                    int num0 = RomanNumerals.valueOf("NUM" + str[0]).getRomanNum();
                    int num1 = RomanNumerals.valueOf("NUM" + str[1]).getRomanNum();
                    int result = num0 * num1;
                    answerFin = arabToRim(result);
                }
            } else if (input.contains("/")) {
                String[] str = input.split("/");
                if (str[0].matches(arab) && str[1].matches(arab)) {
                    answerFin = (Integer.parseInt(str[0]) / Integer.parseInt(str[1])) + "";
                } else if (str[0].matches(rim) &&
                        str[1].matches(rim)) {
                    int num0 = RomanNumerals.valueOf("NUM" + str[0]).getRomanNum();
                    int num1 = RomanNumerals.valueOf("NUM" + str[1]).getRomanNum();
                    int result = num0 / num1;
                    answerFin = arabToRim(result);
                }
            }
        } else {
            if ((arrayInput[0].matches(arab) && arrayInput[1].matches("rim")
                    || (arrayInput[0].matches(rim) && arrayInput[1].matches(arab)))) {
                throw new IllegalArgumentException("используются одновременно разные системы счисления");
            }
            if (input.matches(errorCheck)) {
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию");
            } else {
                throw new ArithmeticException("не является математической операцией");
            }
        }
        return answerFin;
    }

    static String arabToRim(int n) {
        int[] arrayArabNumbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] arrayRimNumbers = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        String result = "";
        for (int i = 0; i < arrayArabNumbers.length; i++) {
            while (n >= arrayArabNumbers[i]) {
                n = n - arrayArabNumbers[i];
                result = result + arrayRimNumbers[i];
            }
        }
        return result;
    }

}
