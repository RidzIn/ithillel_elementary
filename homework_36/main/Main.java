package ua.ithillel.main;

import ua.ithillel.service.RandomHTTPService;

public class Main {

    public static void main(String[] args) {
        RandomHTTPService randomHTTPService = new RandomHTTPService();
        System.out.println(randomHTTPService.getNumber(0, 100));
    }
}
