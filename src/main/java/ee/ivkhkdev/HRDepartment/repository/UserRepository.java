package ee.ivkhkdev.HRDepartment.repository;

import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
     User findByUsername(String username);
}
