package ua.ithillel.main;

import ua.ithillel.exception.BusinessException;
import ua.ithillel.model.Employee;
import ua.ithillel.service.EmployeeManageService;
import ua.ithillel.util.AppConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDatabaseMain {

    public static void main(String[] args) {
        try {
            AppConfig.init();
            EmployeeManageService ems = new EmployeeManageService();

            System.out.println("ADD EMPLOYEE ==============");
            Map<String, Long> mapId = addEmployees(ems);
            Long e2Id = mapId.get("e2Id");
            Long e3Id = mapId.get("e3Id");

            List<Employee> employeeList = ems.findAll();
            System.out.println("\nFIND ALL EMPLOYEE ============== ");
            for (Employee e : employeeList) {
                System.out.println(e);
            }

            System.out.println("\nGET EMPLOYEE ============== " + e2Id);
            // Employee updEmployee = ems.get(e2Id);

            System.out.println("\nUPDATE EMPLOYEE ============== " + e2Id);
            //  System.out.println("BEFORE UPDATE ============== " + updEmployee.getName());
            // updEmployee.setName("Александрова Александра Александровна");
            // ems.update(updEmployee);
            //   System.out.println("AFTER UPDATE - " + ems.get(e2Id));


            System.out.println("\nDELETE EMPLOYEE ============== " + 249L);
            ems.delete(250L);

        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }

    static Map<String, Long> addEmployees(EmployeeManageService ems) throws BusinessException {
        Map<String, Long> map = new HashMap<>();
        Long e2Id = null;
        Long e3Id = null;
        Employee e1 = new Employee("Назаров Максим Давидович", 35000, 1L, null);
        Employee e8 = new Employee("Волков Станислав Юрьевич", 45000, 2L, null);
        Employee e11 = new Employee("Лебедева Анна Михайловна", 20000, 3L, null);
        Employee e20 = new Employee("Колесникова Милана Родионовна", 35000, 4L, null);
        Long e1Id = ems.add(e1);

        Employee e2 = new Employee("Александрова Аиша Игоревна", 5000, 1L, e1Id);
        Employee e3 = new Employee("Кузьмин Артём Богданович", 5500, 1L, e1Id);
        e2Id = ems.add(e2);
        e3Id = ems.add(e3);
        ems.add(new Employee("Громова Сафия Владимировна", 6000, 1L, e1Id));
        ems.add(new Employee("Еремин Ярослав Тимурович", 6000, 1L, e1Id));
        ems.add(new Employee("Баранов Дмитрий Русланович", 5200, 1L, e1Id));
        ems.add(new Employee("Еремина София Макаровна", 6500, 1L, e1Id));
        Long e8Id = ems.add(e8);
        ems.add(new Employee("Михайлов Филипп Фёдорович", 15500, 2L, e8Id));
        ems.add(new Employee("Макаров Алексей Родионович", 15000, 2L, e8Id));
        Long e11Id = ems.add(e11);
        ems.add(new Employee("Тарасова Юлия Глебовна", 22000, 3L, e11Id));
        ems.add(new Employee("Колосова Алиса Константиновна", 18000, 3L, e11Id));
        ems.add(new Employee("Сафонов Арсений Егорович", 15000, 3L, e11Id));
        ems.add(new Employee("Ларина Ирина Львовна", 15000, 3L, e11Id));
        ems.add(new Employee("Пономарева Евгения Данильевна", 15000, 3L, e11Id));
        ems.add(new Employee("Журавлева Милана Фёдоровна", 14000, 3L, e11Id));
        ems.add(new Employee("Никифоров Максим Максимович", 14500, 3L, e11Id));
        ems.add(new Employee("Макаров Алексей Родионович", 15000, 3L, e11Id));
        Long e20Id = ems.add(e20);
        ems.add(new Employee("Куприянова Евгения Даниловна", 12000, 4L, e20Id));
        ems.add(new Employee("Чистяков Владимир Артёмович", 13000, 4L, e20Id));
        ems.add(new Employee("Савицкая София Андреевна", 15000, 4L, e20Id));
        ems.add(new Employee("Борисова Анна Саввична", 37000, 4L, e20Id));
        ems.add(new Employee("Греков Артём Маркович", 17000, 4L, e20Id));

        map.put("e2Id", e2Id);
        map.put("e3Id", e3Id);
        return map;
    }
}

