package homework_34;

public class Customer {
    private static Long count = 0L;
    private final Long id;
    private final String name;
    private final int tier;

    public Customer(String name, int tier) {
        id = count++;
        this.name = name;
        this.tier = tier;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
