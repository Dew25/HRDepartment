package ee.ivkhkdev.HRDepartment.service;

import ee.ivkhkdev.HRDepartment.entities.Employee;
import ee.ivkhkdev.HRDepartment.helpers.AppHelper;
import ee.ivkhkdev.HRDepartment.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private AppHelper<Employee> employeeAppHelper;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd_Success() throws Exception {
        // Arrange
        Employee mockEmployee = new Employee();
        when(employeeAppHelper.create()).thenReturn(Optional.of(mockEmployee));

        // Act
        boolean result = employeeService.add();

        // Assert
        assertTrue(result, "The employee should be added successfully.");
        verify(employeeAppHelper, times(1)).create();
        verify(employeeRepository, times(1)).save(mockEmployee);
    }

    @Test
    void testAdd_Failure() throws Exception {
        // Arrange
        when(employeeAppHelper.create()).thenReturn(Optional.empty());

        // Act
        boolean result = employeeService.add();

        // Assert
        assertFalse(result, "The employee should not be added if creation fails.");
        verify(employeeAppHelper, times(1)).create();
        verifyNoInteractions(employeeRepository);
    }



    @Test
    void testPrint_Success() {
        // Arrange
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        List<Employee> mockEmployees = List.of(employee1, employee2);
        when(employeeRepository.findAll()).thenReturn(mockEmployees);
        when(employeeAppHelper.pirintLits(mockEmployees)).thenReturn(true);

        // Act
        boolean result = employeeService.print();

        // Assert
        assertTrue(result, "Printing the list of employees should succeed.");
    }

    @Test
    void testPrint_Failure() {
        // Arrange
        List<Employee> mockEmployees = List.of();
        when(employeeRepository.findAll()).thenReturn(mockEmployees);
        when(employeeAppHelper.pirintLits(mockEmployees)).thenReturn(false);

        // Act
        boolean result = employeeService.print();

        // Assert
        assertFalse(result, "Printing the list of employees should fail for an empty list.");

    }
}