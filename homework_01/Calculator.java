package homework_01;

public class Calculator {
    public static void main(String[] args) {
        consoleOut(args);
    }

    public static void consoleOut(String[] args) {
        try {
            int firstNumber = Integer.parseInt(args[0]);
            int secondNumber = Integer.parseInt(args[2]);

            int resultPlus = firstNumber + secondNumber;
            int resultMinus = firstNumber - secondNumber;
            int resultDivide = firstNumber / secondNumber;
            int resultMultiply = firstNumber * secondNumber;

            String textPattern = args[0] + " " + args[1] + " " + args[2] + " = ";

            switch (args[1]) {
                case "plus":
                    System.out.println(textPattern + resultPlus);
                    break;
                case "minus":
                    System.out.println(textPattern + resultMinus);
                    break;
                case "divide":
                    System.out.println(textPattern + resultDivide);
                    break;
                case "multiply":
                    System.out.println(textPattern + resultMultiply);
                    break;
                default:
                    System.out.println("Wrong arguments!");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("You wrote invalid params!");
        }

    }

}
