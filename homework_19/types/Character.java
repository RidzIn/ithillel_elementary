package homework_19.types;

import homework_19.behavior.WeaponBehavior;

public abstract class Character {
    protected WeaponBehavior weapon;
    private final String name;
    private int healthPoints;

    public void setWeapon(WeaponBehavior weapon){
        this.weapon = weapon;
    }
    public Character(String name,int healthPoints){ // ввести проверку на хп
        this.name = name;
        this.healthPoints = healthPoints;
    }
    public void displayWeapon(){
         weapon.useWeapon();
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public String getName() {
        return name;
    }
}
