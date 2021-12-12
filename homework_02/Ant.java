package homework_02;


import java.util.Scanner;

public class Ant {
    static String[][] _2DArray = new String[5][5];
    static int currentRow;
    static int currentColumn;
    static String currentPos;


    static int angle = 0;
    static String strAngle = "Север";

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        fillAnArray();
        placeAnAnt();
        printAnArray();

        move();


    }


    private static void placeAnAnt() {
        int randomRow = (int) Math.round((Math.random() * 4));
        int randomColumn = (int) Math.round((Math.random() * 4));
        currentRow = randomRow;
        currentColumn = randomColumn;
        printCurrentPosOfAnt();
        currentPos = _2DArray[randomRow][randomColumn];
        _2DArray[randomRow][randomColumn] += "_a";
    }

    private static void move() {

        System.out.println("Выбери кол-во шагов:");
        int count = sc.nextInt();
        try {


            for (int i = 0; i < count; i++) {
                moveLogic();
                System.out.println(strAngle);
                System.out.println(angle);
                printCurrentPosOfAnt();
                printAnArray();
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Муравей вышел за пределы доски!");
            printCurrentPosOfAnt();
        }
    }

    private static void moveLogic() {
        methodForMoveLogic();
        _2DArray[currentRow][currentColumn] = "A";
    }

    private static void methodForMoveLogic() {
        switch (strAngle) {
            case "Север":
                switchTheAngle();
                switchTheColor();
                currentRow -= 1;
                break;
            case "Восток":
                switchTheAngle();
                switchTheColor();
                currentColumn += 1;
                break;
            case "Юг":
                switchTheAngle();
                switchTheColor();
                currentRow += 1;
                break;
            case "Запад":
                switchTheAngle();
                switchTheColor();
                currentColumn -= 1;
                break;
        }
    }

    private static void switchTheAngle() {
        if (currentPos.equals("W")) {
            angle += 90;


        } else {
            angle -= 90;

        }
        checkTheAngel();
    }

    private static void switchTheColor() {
        if (currentPos.equals("W")) {
            _2DArray[currentRow][currentColumn] = "B";
        } else {
            _2DArray[currentRow][currentColumn] = "W";
        }
    }

    private static void printCurrentPosOfAnt() {
        System.out.println("\t\t   Ant position: (" + currentRow + ":" + currentColumn + ")");
    }

    private static String randomIndexBetweenBlackAndWhite() {
        int randIndex = (int) Math.round((Math.random()));
        String[] blackAndWhiteArray = new String[]{"B", "W"};
        return blackAndWhiteArray[randIndex];
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

    private static void fillAnArray() {

        for (int i = 0; i < _2DArray.length; i++) {
            for (int j = 0; j < _2DArray[0].length; j++) {
                _2DArray[i][j] = randomIndexBetweenBlackAndWhite();
            }
        }
    }

    private static void checkTheAngel() {

        switch (angle) {
            case 90:
            case -270:
                strAngle = "Восток";
                break;
            case 180:
            case -180:
                strAngle = "Юг";
                break;
            case 270:
            case -90:
                strAngle = "Запад";
                break;
            default:
                strAngle = "Север";
                angle = 0;
        }

    }
}
