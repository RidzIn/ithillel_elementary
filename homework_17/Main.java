package homework_17;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String endTheApplication;
        while (true) {
            System.out.println("Input the key:");
            String str = sc.nextLine();
            try {
                Animal animal3 = AnimalFactory.getAnimaByKey(str);
                System.out.println(animal3.getName());
                break;
            } catch (NullPointerException e) {
                System.out.println("This key does not exist. \nTry between [da,db,dc,ca,cb,cc].");
            }
        }
    }
}
