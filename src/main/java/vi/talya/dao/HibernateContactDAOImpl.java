package vi.talya.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vi.talya.exception.NoSuchContactException;
import vi.talya.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by vitalii on 07.03.17.
 */
@Component(value = "contactDao")
public class HibernateContactDAOImpl implements ContactDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Contact saveContact(Contact contact) {

        entityManager.persist(contact);

        return contact;
    }

    public Contact deleteContact(int id) {

        Contact forDelete = entityManager.find(Contact.class, id);
        entityManager.remove(forDelete);

        return forDelete;

    }

    public Contact findContactById(int id) {

        Contact foundContact = entityManager.find(Contact.class, id);

        return foundContact;
    }

    public Contact findContactByPhoneNumber(String phoneNumber) {

        return entityManager.createQuery("SELECT c FROM Contact c WHERE c.phoneNumber = :phoneNumber", Contact.class)
                .setParameter("phoneNumber", phoneNumber).getSingleResult();
    }

    public List<Contact> findContactByName(String lastname) {

        return entityManager.createQuery("SELECT c FROM Contact c WHERE c.lastname = :lastname", Contact.class)
                .setParameter("lastname", lastname).getResultList();
    }

    public List<Contact> getAll(int offset) {

        return entityManager.createQuery("SELECT c FROM Contact c", Contact.class)
                .setFirstResult(offset).setMaxResults(50).getResultList();
    }
}
