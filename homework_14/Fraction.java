package homework_14;

import java.util.Arrays;

public class Fraction {

    private int intPart;
    private int decimalPart;

    public Fraction(int intPart, short decimalPart) throws Exception {
        if (decimalPart < Short.MAX_VALUE && decimalPart >= 0) {
            this.decimalPart = decimalPart;
            this.intPart = intPart;
        } else {
            throw new Exception("The number you are trying to input is invalid");
        }
    }

    public int getIntPart() {
        return intPart;
    }

    public int getDecimalPart() {
        return decimalPart;
    }

    public void setDecimalPart(int decimalPart) {
        this.decimalPart = decimalPart;
    }

    private static int countOfDigitForObject(Fraction num1) {
        int x = num1.getDecimalPart();
        int counter = 1;
        while (x / 10 != 0) {
            x /= 10;
            counter++;
        }
        return counter;
    }

    public static int countOfDigitForNumber(int num) {
        int x = num;
        int counter = 1;
        while (x / 10 != 0) {
            x /= 10;
            counter++;
        }
        return counter;
    }

    public static int additionIntegerPart(Fraction num1, Fraction num2) {
        return num1.intPart + num2.intPart;
    }

    public static int subtractIntegerPart(Fraction num1, Fraction num2) {
        return num1.getIntPart() - num2.getIntPart();
    }

    public static void subtractDecimalPart(Fraction num1, Fraction num2) {
        int[] resultArr = new int[2];
        int copyDecimalPartOfLesserNumber = lesserNumberToSameCountOfDigits(num1, num2);

        if (lesserNumber(num1, num2) == num1) {
            num1.setDecimalPart(copyDecimalPartOfLesserNumber);
        } else {
            num2.setDecimalPart(copyDecimalPartOfLesserNumber);
        }
        resultArr[0] = subtractIntegerPart(num1, num2);

        if (subtractIntegerPart(num1, num2) > 0) {
            if (num1.getDecimalPart() - num2.getDecimalPart() < 0) {
                resultArr[0]--;
                resultArr[1] = Fraction.tenToPower(1, countOfDigitForNumber(copyDecimalPartOfLesserNumber)) + (num1.getDecimalPart() - num2.getDecimalPart());
            } else {
                resultArr[1] = num1.getDecimalPart() - num2.getDecimalPart();
            }
        } else {
            if (num1.getDecimalPart() - num2.getDecimalPart() > 0) {
                resultArr[0]++;
                resultArr[1] = Fraction.tenToPower(1, countOfDigitForNumber(copyDecimalPartOfLesserNumber)) - (num1.getDecimalPart() - num2.getDecimalPart());
            } else {
                resultArr[1] = num1.getDecimalPart() - num2.getDecimalPart();
            }
        }
        System.out.println(Arrays.toString(resultArr));
    }

    public static int lesserNumberToSameCountOfDigits(Fraction num1, Fraction num2) {
        int maxDigit = Math.max(countOfDigitForObject(num1), countOfDigitForObject(num2));
        int minDigit = Math.min(countOfDigitForObject(num1), countOfDigitForObject(num2));
        int copyDecimalPartOfLesserNumber = lesserNumber(num1, num2).getDecimalPart();
        for (int i = 0; i < maxDigit - minDigit; i++) {
            copyDecimalPartOfLesserNumber *= 10;
        }
        return copyDecimalPartOfLesserNumber;
    }

    public static void additionDecimalPart(Fraction num1, Fraction num2) { // сделать потом ретенг на массив
        int[] resultArr = new int[2];
        int copyDecimalPartOfLesserNumber = lesserNumberToSameCountOfDigits(num1, num2);
        copyDecimalPartOfLesserNumber = copyDecimalPartOfLesserNumber + biggerNumber(num1, num2).getDecimalPart();
        resultArr[0] = additionIntegerPart(num1, num2);
        if (countOfDigitForNumber(copyDecimalPartOfLesserNumber) > Math.max(countOfDigitForObject(num1), countOfDigitForObject(num2))) {
            copyDecimalPartOfLesserNumber = copyDecimalPartOfLesserNumber - tenToPower(1, Math.max(countOfDigitForObject(num1), countOfDigitForObject(num2)));
            resultArr[0]++;
        }
        resultArr[1] = copyDecimalPartOfLesserNumber;
        System.out.println(Arrays.toString(resultArr));
    }

    private static int tenToPower(int num, int power) {
        for (int i = 0; i < power; i++) {
            num *= 10;
        }
        return num;
    }

    public static Fraction lesserNumber(Fraction num1, Fraction num2) {
        if (countOfDigitForObject(num1) >= countOfDigitForObject(num2)) {
            return num2;
        } else {
            return num1;
        }
    }

    public static Fraction biggerNumber(Fraction num1, Fraction num2) {
        if (countOfDigitForObject(num1) >= countOfDigitForObject(num2)) {
            return num1;
        } else {
            return num2;
        }
    }
}
