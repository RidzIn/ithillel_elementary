package ua.ithillel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
    private Long id;
    private Long departmentId;
    private Long chiefId;
    private String name;
    private int salary;

    public Employee(Long departmentId, Long chiefId, String name, int salary) {
        this.departmentId = departmentId;
        this.chiefId = chiefId;
        this.name = name;
        this.salary = salary;
    }


}
