package vi.talya.servlet;

import org.springframework.context.ApplicationContext;
import vi.talya.model.Contact;
import vi.talya.service.ContactService;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetUsersServlet")
public class GetUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ApplicationContext applicationContext;
    private ContactService service;

    @Override
    public void init() throws ServletException {
        applicationContext = (ApplicationContext) getServletContext().getAttribute("spring-context");
        service = applicationContext.getBean(ContactService.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int offset = Integer.parseInt(getServletContext().getAttribute("offset").toString());

        Set<Contact> contacts = service.getAllContacts(offset);

        if(offset > 0 && contacts.size() == 0){
            offset = 0;
            contacts = service.getAllContacts(offset);
        }

        getServletContext().setAttribute("offset", ++offset);
        String htmlCode = new String();
        htmlCode += "<ul>";
        TreeSet<Contact> sortedSet = new TreeSet<>(contacts);
        for (Contact contact : sortedSet) {
            htmlCode +=
                    "<li> id:" + contact.getId() +
                            "</li> <li> name:" + contact.getName() +
                            "</li>";
        }
        htmlCode += "</ul>";

        response.setContentType("text/html");
        response.getWriter().write(htmlCode);
    }

}