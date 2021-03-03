package entity;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.List;

// entity name  - nazwa encji - wykorzystywana np w zapytaniu
// table name - nazwa tablicy - jesli jej nie ma to tabela bierze nazwe z entity name
// jasli nie ma obu to tabela bierze nazwe klasy
@Entity(name = "Pracownik")
@Table(name = "Pracownicy")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private double salary;

//       normalnie bez uzycia cascade w sesji (tu w funkcji Main) trzeba zapisywać takze telefony metodą persist()
//        jesli sie uzyje w adnotacji OneToMany cascade to wtedy hibernate bierze pod uwage encje z wszystkimi "podencjami"
//    i nie trzeba ich osobno zapisywac do bd
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private List<Phone> phones;

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", phones=" + phones +
                '}';
    }
}
