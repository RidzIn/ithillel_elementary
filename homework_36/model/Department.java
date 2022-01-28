package ua.ithillel.model;

import lombok.Data;

@Data
public class Department {
    private static Long count = 1L;
    private Long id;
    private String name;

    public Department(String name) {
        id = count++;
        this.name = name;
    }

    public Department(Long id,String name) {
        this.id = id;
        this.name = name;
    }
}
