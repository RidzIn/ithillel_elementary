package homework_15.array_first;

public class ForEachExample {
    public static void main(String[] args) {
        int[] sample = new int[5];

        System.out.println("До foreach");
        // выводим элементы в цикле foreach - их значение 0
        for (int t : sample) {
            System.out.println(t);
        }

        // Думаем, что происходит инициализация
        for (int t : sample) {
            sample[t] = 99;
        }

        System.out.println("После foreach");
        // выводим элементы в цикле foreach - снова 0
        for (int t : sample) {
            System.out.println(t);
        }

        System.out.println("-------------------------------------");

        System.out.println("До foreach");
        // выводим элементы в цикле foreach - их значение 0
        for (int t : sample) {
            System.out.println(t);
        }

        // Для инициализации элементов foreach не подходит
        for (int i = 0; i < sample.length; i++) {
            sample[i] = 99;
        }

        System.out.println("После foreach");
        // выводим элементы в цикле foreach - теперь 99
        for (int t : sample) {
            System.out.println(t);
        }
    }
}
