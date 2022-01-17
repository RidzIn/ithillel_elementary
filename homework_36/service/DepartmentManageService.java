package ua.ithillel.service;

import ua.ithillel.dao.departmentPart.DepartmentDao;
import ua.ithillel.dao.departmentPart.DepartmentSimpleDao;
import ua.ithillel.model.Department;

import java.util.List;

public class DepartmentManageService {
    private DepartmentDao departmentDao = new DepartmentSimpleDao();

    public Long add(Department department) {
        return departmentDao.addDepartment(department);
    }

    public void update(Department department) {
        departmentDao.updateDepartment(department);
    }

    public void delete(Long id) {
        departmentDao.deleteDepartment(id);
    }

    public Department get(Long id) {
        return departmentDao.getDepartment(id);
    }

    public List<Department> findAll() {

        return departmentDao.findDepartments();
    }
}
