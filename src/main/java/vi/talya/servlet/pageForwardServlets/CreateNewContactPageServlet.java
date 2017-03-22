package vi.talya.servlet.pageForwardServlets;

import org.springframework.context.ApplicationContext;
import vi.talya.service.ContactService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vitalii on 19.03.17.
 */
@WebServlet("/create")
public class CreateNewContactPageServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/jsp/add_new_contact.jsp").forward(req, resp);
    }
}
