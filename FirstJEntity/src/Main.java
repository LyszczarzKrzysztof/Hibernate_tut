import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();

//        employee.setId(2);
        employee.setFirstName("Kamil");
        employee.setLastName("Kamilowski");
        employee.setSalary(4444.3);

        Employee employee1 = new Employee();

        employee1.setFirstName("Dominik");
        employee1.setLastName("Domaniewski");
        employee1.setSalary(6666.3);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(employee1);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
