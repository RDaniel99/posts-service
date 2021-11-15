package servlets.forms;

import services.forms.CreateFormService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/forms/create")
public class CreateFormServlet extends HttpServlet {

    private CreateFormService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new CreateFormService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}

