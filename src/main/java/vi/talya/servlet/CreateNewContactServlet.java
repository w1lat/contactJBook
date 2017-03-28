package vi.talya.servlet;

import org.springframework.context.ApplicationContext;
import vi.talya.model.Address;
import vi.talya.model.Contact;
import vi.talya.model.ContactGroup;
import vi.talya.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by vitalii on 19.03.17.
 */
@WebServlet("/CreateNewContactServlet")
public class CreateNewContactServlet extends HttpServlet {
    private ApplicationContext applicationContext;
    private ContactService contactService;

    @Override
    public void init() throws ServletException {
        applicationContext = (ApplicationContext) getServletContext().getAttribute("spring-context");
        contactService = applicationContext.getBean(ContactService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("userName");
        String lastName = req.getParameter("userLastName");
        ContactGroup group = ContactGroup.STUDY;
        String number = req.getParameter("userNumber");
        String email = req.getParameter("userEmail");
        LocalDate birth = LocalDate.now();
        Address address = new Address("Vasylkivska", "5", "6");

        Contact contact = new Contact(name, lastName, group, number, email, address, birth);
        Contact addedContact = contactService.addContact(contact);

        String htmlCode = new String();
        htmlCode += "<ul>";
        htmlCode +=
                "<li> id:" + addedContact.getId() + "</li> " +
                        "<li> name:" + addedContact.getName() + "</li>" +
                        "<li> last name:" + addedContact.getLastName() + "</li> " +
                        "<li> group:" + addedContact.getContactGroup() + "</li> " +
                        "<li> number:" + addedContact.getPhoneNumber() + "</li> " +
                        "<li> email:" + addedContact.getEmail() + "</li> " +
                        "<li> birthday:" + addedContact.getBirhtday() + "</li> " +
                        "<li> street:" + addedContact.getAddress().getStreet() + "</li> " +
                        "<li> house:" + addedContact.getAddress().getHouseNumber() + "</li> " +
                        "<li> flat:" + addedContact.getAddress().getFlatNumber() + "</li> ";
        htmlCode += "</ul>";

        resp.setContentType("text/html");
        resp.getWriter().write(htmlCode);
    }
}
