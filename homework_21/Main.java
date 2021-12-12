package homework_20;

import homework_20.flowers.Flower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlowerFactory fc = new FlowerFactory();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input count of flowers to create a bouquet: ");
        int a = sc.nextInt();
        System.out.println("Created a bouquet of " + a + " flowers:");
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            Flower fl1 = fc.getRandomFlower();
            sum += fl1.getCost();
            System.out.println(
                    "#" + i + " " + fl1.getName() + " " +
                            "(" + fl1.getCost() + ")"
            );
        }
        System.out.println("Total cost: " + sum);
    }
}
