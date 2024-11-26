package ee.ivkhkdev.HRDepartment.helpers;

import ee.ivkhkdev.HRDepartment.entities.Person;
import org.springframework.stereotype.Component;

import java.util.List;


public class PersonAppHelper implements AppHelper<Person>{
    public PersonAppHelper() {
    }

    @Override
    public Person create() {
        return new Person(1L,"Ivan","Ivanov","123456");
    }

    @Override
    public boolean pirintLits(List<Person> entities) {
        return false;
    }

    @Override
    public List<Person> update(List<Person> entities) {
        return List.of();
    }
}
