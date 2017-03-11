package vi.talya.service;

import vi.talya.exception.NoSuchContactException;
import vi.talya.model.Address;
import vi.talya.model.Contact;
import vi.talya.model.ContactGroup;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vitalii on 07.03.17.
 */
public interface ContactService {

    Contact addContact(Contact contact);
    Contact removeContact(int id) throws NoSuchContactException;
    Contact getContactById(int id) throws NoSuchContactException;
    Set<Contact> getAllContacts(int offset);

}
