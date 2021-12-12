package homework_21;

public class Meal {
    Drinks drinks;
    Menu menu;

    Meal(Menu menu, Drinks drinks) {
        this.drinks = drinks;
        this.menu = menu;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getPrice() {
        return menu.getPrice() + drinks.getPrice();
    }

    @Override
    public String toString() {
        return "Meal{" +
                "drinks=" + drinks +
                ", menu=" + menu +
                ", total price=" + getPrice() +
                '}';
    }
}
