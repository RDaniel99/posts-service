package servlets.forms;

import services.forms.ReadFormService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//To-do: modify this
@WebServlet(value = "/api/forms/*")
public class ReadFormServlet extends HttpServlet {

    private ReadFormService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new ReadFormService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
