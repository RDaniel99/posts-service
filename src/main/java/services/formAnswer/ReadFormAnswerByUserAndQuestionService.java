package services.formAnswer;

import database.FormAnswerRepository;
import mappers.FormAnswerMapper;
import models.FormAnswer;
import models.FormQuestion;
import services.Service;
import services.utils.PathUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReadFormAnswerByUserAndQuestionService implements Service {

    private final FormAnswerRepository repository;

    public ReadFormAnswerByUserAndQuestionService() {

            this.repository = new FormAnswerRepository();
        }

        @Override
        public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

            Integer questionId = Integer.parseInt(req.getParameter("questionId"));
            Integer userId = Integer.parseInt(req.getParameter("userId"));

            FormAnswer formAnswer = repository.readByQuestionAndUserId(userId, questionId);

            PrintWriter out = resp.getWriter();
            out.print(FormAnswerMapper.fromObjectToJson(formAnswer));

    }
}
