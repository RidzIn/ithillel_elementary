package homework_20;

import homework_20.flowers.*;

public class FlowerFactory {

    public Flower getRandomFlower() {
        int a = getRandomNumber(4);
        switch (a) {
            case 0:
                return new Rose("Rose", 50);
            case 1:
                return new Carnation("Carnation", 40);
            case 2:
                return new Lily("Lily", 30);
            case 3:
                return new Tulips("Tulips", 15);
            default:
                return null;
        }
    }

    private int getRandomNumber(int maxValue) {
        return (int) (Math.random() * maxValue);
    }
}
