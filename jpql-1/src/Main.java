import entity.Employee;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        addEmployees();
//        TypedQuery<Employee> query = entityManager.createQuery(
//                "select e from Employee e where e.salary > 3000.0 order by e.salary",
//                   Employee.class);

//        Employee employee = query.getSingleResult();// gdy zwraca jeden obiekt
//        List<Employee> employees = query.getResultList();// gdy zwraca wiecej niz jeden obiekt

//        System.out.println(employee);

//        employees.forEach(System.out::println);

        Query query = entityManager.createQuery("select concat(e.firstName,' ', e.lastName), " +
                "e.salary*0.2 from Employee e");

        Iterator<?> iterator = query.getResultList().iterator();

        while (iterator.hasNext()){
            Object[] item = (Object[]) iterator.next();
            String name = (String) item[0];
            double tax = (double) item[1];
            System.out.println(name+" has to pay "+tax);
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
