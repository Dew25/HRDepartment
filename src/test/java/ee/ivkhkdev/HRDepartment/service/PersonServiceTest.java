package ee.ivkhkdev.HRDepartment.service;

import ee.ivkhkdev.HRDepartment.entities.Person;
import ee.ivkhkdev.HRDepartment.helpers.AppHelper;
import ee.ivkhkdev.HRDepartment.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    @Mock
    private AppHelper<Person> personAppHelper;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd_Success() throws Exception {
        // Arrange
        Person person = new Person("John", "Doe", "123456789");
        when(personAppHelper.create()).thenReturn(Optional.of(person));

        // Act
        boolean result = personService.add();

        // Assert
        assertTrue(result, "Adding a person should return true when successful.");
        verify(personRepository, times(1)).save(person);
    }

    @Test
    void testAdd_Failure() throws Exception {
        // Arrange
        when(personAppHelper.create()).thenReturn(Optional.empty());

        // Act
        boolean result = personService.add();

        // Assert
        assertFalse(result, "Adding a person should return false when no person is created.");
        verify(personRepository, never()).save(any());
    }

    @Test
    void testPrint_WithPersons() {
        // Arrange
        List<Person> persons = List.of(
                new Person("John", "Doe", "123456789"),
                new Person("Jane", "Smith", "987654321")
        );
        when(personRepository.findAll()).thenReturn(persons);
        when(personAppHelper.pirintLits(persons)).thenReturn(true);

        // Act
        boolean result = personService.print();

        // Assert
        assertTrue(result, "Printing persons should return true when there are persons in the list.");
        verify(personRepository, times(1)).findAll();
        verify(personAppHelper, times(1)).pirintLits(persons);
    }

    @Test
    void testPrint_EmptyList() {
        // Arrange
        List<Person> emptyList = List.of();
        when(personRepository.findAll()).thenReturn(emptyList);
        when(personAppHelper.pirintLits(emptyList)).thenReturn(false);

        // Act
        boolean result = personService.print();

        // Assert
        assertFalse(result, "Printing persons should return false when the list is empty.");
        verify(personRepository, times(1)).findAll();
        verify(personAppHelper, times(1)).pirintLits(emptyList);
    }


}
