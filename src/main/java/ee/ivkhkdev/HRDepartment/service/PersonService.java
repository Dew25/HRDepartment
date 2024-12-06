package ee.ivkhkdev.HRDepartment.service;

import ee.ivkhkdev.HRDepartment.entities.Person;
import ee.ivkhkdev.HRDepartment.helpers.AppHelper;
import ee.ivkhkdev.HRDepartment.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements AppService<Person>{
    @Autowired
    private AppHelper<Person> personAppHelper;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean add() {
        Optional<Person> person = null;
        try {
            person = personAppHelper.create();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(person.isPresent()){
            personRepository.save(person.get());
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
        return personAppHelper.pirintLits(personRepository.findAll());
    }


}
