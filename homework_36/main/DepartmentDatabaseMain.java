package ua.ithillel.main;

import ua.ithillel.dao.departmentPart.DepartmentDatabaseDao;
import ua.ithillel.model.Department;

public class DepartmentDatabaseMain {
    public static void main(String[] args) {
        DepartmentDatabaseDao dms = new DepartmentDatabaseDao();
        dms.addDepartment(new Department("New IT"));
        dms.deleteDepartment(10L);
        dms.updateDepartment(new Department(8L,"Old IT"));
        System.out.println( dms.getDepartment(2L));
        System.out.println(dms.findDepartments());
    }


}
