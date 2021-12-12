package homework_06;

import java.util.ArrayList;


public class Main {
    static ArrayList<Integer> numberList = new ArrayList<Integer>();
    static ArrayList<Character> charList = new ArrayList<Character>();

    public static void main(String[] args) {
        numberList.add(1);
        recFunction(301);
        printList();
    }

    public static ArrayList<Integer> recFunction(int number) {
        if (number == 1) {
            return numberList;
        } else if (number > 0) {
            if (number % 3 == 0) {
                numberList.add(3);
                charList.add('*');
                recFunction(number / 3);
            } else {
                numberList.add(5);
                charList.add('+');
                recFunction(number - 5);
            }
        } else {
            System.out.println("This number impossible to represent");
            System.exit(1);
        }
        return numberList;
    }

    public static void printList() {
        for (int j = 0; j < numberList.size(); j++) {
            System.out.print("(");
        }
        for (int i = 0; i < numberList.size(); i++) {

            if (i >= 1 && i < charList.size()) {
                System.out.print(numberList.get(i) + ")" + charList.get(i) + " ");
            }
            if (i == 0) {
                System.out.print(numberList.get(i) + " " + charList.get(i) + " ");
            }
            if (i >= charList.size()) {
                System.out.print(numberList.get(i) + ")");
            }
        }
    }
}
