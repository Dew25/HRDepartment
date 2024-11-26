package ee.ivkhkdev.HRDepartment.entities;

public class Person {
    private Long id;
    private String firsname;
    private String lastname;
    private String phone;

    public Person() {
    }

    public Person(Long id, String firsname, String lastname, String phone) {
        this.id = id;
        this.firsname = firsname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", firsname='").append(firsname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
