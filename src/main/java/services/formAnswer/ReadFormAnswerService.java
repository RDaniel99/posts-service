package services.formAnswer;

import database.FormAnswerRepository;
import database.FormsQuestionsRepository;
import mappers.FormAnswerMapper;
import mappers.FormQuestionMapper;
import models.FormAnswer;
import models.FormQuestion;
import services.Service;
import services.utils.PathUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadFormAnswerService implements Service {

    private final FormAnswerRepository repository;

    public ReadFormAnswerService() {

        this.repository = new FormAnswerRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String path = req.getPathInfo();

        Integer id = PathUtils.getEntityId(path);
        FormAnswer formAnswer = repository.read(id);

        PrintWriter out = resp.getWriter();
        out.print(FormAnswerMapper.fromObjectToJson(formAnswer));

    }
}
