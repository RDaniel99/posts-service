package servlets.forms;

import services.forms.DeleteFormService;
import services.forms.ReadFormService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//TO-DO: modify this
@WebServlet(value = "/api/forms/delete/*")
public class DeleteFormServlet extends HttpServlet {

    private DeleteFormService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new DeleteFormService();
    }

    @Override
    protected void doDelete
            (HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
