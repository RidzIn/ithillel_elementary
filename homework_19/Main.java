package homework_19;

import homework_19.behavior.SwordBehavior;
import homework_19.types.Character;
import homework_19.types.King;

public class Main {
    public static void main(String[] args) {
        Character king = new King("Adam",100);
        king.setWeapon(new SwordBehavior());
        king.displayWeapon();
    }
}
