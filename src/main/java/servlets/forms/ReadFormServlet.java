package servlets.forms;

import services.forms.ReadFormService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TO-DO: I saw that you used query-params here. Should I also change it?
@WebServlet(value = "/api/forms/get/*")
public class ReadFormServlet extends HttpServlet {

    @Inject
    private ReadFormService service;

    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
