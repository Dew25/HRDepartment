package ee.ivkhkdev.HRDepartment.repository;

import ee.ivkhkdev.HRDepartment.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
