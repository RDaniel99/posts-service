package servlets.formQuestions;

import services.formQuestions.DeleteFormQuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/formQuestions/delete/*")
public class DeleteFormQuestionsServlet extends HttpServlet {

    private DeleteFormQuestionService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new DeleteFormQuestionService();
    }

    @Override
    protected void doDelete
            (HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
