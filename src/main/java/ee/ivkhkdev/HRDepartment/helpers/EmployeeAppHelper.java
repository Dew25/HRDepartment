package ee.ivkhkdev.HRDepartment.helpers;


import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.entities.Person;

import ee.ivkhkdev.HRDepartment.input.Input;
import ee.ivkhkdev.HRDepartment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeAppHelper implements AppHelper<Employee> {
    @Autowired
    private PersonAppHelper personAppHelper;
    @Autowired
    private Input input;
    @Autowired
    private EmployeeRepository emploeeRepository;

    @Override
    public Optional<Employee> create() {
        System.out.println("--- Создание работника ---");
        Employee employee = new Employee();
        System.out.print("Должность: ");
        employee.setPosition(input.nextLine());
        System.out.print("Зарплата: ");
        employee.setSalary(input.nextLine());
        employee.setPerson(createPerson());
        return Optional.of(employee);
    }
    private Person createPerson(){
        Optional<Person> optionalPerson = personAppHelper.create();
        if(optionalPerson.isPresent()){
            return optionalPerson.get();
        }else{
            System.out.println("Error: Не удалось инициировать персону");
        }
        return new Person();
    }
    @Override
    public boolean pirintLits() {
        List<Employee> employees = emploeeRepository.findAll();
        try {
            if(employees.isEmpty()){
                System.out.println("Список работников пуст");
                return false;
            }
            for(int i=0;i<employees.size();i++){
                System.out.printf("%d. Работник %s %s. Должность: %s, Зарплата: %s%n",
                        employees.get(i).getId(),
                        employees.get(i).getPerson().getFirsname(),
                        employees.get(i).getPerson().getLastname(),
                        employees.get(i).getPosition(),
                        employees.get(i).getSalary()
                );
            }
            return true;
        }catch (Exception e){
            return false;

        }

    }

    @Override
    public Employee update() {
        return null;
    }


}
