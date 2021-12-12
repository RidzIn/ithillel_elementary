package homework_14;

public class Main {
    public static void main(String[] args) throws Exception {
        Fraction frac1 = new Fraction(10, (short) 222);
        Fraction frac2 = new Fraction(20, (short) 444);
        Fraction.subtractDecimalPart(frac1, frac2);
        Fraction.additionDecimalPart(frac1, frac2);
    }
}
