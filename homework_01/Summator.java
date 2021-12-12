package homework_01;

public class Summator {
    public static void main(String[] args) {

        sumator(args);

    }

    static void sumator(String[] args) {
        try {
            int firstNumber = Integer.parseInt(args[0]);
            int secondNumber = Integer.parseInt(args[1]);
            int result = firstNumber + secondNumber;

            System.out.println("Result: " + args[0] + " + " + args[1] + " = " + result);
        } catch (NumberFormatException e) {
            System.out.println("You wrote invalid numbers!!!");
        }
    }
}
