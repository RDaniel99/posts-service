package servlets.formQuestions;

import aop.annotation.FormQuestionPayloadValidate;
import services.formQuestions.CreateFormQuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/formQuestions/create")
public class CreateFormQuestionsServlet extends HttpServlet {

    private CreateFormQuestionService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new CreateFormQuestionService();
    }

    @Override
    protected void doPost(@FormQuestionPayloadValidate HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }

}
