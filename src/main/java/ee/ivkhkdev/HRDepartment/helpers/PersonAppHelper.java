package ee.ivkhkdev.HRDepartment.helpers;

import ee.ivkhkdev.HRDepartment.entities.Person;
import ee.ivkhkdev.HRDepartment.input.Input;
import ee.ivkhkdev.HRDepartment.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonAppHelper implements AppHelper<Person>{
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private Input input;

    @Override
    public Optional<Person> create() {
        System.out.println("--- Создаем персону ---");
        Person person = new Person();
        System.out.print("Имя: ");
        person.setFirsname(input.nextLine());
        System.out.print("Фамилия: ");
        person.setLastname(input.nextLine());
        System.out.print("Телефон: ");
        person.setPhone(input.nextLine());
        return Optional.of(person);
    }

    @Override
    public boolean pirintLits(List<Person> entities) {
        if(entities.isEmpty()) {
            System.out.println("Спивок персон пуст");
            return false;
        }
        System.out.println("--- Список персон ---");
        for (int i = 0; i < entities.size(); i++) {
            System.out.printf("%d. %s %s. %s%n",
                    i+1,
                    entities.get(i).getFirsname(),
                    entities.get(i).getLastname(),
                    entities.get(i).getPhone()
            );
        }
        return true;
    }

    @Override
    public List<Person> update(List<Person> entities) {
        return List.of();
    }
}
