package ee.ivkhkdev.HRDepartment.configuration;

import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.entities.Person;
import ee.ivkhkdev.HRDepartment.helpers.AppHelper;
import ee.ivkhkdev.HRDepartment.helpers.EmployeeAppHelper;
import ee.ivkhkdev.HRDepartment.helpers.PersonAppHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {

    @Bean
    public AppHelper<Person> personAppHelper(){
        return new PersonAppHelper();
    }
    @Bean
    public AppHelper<Employee> employeeAppHelper(AppHelper<Person> personAppHelper){
        return new EmployeeAppHelper(personAppHelper);
    }
}
