package servlets.formAnswer;

import services.formAnswer.DeleteFormAnswerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/formAnswer/delete/*")
public class DeleteFormAnswerServlet extends HttpServlet {

    private DeleteFormAnswerService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new DeleteFormAnswerService();
    }

    @Override
    protected void doDelete
            (HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
