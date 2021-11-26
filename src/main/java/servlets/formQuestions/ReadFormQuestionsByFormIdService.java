package servlets.formQuestions;

import services.formQuestions.ReadFormQuestionByFormIdService;
import services.formQuestions.ReadFormQuestionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/formQuestions/getByFormId")
public class ReadFormQuestionsByFormIdService extends HttpServlet {

    private ReadFormQuestionByFormIdService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new ReadFormQuestionByFormIdService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
