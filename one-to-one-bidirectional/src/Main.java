import entity.Cat;
import entity.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Owner owner = new Owner();
        Cat cat = new Cat();

        owner.setFirstName("Jan");
        owner.setLastName("Kowalski");
        cat.setName("Bonifacy");
        owner.setCat(cat);

        entityManager.getTransaction().begin();
        entityManager.persist(owner);
        entityManager.persist(cat);
        entityManager.getTransaction().commit();

        entityManager.refresh(cat);

        entityManager.close();
        entityManagerFactory.close();
    }
}
