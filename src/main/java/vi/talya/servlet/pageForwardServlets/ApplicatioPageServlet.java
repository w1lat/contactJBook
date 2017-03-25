package vi.talya.servlet.pageForwardServlets;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by vitalii on 22.03.17.
 */
@WebServlet("/all")
public class ApplicatioPageServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        getServletContext().setAttribute("offset", "0");
        req.getRequestDispatcher("WEB-INF/jsp/all-in-one.jsp").forward(req, res);
    }
}
