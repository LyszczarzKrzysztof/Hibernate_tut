package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @TableGenerator(
            name = "myGenerator",
            table = "table_with_ids",
            pkColumnName = "sequence_name",
            valueColumnName = "id_value",
            pkColumnValue = "employee_id",
            initialValue = 10,
            allocationSize = 14
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "myGenerator")
    private long id;

    private String firstName;
    private String lastName;
    private double salary;

    public Employee() {
    }

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
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
}
