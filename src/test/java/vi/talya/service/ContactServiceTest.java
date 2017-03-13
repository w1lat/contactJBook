package vi.talya.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vi.talya.dao.ContactDAO;
import vi.talya.dao.HibernateContactDAOImpl;
import vi.talya.exception.NoSuchContactException;
import vi.talya.model.Address;
import vi.talya.model.Contact;
import vi.talya.model.ContactGroup;

import java.time.LocalDate;
import java.util.Set;

import static net.bytebuddy.matcher.ElementMatchers.isEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vitalii on 11.03.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/app-context-test.xml")
public class ContactServiceTest {

    @Autowired
    private ContactService contactService;


    private  Contact contact;
    private Address address;

    @Before
    public void setUp(){
        contact = new Contact();
        address = new Address();

        address.setFlatNumber("32");
        address.setHouseNumber("12A");
        address.setStreet("Mechnikova");

        contact.setAddress(address);
        contact.setBirhtday(LocalDate.now());
        contact.setContactGroup(ContactGroup.FAMILY);
        contact.setEmail("dgfhgfghdf");
        contact.setName("Andrii");
        contact.setLastName("Petruk");
        contact.setPhoneNumber("80975437645");
    }

    @Test
    public void addNewContactTest(){
        Contact savedContact = contactService.addContact(contact);
        assertThat(savedContact, is(contact));
    }

    @Test
    public void getContactByIdTest() throws NoSuchContactException {

        contact.setId(3);
        contact.getAddress().setId(4);

        Contact gotContact = contactService.getContactById(3);
        assertThat(gotContact, is(contact));
    }

    @Test
    public void getAllContactsTest(){
        Set<Contact> contactSet = contactService.getAllContacts(0);
        assertThat(contactSet, is(notNullValue()));
    }

    @Test(expected = NoSuchContactException.class)
    public void removeContactTest() throws NoSuchContactException {
            contactService.removeContact(1);
    }


}
