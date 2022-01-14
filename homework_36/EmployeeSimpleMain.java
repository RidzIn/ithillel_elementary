package ua.ithillel;

import ua.ithillel.model.Employee;
import ua.ithillel.service.EmployeeManageService;

public class EmployeeSimpleMain {
    public static void main(String[] args) {
        EmployeeManageService ems = new EmployeeManageService();

        Employee nazarov = new Employee(1L, null, "Назаров Максим Давидович", 35000);
        Long nazarovId = ems.add(nazarov);


        Employee alexandrova = new Employee(1L, nazarovId, "Александрова Аиша Игоревна", 35000);
        Employee lebedeva = new Employee(1L, nazarovId, "Лебедева Анна Михайловна", 20000);
        Employee tarasova = new Employee(2L, nazarovId, "Тарасова Юлия Глебовна", 22000);
        Employee kolosova = new Employee(2L, nazarovId, "Колосова Алиса Константиновна", 18000);

        {
            ems.add(lebedeva);
            ems.add(tarasova);
            ems.add(kolosova);
            ems.add(alexandrova);
        }
        System.out.println(ems.findAll());

        nazarov.setId(1L);
        ems.delete(1L);
        System.out.println(ems.get(1L));
        System.out.println(ems.findAll());
        ems.findAll();


    }
}
