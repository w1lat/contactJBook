package vi.talya.servlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import vi.talya.exception.NoSuchContactException;
import vi.talya.model.Contact;
import vi.talya.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vitalii on 25.03.17.
 */
@WebServlet("/GetContactByIdServlet")
public class GetContactByIdServlet extends HttpServlet{

    public static final Logger LOGGER = Logger.getLogger(GetContactByIdServlet.class);

    private ContactService contactService;
    private ApplicationContext applicationContext;

    @Override
    public void init() throws ServletException {
        applicationContext = (ApplicationContext) getServletContext().getAttribute("spring-context");
        contactService = applicationContext.getBean(ContactService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Contact contact = null;

        try {
            contact = contactService.getContactById(id);
        } catch (NoSuchContactException e) {
            LOGGER.info(e.getMessage());
        }

        String htmlCode = new String();
        htmlCode += "<ul>";
        htmlCode +=
                "<li> id:" + contact.getId() + "</li> " +
                        "<li> name:" + contact.getName() + "</li>" +
                        "<li> last name:" + contact.getLastName() + "</li> " +
                        "<li> group:" + contact.getContactGroup() + "</li> " +
                        "<li> number:" + contact.getPhoneNumber() + "</li> " +
                        "<li> email:" + contact.getEmail() + "</li> " +
                        "<li> birthday:" + contact.getBirhtday() + "</li> " +
                        "<li> street:" + contact.getAddress().getStreet() + "</li> " +
                        "<li> house:" + contact.getAddress().getHouseNumber() + "</li> " +
                        "<li> flat:" + contact.getAddress().getFlatNumber() + "</li> ";
        htmlCode += "</ul>";

        resp.setContentType("text/html");
        resp.getWriter().

                write(htmlCode);
    }
}
