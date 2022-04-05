package ua.ithillel.service;

import ua.ithillel.dao.departmentPart.DepartmentDao;
import ua.ithillel.dao.departmentPart.DepartmentDatabaseDao;
import ua.ithillel.dao.departmentPart.DepartmentSimpleDao;
import ua.ithillel.exception.BusinessException;
import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Department;

import java.util.List;

public class DepartmentManageService {
    private DepartmentDao departmentDao = new DepartmentDatabaseDao();

    public Long add(Department department) throws BusinessException {
        Long id;

        try {
            id = departmentDao.addDepartment(department);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
        return id;
    }

    public void update(Department department) throws BusinessException {
        try {
            departmentDao.updateDepartment(department);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public void delete(Long id) throws BusinessException {
        try {
            departmentDao.deleteDepartment(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public Department get(Long id) throws BusinessException {
        try {
            return departmentDao.getDepartment(id);
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }

    public List<Department> findAll() throws BusinessException {

        try {
            return departmentDao.findDepartments();
        } catch (DaoException e) {
            throw new BusinessException(e);
        }
    }
}
