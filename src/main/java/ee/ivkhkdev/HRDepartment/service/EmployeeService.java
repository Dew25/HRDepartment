package ee.ivkhkdev.HRDepartment.service;
import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.helpers.AppHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService implements AppService<Employee>{

    private final AppHelper<Employee> employeeAppHelper;

    @Autowired
    public EmployeeService(AppHelper<Employee> employeeAppHelper){
        this.employeeAppHelper=employeeAppHelper;
    };

    @Override
    public boolean add() {
        Employee employee = employeeAppHelper.create();
        if(employee == null) return false;
        return this.print(List.of(employee));

    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean print(List<Employee> entities) {
        return employeeAppHelper.pirintLits(entities);
    }
}
