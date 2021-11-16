package servlets.formAnswer;

import services.formAnswer.ReadFormAnswerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/formAnswer/get/*")
public class ReadFormAnswerServlet extends HttpServlet {

    private ReadFormAnswerService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new ReadFormAnswerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }

}
