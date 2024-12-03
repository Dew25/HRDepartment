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
        Person mockPerson = new Person("John", "Doe","123456");
        List<Person> persons = List.of(mockPerson);
        when(personAppService.print()).thenReturn(true);
        when(personAppService.list()).thenReturn(persons);
        when(input.nextLine()).thenReturn("1", "Developer", "5000");

        // Act
        Optional<Employee> result = employeeAppHelper.create();

        // Assert
        assertTrue(result.isPresent(), "Employee should be created successfully.");
        Employee employee = result.get();
        assertEquals("John", employee.getPerson().getFirsname());
        assertEquals("Doe", employee.getPerson().getLastname());
        assertEquals("Developer", employee.getPosition());
        assertEquals("5000", employee.getSalary());

        // Verify interactions
        verify(personAppService, times(1)).print();
        verify(personAppService, times(1)).list();
        verify(input, times(3)).nextLine();
    }

    @Test
    void testCreateEmployee_NoPersonsAvailable() {
        // Arrange
        when(personAppService.print()).thenReturn(false);

        // Act
        Optional<Employee> result = employeeAppHelper.create();

        // Assert
        assertFalse(result.isPresent(), "Employee should not be created if no persons are available.");
        verify(personAppService, times(1)).print();
        verify(personAppService, never()).list();
        verifyNoInteractions(input);
    }

    @Test
    void testPirintLits_Success() {
        // Arrange
        Person person = new Person("John", "Doe","123456");
        Employee employee = new Employee( "Manager", "6000",person);
        List<Employee> employees = List.of(employee);

        // Act
        boolean result = employeeAppHelper.pirintLits();

        // Assert
        assertTrue(result, "Printing the list of employees should be successful.");
    }

    @Test
    void testPirintLits_EmptyList() {
        // Act
        boolean result = employeeAppHelper.pirintLits();

        // Assert
        assertFalse(result, "Printing an empty list should return false.");
    }
}
