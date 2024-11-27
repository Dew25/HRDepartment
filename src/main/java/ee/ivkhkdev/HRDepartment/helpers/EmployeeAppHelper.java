package ee.ivkhkdev.HRDepartment.helpers;


import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.entities.Person;

import ee.ivkhkdev.HRDepartment.input.Input;
import ee.ivkhkdev.HRDepartment.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeAppHelper implements AppHelper<Employee>{
    @Autowired
    private AppService<Person> personAppService;
    @Autowired
    private Input input;


    @Override
    public Optional<Employee> create() {
        System.out.println("--- Создание работника ---");
        Employee employee = new Employee();
        if(!personAppService.print()){
            return Optional.empty();
        };
        System.out.print("Выберите номер персоны: ");
        int numberPerson = Integer.parseInt(input.nextLine());
        employee.setPerson(personAppService.list().get(numberPerson - 1));
        System.out.print("Должность: ");
        employee.setPosition(input.nextLine());
        System.out.print("Зарплата: ");
        employee.setSalary(input.nextLine());
        return Optional.of(employee);
    }

    @Override
    public boolean pirintLits(List<Employee> entities) {
        try {
            if(entities.isEmpty()){
                System.out.println("Список работников пуст");
                return false;
            }
            for(int i=0;i<entities.size();i++){
                System.out.printf("%d. Работник %s %s. Должность: %s, Зарплата: %s%n",
                        i+1,
                        entities.get(i).getPerson().getFirsname(),
                        entities.get(i).getPerson().getLastname(),
                        entities.get(i).getPosition(),
                        entities.get(i).getSalary()
                );
            }
            return true;
        }catch (Exception e){
            return false;

        }

    }

    @Override
    public List<Employee> update(List<Employee> entities) {
        return List.of();
    }
}
