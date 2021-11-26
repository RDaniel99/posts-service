package servlets.formAnswer;

import services.formAnswer.ReadFormAnswerByUserAndQuestionService;
import services.formAnswer.ReadFormAnswerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/formAnswer/getByUserAndQuestion")
public class ReadFormAnswerByUserAndQuestion extends HttpServlet {

    private ReadFormAnswerByUserAndQuestionService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new ReadFormAnswerByUserAndQuestionService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
