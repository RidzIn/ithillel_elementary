package homework_02;

import java.util.Arrays;
import java.util.Scanner;


public class Krestiki {


    static String[][] _2DArray = new String[3][3];
    static Scanner sc = new Scanner(System.in);
    static int step = 0;


    public static void main(String[] args) {


        playKrestikiNoliki();


    }

    private static void printAnArray() {

        for (String[] strings : _2DArray) {

            System.out.print("\t\t  ");
            for (String string : strings) {
                System.out.print(" " + string + " ");
            }
            System.out.println();

        }
    }

    private static void rules() {
        System.out.println(
                "Выигрывает тот, кто первым соберёт три крестика " +
                        "или три нолика расположенных в одну строку, один столбец " +
                        "или по диагонали.\n"

        );


    }

    private static void roll() {
        System.out.println("Выберите орел или решка,чтобы решить кто ходит первым.");
        String[] coinArr = new String[]{"Орел", "Решка"};


        System.out.println("Выпал(a): " + coinArr[(int) Math.round(Math.random())]);
    }

    private static void makeAMove() {

        System.out.println("Выберете ряд: ");
        int row = sc.nextInt();
        System.out.println("Выберете колонну");
        int column = sc.nextInt();

        if (column >= 0 && column <= 2 && row >= 0 && row <= 2) {
            if (_2DArray[row][column].equals("-")) {
                step++;
                _2DArray[row][column] = step();
                System.out.println("\t\t Ход Номер " + step);
            } else {
                System.out.println("Данное поле уже занято, введите другое!");
                makeAMove();
            }

        } else {
            System.out.println("Вы вышли за диапазон!");
            makeAMove();
        }

    }

    private static String step() {
        if (step % 2 == 0) {
            return "0";
        } else {
            return "X";
        }
    }

    private static void fillAnArray() {
        for (String[] row : _2DArray) {
            Arrays.fill(row, "-");
        }
    }

    public static void playKrestikiNoliki() {
        fillAnArray();
        rules();
        roll();
        printAnArray();
        gameLogic();

    }

    private static void gameLogic() {
        while (step < 9) {
            if (!somebodyWon()) {
                makeAMove();
                printAnArray();
            } else {
                if (step % 2 != 0) {
                    System.out.println("Крестики победели!");
                } else {
                    System.out.println("Нолики победели!");
                }
                break;
            }

        }
    }

    private static boolean somebodyWon() {
        boolean isTrue = _2DArray[0][1].equals("X") && _2DArray[0][0].equals("X") && _2DArray[0][2].equals("X");

        // проверка первого ряда
        if (_2DArray[0][1].equals("0") && _2DArray[0][0].equals("0") && _2DArray[0][2].equals("0")) {
            isTrue = true;
        }
        // проверка второго ряда
        if (_2DArray[1][1].equals("X") && _2DArray[1][0].equals("X") && _2DArray[1][2].equals("X")) {
            isTrue = true;
        }
        if (_2DArray[1][1].equals("0") && _2DArray[1][0].equals("0") && _2DArray[1][2].equals("0")) {
            isTrue = true;
        }
        // проверка третьего ряда
        if (_2DArray[2][1].equals("X") && _2DArray[2][0].equals("X") && _2DArray[2][2].equals("X")) {
            isTrue = true;
        }
        if (_2DArray[2][1].equals("0") && _2DArray[2][0].equals("0") && _2DArray[2][2].equals("0")) {
            isTrue = true;
        }
        //------------------------------------
        //проверка первого столбца
        if (_2DArray[0][0].equals("X") && _2DArray[1][0].equals("X") && _2DArray[2][0].equals("X")) {
            isTrue = true;
        }
        if (_2DArray[0][0].equals("0") && _2DArray[1][0].equals("0") && _2DArray[2][0].equals("0")) {
            isTrue = true;
        }
        //проверка второго cтолбца
        if (_2DArray[0][1].equals("X") && _2DArray[1][1].equals("X") && _2DArray[2][1].equals("X")) {
            isTrue = true;
        }
        if (_2DArray[0][1].equals("0") && _2DArray[1][1].equals("0") && _2DArray[2][1].equals("0")) {
            isTrue = true;
        }
        //проверка третьего столбца
        if (_2DArray[0][2].equals("X") && _2DArray[1][2].equals("X") && _2DArray[2][2].equals("X")) {
            isTrue = true;
        }
        if (_2DArray[0][2].equals("0") && _2DArray[1][2].equals("0") && _2DArray[2][2].equals("0")) {
            isTrue = true;
        }

        // проверка по диагонали с низу вверх
        if (_2DArray[0][0].equals("X") && _2DArray[1][1].equals("X") && _2DArray[2][2].equals("X")) {
            isTrue = true;
        }
        if (_2DArray[0][0].equals("0") && _2DArray[1][1].equals("0") && _2DArray[2][2].equals("0")) {
            isTrue = true;
        }
        // проверка по диагонали с верху вниз
        if (_2DArray[0][2].equals("X") && _2DArray[1][1].equals("X") && _2DArray[2][0].equals("X")) {
            isTrue = true;
        }
        if (_2DArray[0][2].equals("0") && _2DArray[1][1].equals("0") && _2DArray[2][0].equals("0")) {
            isTrue = true;
        }
        return isTrue;

    }
}
