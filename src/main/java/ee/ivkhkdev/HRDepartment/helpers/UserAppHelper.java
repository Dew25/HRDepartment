package ee.ivkhkdev.HRDepartment.helpers;

import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.entities.Person;
import ee.ivkhkdev.HRDepartment.entities.User;
import ee.ivkhkdev.HRDepartment.input.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Component
public class UserAppHelper implements AppHelper<User>{

    @Autowired
    private Input input;
    @Autowired
    private EmployeeAppHelper employeeAppHelper;
    @Autowired
    private PersonAppHelper personAppHelper;

    @Override
    public Optional<User> create() {
        User user = new User();
        System.out.print("Логин: ");
        user.setUsername(input.nextLine());
        System.out.print("Пароль: ");
        user.setPassword(input.nextLine());
        user.setRegDate(LocalDate.now());
        Employee employee = this.createEmployee();
        user.setEmployee(employee);
        return Optional.of(user);
    }

    private Employee createEmployee() {
        Optional<Employee> optionalEmployee = employeeAppHelper.create();
        if(optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }else{
            System.out.println("Error: Не удалось инициировать работника");
        }
        return new Employee();
    }


    @Override
    public boolean pirintLits() {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
