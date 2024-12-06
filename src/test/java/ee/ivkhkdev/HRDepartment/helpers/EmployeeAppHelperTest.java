package ee.ivkhkdev.HRDepartment.helpers;

import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.entities.Person;
import ee.ivkhkdev.HRDepartment.input.Input;
import ee.ivkhkdev.HRDepartment.service.AppService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeAppHelperTest {
    @Mock
    private AppService<Person> personAppService;
    @Mock
    private PersonAppHelper personAppHelper;
    @Mock
    private Input input;

    @InjectMocks
    private EmployeeAppHelper employeeAppHelper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateEmployee_Success() {
        // Arrange


        when(personAppService.print()).thenReturn(true);

        when(input.nextLine()).thenReturn("Developer", "5000");
        when(personAppHelper.create()).thenReturn(Optional.of(new Person("John","Doe","123456")));
        // Act
        Optional<Employee> result = employeeAppHelper.create();

        // Assert
        assertTrue(result.isPresent(), "Employee should be created successfully.");
        Employee employee = result.get();
        assertEquals("John", employee.getPerson().getFirsname());
        assertEquals("Doe", employee.getPerson().getLastname());
        assertEquals("Developer", employee.getPosition());
        assertEquals("5000", employee.getSalary());

        verify(input, times(2)).nextLine();
    }

    @Test
    void testCreateEmployee_NoPersonsAvailable() {
        // Arrange
        when(personAppService.print()).thenReturn(false);

        // Act
        Optional<Employee> result = employeeAppHelper.create();

        // Assert
        assertFalse(result.isPresent(), "Employee should not be created if no persons are available.");

    }

    @Test
    void testPirintLits_Success() {
        List<Employee> employees = List.of(new Employee("Должность","зарплата", new Person("Ivan","Ivanov","123456")));
        // Act
        boolean result = employeeAppHelper.pirintLits(employees);

        // Assert
        assertTrue(result, "Printing the list of employees should be successful.");
    }

    @Test
    void testPirintLits_EmptyList() {
        List<Employee> employees = List.of();
        // Act
        boolean result = employeeAppHelper.pirintLits(employees);

        // Assert
        assertFalse(result, "Printing an empty list should return false.");
    }
}
