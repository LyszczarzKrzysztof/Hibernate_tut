import entity.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        addEmployees();

//        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e " +
//                "where e.salary> :minSalary", Employee.class);
//        query.setParameter("minSalary", 5000.0);

//        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e " +
//                "where e.salary> ?1 and e.salary < ?2", Employee.class);
//
//        query.setParameter(1, 2000.0);
//        query.setParameter(2, 3000.0);

        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.lastName in :names",
                Employee.class);

        List<String> names = new ArrayList<>();
        names.add("Mateusiak");
        names.add("Bednarek");
        query.setParameter("names", names);

        for (Employee employee : query.getResultList()) {
            System.out.println(employee);
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void addEmployees() {
        addEmployee("Karol", "Mateusiak", 2633);
        addEmployee("Marika", "Bednarek", 2345);
        addEmployee("Jan", "Mateusiak", 7346);
        addEmployee("Daria", "Kowalska", 2352);
        addEmployee("Monika", "Ucińska", 4263);
        addEmployee("Ernest", "Pająk", 2634);
        addEmployee("Kamil", "Stępień", 2345);
        addEmployee("Przemek", "Maciejewski", 5433);
        addEmployee("Robert", "Woźniak", 3324);
        addEmployee("Agnieszka", "Nowak", 2000);
        addEmployee("Angelika", "Bednarska", 1000);
    }

    private static void addEmployee(String firstName, String lastName, double salary) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(salary);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }
}
