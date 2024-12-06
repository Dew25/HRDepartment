package ee.ivkhkdev.HRDepartment.service;

import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.entities.Person;
import ee.ivkhkdev.HRDepartment.entities.User;
import ee.ivkhkdev.HRDepartment.helpers.AppHelper;
import ee.ivkhkdev.HRDepartment.repository.EmployeeRepository;
import ee.ivkhkdev.HRDepartment.repository.PersonRepository;
import ee.ivkhkdev.HRDepartment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements AppService<User>{

    @Autowired private AppHelper<User> userAppHelper;
    @Autowired private UserRepository userRepository;
    @Autowired private PersonRepository personRepository;
    @Autowired private EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public boolean add() {
        Optional<User> optionalUser = null;
        try {
            optionalUser = userAppHelper.create();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            Person person = user.getEmployee().getPerson();
            Person savedPerson = personRepository.save(person);
            Employee employee = user.getEmployee();
            Employee savedEmployee = employeeRepository.save(employee);
            user.getEmployee().setPerson(savedPerson);
            user.setEmployee(savedEmployee);
            userRepository.save(user);
 //     короткая запись вышележащих действий
//            user.getEmployee().setPerson(personRepository.save(user.getEmployee().getPerson()));
//            user.setEmployee(employeeRepository.save(user.getEmployee()));
//            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean edit() {
        User modifedUser = userAppHelper.update((List<User>) userRepository.findAll());
        if(modifedUser == null){
            return false;
        }
        userRepository.save(modifedUser);
        return true;
    }

    @Override
    public boolean print() {
        return userAppHelper.pirintLits((List<User>) userRepository.findAll());
    }

}
