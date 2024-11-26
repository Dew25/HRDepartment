package ee.ivkhkdev.HRDepartment.helpers;


import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.entities.Person;

import org.springframework.stereotype.Component;

import java.util.List;



public class EmployeeAppHelper implements AppHelper<Employee>{

    private final AppHelper<Person> personAppHelper;

    public EmployeeAppHelper(AppHelper<Person> personAppHelper) {
        this.personAppHelper = personAppHelper;
    }

    @Override
    public Employee create() {
        Person person = personAppHelper.create();
        return new Employee(1L,"Director","3000",person);
    }

    @Override
    public boolean pirintLits(List<Employee> entities) {
        try {
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
