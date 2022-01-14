package ua.ithillel.dao;

import ua.ithillel.model.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DepartmentSimpleDao implements DepartmentDao {
    ArrayList<Department> departmentList = new ArrayList<>();

    @Override
    public Long addDepartment(Department department) {
        departmentList.add(department);
        return department.getId();
    }

    @Override
    public void updateDepartment(Department department) {

    }

    @Override
    public void deleteDepartment(Long id) {
        Optional<Department> matchDepartment = departmentList.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findAny();
        matchDepartment.ifPresent(department -> departmentList.remove(department));
    }

    @Override
    public Department getDepartment(Long id) {
        Optional<Department> matchDepartment = departmentList.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findAny();
        return matchDepartment.orElse(null);
    }

    @Override
    public List<Department> findDepartments() {
        return departmentList;
    }
}
