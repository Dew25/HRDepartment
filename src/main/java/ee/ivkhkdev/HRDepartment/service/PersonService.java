package ee.ivkhkdev.HRDepartment.service;

import ee.ivkhkdev.HRDepartment.entities.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements AppService<Person>{
    @Override
    public boolean add() {
        return false;
    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean print(List entities) {
        return false;
    }
}
