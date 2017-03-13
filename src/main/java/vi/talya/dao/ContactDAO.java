package vi.talya.dao;

import org.springframework.stereotype.Repository;
import vi.talya.exception.NoSuchContactException;
import vi.talya.model.Contact;

import java.util.List;

/**
 * Created by vitalii on 07.03.17.
 */
@Repository
public interface ContactDAO {

    Contact saveContact(Contact contact);
    Contact deleteContact(int id);
    Contact findContactById(int id);
    Contact findContactByPhoneNumber(String phoneNumber);
    List<Contact> findContactByName(String name);
    List<Contact> getAll(int offset);

}
