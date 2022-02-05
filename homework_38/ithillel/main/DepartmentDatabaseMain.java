package ua.ithillel.main;

import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Department;
import ua.ithillel.model.Employee;
import ua.ithillel.service.DepartmentManageService;
import ua.ithillel.service.EmployeeManageService;
import ua.ithillel.util.AppConfig;

import java.util.List;

public class DepartmentDatabaseMain {
    public static void main(String[] args) throws BusinessException {

        AppConfig.init();
        DepartmentManageService dms = new DepartmentManageService();
        List<Department> departmentList = dms.findAll();

        System.out.println("=====ADD DEPARTMENT=====");
        Department hr2 = new Department("new HR432");
        dms.add(hr2);
        System.out.println(departmentList);
        System.out.println("=====UPDATE DEPARTMENT=====");
        System.out.println(dms.get(9L));
        dms.update(new Department(9L, "New HR Department"));
        System.out.println("=====DELETE DEPARTMENT=====");
   //     dms.delete(13L);
   //     dms.delete(14L);
    //    dms.delete(15L);
    //    dms.delete(16L);
        System.out.println("=====GET DEPARTMENT=====");
        System.out.println(dms.get(9L));
        System.out.println("=====FIND DEPARTMENTS=====");

    }
}
