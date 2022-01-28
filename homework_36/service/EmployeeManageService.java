package ua.ithillel.service;

import ua.ithillel.dao.employeePart.EmployeeDao;
import ua.ithillel.dao.employeePart.EmployeeSingleton;
import ua.ithillel.model.Employee;

import java.util.List;

public class EmployeeManageService {

    private final EmployeeDao employeeDao = EmployeeSingleton.getInstance().getEmployeeDao();
    private final RandomHTTPService randomHttpService = new RandomHTTPService();

    public Long add(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    public void update(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void delete(Long id) {
        employeeDao.deleteEmployee(id);
    }

    public Employee get(Long id) {
        return employeeDao.getEmployee(id);
    }

    public List<Employee> findAll() {
        return employeeDao.findEmployees();
    }
}
