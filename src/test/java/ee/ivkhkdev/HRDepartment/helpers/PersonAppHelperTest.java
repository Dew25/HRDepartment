package ee.ivkhkdev.HRDepartment.helpers;

import ee.ivkhkdev.HRDepartment.entities.Person;
import ee.ivkhkdev.HRDepartment.input.Input;
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

class PersonAppHelperTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private Input input;

    @InjectMocks
    private PersonAppHelper personAppHelper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate_Success() {
        // Arrange
        when(input.nextLine()).thenReturn("John", "Doe", "123456789");

        // Act
        Optional<Person> result = personAppHelper.create();

        // Assert
        assertTrue(result.isPresent(), "Person creation should return a non-empty optional.");
        Person person = result.get();
        assertEquals("John", person.getFirsname(), "First name should match input.");
        assertEquals("Doe", person.getLastname(), "Last name should match input.");
        assertEquals("123456789", person.getPhone(), "Phone should match input.");
        verify(input, times(3)).nextLine();
    }

    @Test
    void testCreate_EmptyInput() {
        // Arrange
        when(input.nextLine()).thenReturn("", "", "");

        // Act
        Optional<Person> result = personAppHelper.create();

        // Assert
        assertTrue(result.isPresent(), "Person creation should still return a person even if input is empty.");
        Person person = result.get();
        assertEquals("", person.getFirsname(), "First name should be empty.");
        assertEquals("", person.getLastname(), "Last name should be empty.");
        assertEquals("", person.getPhone(), "Phone should be empty.");
        verify(input, times(3)).nextLine();
    }

    @Test
    void testPirintLits_WithEntities() {
        // Arrange
        Person person1 = new Person("John", "Doe", "123456789");
        Person person2 = new Person("Jane", "Smith", "987654321");
        List<Person> persons = List.of(person1, person2);

        // Act
        boolean result = personAppHelper.pirintLits();

        // Assert
        assertTrue(result, "Printing the list of persons should return true for non-empty list.");
    }

    @Test
    void testPirintLits_EmptyList() {
        // Arrange
        List<Person> persons = List.of();

        // Act
        boolean result = personAppHelper.pirintLits();

        // Assert
        assertFalse(result, "Printing the list of persons should return false for an empty list.");
    }
}
