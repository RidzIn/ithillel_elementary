package ua.ithillel.dao.employeePart;

import ua.ithillel.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Long addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee getEmployee(Long id);

    List<Employee> findEmployees();
}
