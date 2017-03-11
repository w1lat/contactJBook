package vi.talya;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vi.talya.exception.NoSuchContactException;
import vi.talya.model.Address;
import vi.talya.model.Contact;
import vi.talya.model.ContactGroup;
import vi.talya.service.ContactService;

import java.time.LocalDate;


public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        ContactService service = context.getBean(ContactService.class);

        Contact contact = new Contact();
        Address address = new Address();

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


        Contact createdContact = service.addContact(contact);

        try {
            Contact contact1 = service.getContactById(createdContact.getId());
            System.out.println(contact1);
        } catch (NoSuchContactException e) {
            e.printStackTrace();
        }



    }
}
