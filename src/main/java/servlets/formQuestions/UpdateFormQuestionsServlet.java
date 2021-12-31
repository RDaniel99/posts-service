package servlets.formQuestions;

import services.formQuestions.UpdateFormQuestionService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/formQuestions/update/*")
public class UpdateFormQuestionsServlet extends HttpServlet {

    @Inject
    private UpdateFormQuestionService service;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
