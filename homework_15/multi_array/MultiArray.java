package homework_15.multi_array;

public class MultiArray {
    static int SIZE = 10;
    public static void main(String[] args) {

        // Создаем двумерный массив
        char[][] arr = new char[SIZE][SIZE];

        // Цикл по первой размерности (первые квадратные скобки)
        for (int i = 0; i < SIZE; i++) {
            // Цикл по второй размерности (вторые квадратные скобки)
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = '#';
            }
        }
        printAnArray(arr);

        for (int i = 0; i < SIZE; i++) {
            // Цикл по второй размерности (вторые квадратные скобки)
            for (int j = 0; j < SIZE; j++) {
                if (i == 0 || i == SIZE - 1 || j == 0 || j == SIZE - 1) {
                    arr[i][j] = '#';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
        printAnArray(arr);
    }

    public static void printAnArray(char[][] arr){
        System.out.println("-----------------------------------------");
        for (int i = 0; i < SIZE; i++) {
            // Цикл по второй размерности выводит колонки - вывод одной строки
            for (int j = 0; j < SIZE; j++) {
                // Используем оператор print - без перехода на следующую строку
                System.out.print(arr[i][j]);
            }
            // Переход на следующую строку
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }
}

