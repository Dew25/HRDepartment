package ee.ivkhkdev.HRDepartment.service;
import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.helpers.AppHelper;
import ee.ivkhkdev.HRDepartment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements AppService<Employee>{

    private final AppHelper<Employee> employeeAppHelper;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(AppHelper<Employee> employeeAppHelper, EmployeeRepository employeeRepository){
        this.employeeAppHelper=employeeAppHelper;
        this.employeeRepository = employeeRepository;
    };

    @Override
    public boolean add() {
        Optional<Employee> employee = null;
        try {
            employee = employeeAppHelper.create();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(employee.isPresent()){
            employeeRepository.save(employee.get());
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
        return employeeAppHelper.pirintLits(employeeRepository.findAll());
    }
}
