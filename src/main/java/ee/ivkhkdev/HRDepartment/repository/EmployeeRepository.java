package ee.ivkhkdev.HRDepartment.repository;

import ee.ivkhkdev.HRDepartment.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
