package homework_34;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private static Long count = 0L;
    private final Long id;
    private final String status;
    private final LocalDate orderDate;
    private final LocalDate deliveryTime;
    private final List<Product> products;
    private final Customer customer;

    public Order(String status, LocalDate orderDate, LocalDate deliveryTime, List<Product> products, Customer customer) {
        id = count++;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryTime = deliveryTime;
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryTime() {
        return deliveryTime;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryTime=" + deliveryTime +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
