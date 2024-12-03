package ee.ivkhkdev.HRDepartment.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String salary;
    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    public Employee() {
    }

    public Employee(String position, String salary, Person person) {
        this.position = position;
        this.salary = salary;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", position='").append(position).append('\'');
        sb.append(", salary='").append(salary).append('\'');
        sb.append(", person=").append(person);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(position, employee.position) && Objects.equals(salary, employee.salary) && Objects.equals(person, employee.person);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(position);
        result = 31 * result + Objects.hashCode(salary);
        result = 31 * result + Objects.hashCode(person);
        return result;
    }
}
