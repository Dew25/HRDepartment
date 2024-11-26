package ee.ivkhkdev.HRDepartment.entities;

public class Employee {
    private Long id;
    private String position;
    private String salary;
    private Person person;

    public Employee() {
    }

    public Employee(Long id, String position, String salary, Person person) {
        this.id = id;
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
}
