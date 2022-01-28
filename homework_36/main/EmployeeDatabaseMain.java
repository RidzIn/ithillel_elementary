package ua.ithillel.main;

import ua.ithillel.dao.employeePart.EmployeeDatabaseDao;
import ua.ithillel.model.Employee;

import java.util.List;

public class EmployeeDatabaseMain {

    public static void main(String[] args) {
        EmployeeDatabaseDao ems = new EmployeeDatabaseDao();
        List<Employee> employees = ems.findEmployees();
        System.out.println(employees);

          Employee e = new Employee(1L,1L,"11111111Назаров Максим Давидович", 35000);
          System.out.println(ems.addEmployee(e));
           System.out.println(ems.getEmployee(10L));
          ems.deleteEmployee(30L);
           Employee employeeToUpdate = new Employee(32L,2L, 1L, "Ridz", 250);
           ems.updateEmployee(employeeToUpdate);

    }
}
