package ua.ithillel.dao.employeePart;

import ua.ithillel.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class EmployeeSimpleDao implements EmployeeDao {
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Long addEmployee(Employee employee) {
        Long newId = generateId();
        employee.setId(newId);
        employeeList.add(employee);
        return newId;
    }

    private long generateId() {
        long id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
        while (Objects.nonNull(getEmployee(id))) {
            id = Math.round(Math.random() * 1000) + System.currentTimeMillis();
        }
        return id;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee oldEmployee = getEmployee(employee.getId());
        if (Objects.nonNull(oldEmployee)) {
            oldEmployee.setName(employee.getName());
            oldEmployee.setDepartmentId(employee.getDepartmentId());
            oldEmployee.setChiefId(employee.getChiefId());
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> matchEmployee = employeeList.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findAny();
        matchEmployee.ifPresent(employee -> employeeList.remove(employee));
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> matchEmployee = employeeList.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findAny();
        return matchEmployee.orElse(null);
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeList;
    }
}
