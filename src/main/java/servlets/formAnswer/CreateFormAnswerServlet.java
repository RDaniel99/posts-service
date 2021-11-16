package servlets.formAnswer;

import services.formAnswer.CreateFormAnswerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/formAnswer/create")
public class CreateFormAnswerServlet extends HttpServlet {

    private CreateFormAnswerService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new CreateFormAnswerService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
