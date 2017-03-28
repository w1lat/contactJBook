package vi.talya.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vi.talya.utils.customAnnotations.Profilling;
import vi.talya.dao.ContactDAO;
import vi.talya.exception.NoSuchContactException;
import vi.talya.model.Contact;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vitalii on 07.03.17.
 */
@Service(value = "contactService")
@Transactional
@Profilling
public class ContactServiceImpl implements ContactService {

    public static final Logger LOGGER = Logger.getLogger(ContactService.class);
    public static final String CONTACT_NOT_FOUN_MESSAGE = "Contact can not be found with such id: ";

    @Autowired
    private ContactDAO contactDAO;

    public ContactServiceImpl(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public Contact addContact(Contact contact) {
        LOGGER.debug("Adding new contact begin");

        Contact savedContact = contactDAO.saveContact(contact);

        LOGGER.debug("Adding new contact end");
        return savedContact;
    }

    public Contact removeContact(int id) throws NoSuchContactException {
        LOGGER.debug("Removing contact begin");

        Contact removedContact = contactDAO.deleteContact(id);

        if(removedContact == null){
            throw new NoSuchContactException(CONTACT_NOT_FOUN_MESSAGE + id);
        }

        LOGGER.debug("Removing contact end");
        return removedContact;
    }

    public Contact getContactById(int id) throws NoSuchContactException {
        LOGGER.debug("Getiing contact by ID begin");

        Contact foundContact = contactDAO.findContactById(id);

        if(foundContact == null){
            throw new NoSuchContactException(CONTACT_NOT_FOUN_MESSAGE + id);
        }

        LOGGER.debug("Getiing contact by ID end");
        return foundContact;
    }

    public Set<Contact> getAllContacts(int offset){
        LOGGER.debug("Getting all contacts begin");

        Set<Contact> contacts = new HashSet<>(contactDAO.getAll(offset));

        LOGGER.debug("Getting all contacts end");
        return contacts;
    }
}
