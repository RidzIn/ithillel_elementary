package ua.ithillel.main;

import ua.ithillel.model.Department;
import ua.ithillel.service.DepartmentManageService;

public class DepartmentSimpleMain {
    public static void main(String[] args) {
        DepartmentManageService dms = new DepartmentManageService();
        Department adminDepartment = new Department("Административный отдел");
        Department legalDepartment = new Department("Юридический отдел");
        Department loanDepartment = new Department("Кредитный отдел");
        Department accountingDepartment = new Department("Отдел бухгалтерского учета и отчетности");
        Department itDepartment = new Department("Отдел информационных технологий");
        Department hrDepartment = new Department("Отдел кадров");

        dms.add(adminDepartment);
        dms.add(legalDepartment);
        dms.add(loanDepartment);
        dms.add(accountingDepartment);
        dms.add(itDepartment);
        dms.add(hrDepartment);

        System.out.println(dms.findAll());
        dms.delete(1L);
        System.out.println(dms.findAll());
    }
}
