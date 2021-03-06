package services.formQuestions;

import database.FormsQuestionsRepository;
import mappers.FormQuestionMapper;
import models.FormQuestion;
import services.Service;
import services.utils.PathUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadFormQuestionService implements Service {

    private final FormsQuestionsRepository repository;

    public ReadFormQuestionService() {

        this.repository = new FormsQuestionsRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String path = req.getPathInfo();

        Integer id = PathUtils.getEntityId(path);
        FormQuestion formQuestion = repository.read(id);

        PrintWriter out = resp.getWriter();
        out.print(FormQuestionMapper.fromObjectToJson(formQuestion));

    }
}
