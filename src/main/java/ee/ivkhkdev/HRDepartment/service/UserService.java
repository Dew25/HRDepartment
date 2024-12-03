package ee.ivkhkdev.HRDepartment.service;

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
        Optional<User> optionalUser = userAppHelper.create();
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.getEmployee().setPerson(personRepository.save(user.getEmployee().getPerson()));
            user.setEmployee(employeeRepository.save(user.getEmployee()));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean print() {
        return false;
    }

    @Override
    public List<User> list() {
        return List.of();
    }
}
