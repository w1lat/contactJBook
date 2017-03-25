package vi.talya.servlet;

import org.springframework.context.ApplicationContext;
import vi.talya.model.Contact;
import vi.talya.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by vitalii on 14.03.17.
 */

public class AllContactsServlet extends HttpServlet {

    private ApplicationContext applicationContext;
    private ContactService service;

    @Override
    public void init() throws ServletException {
        applicationContext = (ApplicationContext) getServletContext().getAttribute("spring-context" );
        service = applicationContext.getBean(ContactService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int offset = Integer.parseInt(req.getParameter("offset"));

        Set<Contact> contacts = service.getAllContacts(offset);

        req.setAttribute("contacts", contacts);

        req.getRequestDispatcher("WEB-INF/jsp/all_contacts.jsp").forward(req, resp);

    }
}
