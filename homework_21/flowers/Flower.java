package homework_20.flowers;

public abstract class Flower {
    private final String name;
    private final int cost;

    public Flower(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }
}
