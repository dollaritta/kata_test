import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerException, NumberFormatException {
        System.out.print("Введите выражение:");
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        System.out.println(calc(line));
    }

    public static String calc(String line) throws ScannerException, NumberFormatException {
        char testChar;
        int answer = 0, romeAnswerInt = 0;
        String romeAnswerStr = "";
        String AnswerStr = "";
        //String line = "";
        Boolean fValueIsFull = false;
        Boolean isOperator = false;
        Boolean mathOperatorIsFull = false;
        String firstString = "", secondString = "", neededOperator = "";
        String[] mOperators = new String[4];
        mOperators[0] = "+";
        mOperators[1] = "-";
        mOperators[2] = "*";
        mOperators[3] = "/";
        String[] RomanNumArray = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] RomanNumArrayAnswer = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C",};




        for (int i = 0; i <= line.length() - 1; i++) {
            testChar = line.charAt(i);
            // System.out.println("Iteration: " + i + "Char is: " + testChar);
            if (Arrays.asList(mOperators).contains(Character.toString(testChar))) {
                if (neededOperator != "") {
                    throw new ScannerException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
                neededOperator = Character.toString(testChar);
                fValueIsFull = true;
                i = i + 1;
                testChar = line.charAt(i);
                mathOperatorIsFull = true;
            }
            if (fValueIsFull) {
                secondString = secondString + Character.toString(testChar);
            } else {
                firstString = firstString + Character.toString(testChar);
            }


        }
        //System.out.println("FirstString is " + firstString);
        //System.out.println("SecondString is " + secondString);
        //System.out.println("Operator is " + neededOperator);


        boolean fIsRoman = false;
        boolean sIsRoman = false;
        int indexOfFirstRomeNum = 0;
        int indexOfSecondRomeNum = 0;
        for (int i = 0; i <= 9; i++) {
            if (firstString.equals(RomanNumArray[i])) {
                fIsRoman = true;
                indexOfFirstRomeNum = i + 1;
            }
            if (secondString.equals(RomanNumArray[i])) {
                sIsRoman = true;
                indexOfSecondRomeNum = i + 1;
            }
        }

       // System.out.println(fIsRoman);
        //System.out.println(sIsRoman);
        if (!fIsRoman & !sIsRoman) {
            if (Integer.parseInt(firstString) < 1 | Integer.parseInt(firstString) > 10 | Integer.parseInt(secondString) < 1 | Integer.parseInt(secondString) > 10) {
                throw new ScannerException("Числа должны быть от 1 до 10");
            }
        }

        if ((fIsRoman & !sIsRoman) | (!fIsRoman & sIsRoman)) {
            throw new ScannerException("Калькулятор работает либо с арабскими либо с римскими числами одновремено");
        }
        if (fIsRoman & sIsRoman) {
            switch (neededOperator) {
                case "+":
                    romeAnswerInt = indexOfFirstRomeNum + indexOfSecondRomeNum;
                    break;
                case "-":
                    romeAnswerInt = indexOfFirstRomeNum - indexOfSecondRomeNum;
                    break;
                case "*":
                    romeAnswerInt = indexOfFirstRomeNum * indexOfSecondRomeNum;
                    break;
                case "/":
                    romeAnswerInt = indexOfFirstRomeNum / indexOfSecondRomeNum;
                    break;
            }
            if (romeAnswerInt - 1 < 1) {
                throw new ScannerException("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
            }
            // System.out.println("Answer is: " + RomanNumArrayAnswer[romeAnswerInt - 1]);
            AnswerStr = RomanNumArrayAnswer[romeAnswerInt - 1];
        } else {

            switch (neededOperator) {
                case "+":
                    answer = Integer.valueOf(firstString) + Integer.valueOf(secondString);
                    break;
                case "-":
                    answer = Integer.valueOf(firstString) - Integer.valueOf(secondString);
                    break;
                case "*":
                    answer = Integer.valueOf(firstString) * Integer.valueOf(secondString);
                    break;
                case "/":
                    answer = Integer.valueOf(firstString) / Integer.valueOf(secondString);
                    break;
            }
            //System.out.println("Answer is: " + answer);
            AnswerStr = String.valueOf(answer);
        }
        //System.out.println("Answer is : " + AnswerStr);
        return AnswerStr;
    }
}
