package homework_34;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Product pen = new Product("Pen", "For Kids", 3.5);
        Product ruler = new Product("Ruler", "For Kids", 2.0);
        Product toy1 = new Product("Red Car", "Toys", 30.0);
        Product toy2 = new Product("Lego", "Toys", 40.0);
        Product book1 = new Product("Deep Learning", "Books", 150.0);
        Product book2 = new Product("Anatomic Habits", "Books", 95.0);
        Product t_shirt = new Product("T-Shirt", "For Kids", 12.0);
        Product shorts = new Product("Shorts", "For Kids", 15.0);


        Customer customer1 = new Customer("Bob", 1);
        Customer customer2 = new Customer("Mike", 3);
        Customer customer3 = new Customer("Simon", 2);

        List<Product> listOfProductsForOrder1 = new ArrayList<>();
        listOfProductsForOrder1.add(t_shirt);
        listOfProductsForOrder1.add(shorts);
        listOfProductsForOrder1.add(book2);

        Order order1 = new Order("Delivered", LocalDate.of(2021, 10, 15), LocalDate.of(2021, 11, 18),
                listOfProductsForOrder1, customer3);


        List<Product> listOfProductsForOrder2 = new ArrayList<>();
        listOfProductsForOrder2.add(toy1);
        listOfProductsForOrder2.add(toy2);

        Order order2 = new Order("In Progress", LocalDate.of(2021, 11, 15), LocalDate.of(2021, 12, 3),
                listOfProductsForOrder2, customer2);

        Order order3 = new Order("In Progress", LocalDate.of(2021, 11, 15), LocalDate.of(2022, 12, 3),
                listOfProductsForOrder2, customer2);


        List<Product> products = new ArrayList<>();
        {
            products.add(pen);
            products.add(ruler);
            products.add(book1);
            products.add(book2);
            products.add(toy1);
            products.add(toy2);
        }

        List<Order> orders = new ArrayList<>();
        orders.add(order3);
        orders.add(order1);
        orders.add(order2);

        System.out.println("---Task1---");
        taskOne(products);
        System.out.println("---Task2---");
        taskTwo(orders);
        System.out.println("---Task3---");
        taskThree(products);
        System.out.println("---Task4---");
        taskFive(products);
        System.out.println("---Task5---");
        taskFour(orders);
        System.out.println("---Task6---");
        taskSix(orders);
        System.out.println("---Task7---");
        taskSeven(orders);
        System.out.println("---Task8---");
        taskEight(orders);
    }

    public static void taskOne(List<Product> list) {
        list.stream()
                .filter(x -> Objects.equals(x.getCategory(), "Books"))
                .filter(c -> c.getPrice() > 100)
                .forEach(System.out::println);
    }

    public static void taskTwo(List<Order> list) {
        Predicate<Product> forKids = product -> product.getCategory().equals("For Kids");
        for (Order order : list) {
            if (order.getProducts().stream().anyMatch(forKids)) {
                System.out.println(order);
            }
        }
    }

    public static void taskThree(List<Product> list) {
        Predicate<Product> isToy = product -> product.getCategory().equals("Toys");
        list.stream()
                .filter(isToy)
                .peek(x -> x.setPrice(x.getPrice() + x.getPrice() * 0.1))
                .forEach(System.out::println);
    }

    public static void taskFour(List<Order> list) {
        Predicate<Order> isSecondTier = customer -> customer.getCustomer().getTier() == 2;
        Predicate<Order> fromOct = customer -> customer.getOrderDate().isAfter(LocalDate.of(2021, 10, 11));
        Predicate<Order> toNow = customer -> customer.getOrderDate().isBefore(LocalDate.of(2021, 11, 11));
        list.stream()
                .filter(isSecondTier)
                .filter(fromOct)
                .filter(toNow)
                .map(Order::getProducts)
                .forEach(System.out::println);

    }

    public static void taskFive(List<Product> list) {
        Predicate<Product> isBook = product -> product.getCategory().equals("Books");
        Product minPrice = list.stream()
                .filter(isBook)
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(minPrice);
    }

    public static void taskSix(List<Order> list) {
        list.stream()
                .sorted(Comparator.comparing(Order::getDeliveryTime).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    public static void taskSeven(List<Order> list) {
        Predicate<Order> is15November = order -> order.getOrderDate().equals(LocalDate.of(2021, 11, 15));
        list.stream()
                .filter(is15November)
                .map(Order::getProducts)
                .forEach(System.out::println);
    }

    public static void taskEight(List<Order> list) {
        Map<Order, Double> map = new HashMap<>();
        for (Order order : list) {
            map.put(order, order.getProducts().stream().map(Product::getPrice).reduce((double) 0, Double::sum));
        }
        System.out.println(map);
    }
}
