package ee.ivkhkdev.HRDepartment.helpers;

import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.entities.User;
import ee.ivkhkdev.HRDepartment.input.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
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
    @Autowired
    private DataSourceTransactionManagerAutoConfiguration dataSourceTransactionManagerAutoConfiguration;

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
    public boolean pirintLits(List<User> users) {
       // List<User> users = (List<User>) userRepository.findAll();
        if(users.isEmpty()){
            System.out.println("Список пользователей пуст");
            return false;
        }
        System.out.println("----- Список пользователей -----");
        for (int i=0;i<users.size();i++){
            System.out.printf("%d. %s %s. %s. %s.%n",
                    i+1,
                    users.get(i).getEmployee().getPerson().getFirsname(),
                    users.get(i).getEmployee().getPerson().getLastname(),
                    users.get(i).getEmployee().getPosition(),
                    users.get(i).getEmployee().getSalary());
        }
        return true;
    }

    @Override
    public User update(List<User> users) {
        this.pirintLits(users);
        System.out.print("Выберите номер пользователя из списка: ");
        int userNumber = Integer.parseInt(input.nextLine());
        User user = users.get(userNumber-1);
        System.out.println("У пользователя такое имя: "+user.getEmployee().getPerson().getFirsname());
        System.out.print("Изменить ? (y/n)" );
        int yesOrNo = Integer.parseInt(input.nextLine());
        if("y".equals(yesOrNo)){
            System.out.println("Введите другое имя: ");
            user.getEmployee().getPerson().setFirsname(input.nextLine());
        };
        System.out.println("У пользователя такая фамилия: "+user.getEmployee().getPerson().getLastname());
        System.out.print("Изменить ? (y/n)" );
        yesOrNo = Integer.parseInt(input.nextLine());
        if("y".equals(yesOrNo)){
            System.out.println("Введите другую фамилию: ");
            user.getEmployee().getPerson().setLastname(input.nextLine());
        };
        System.out.println("У пользователя такая должность: "+user.getEmployee().getPosition());
        System.out.print("Изменить ? (y/n)" );
        yesOrNo = Integer.parseInt(input.nextLine());
        if("y".equals(yesOrNo)){
            System.out.println("Введите другую должность: ");
            user.getEmployee().setPosition(input.nextLine());
        };
        // продолжить реализацию
        return user;
    }




}
