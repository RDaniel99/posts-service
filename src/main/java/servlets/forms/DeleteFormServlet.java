package servlets.forms;

import services.forms.DeleteFormService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/forms/delete/*")
public class DeleteFormServlet extends HttpServlet {

    @Inject
    private DeleteFormService service;

    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    protected void doDelete
            (HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
