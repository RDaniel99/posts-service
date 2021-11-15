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

public class UpdateFormQuestionService implements Service {

    private final FormsQuestionsRepository repository;

    public UpdateFormQuestionService() {

        this.repository = new FormsQuestionsRepository();
    }


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String path = req.getPathInfo();

        FormQuestion newFormQuestion = FormQuestionMapper.fromJsonToObject(req.getReader());
        Integer id = PathUtils.getEntityId(path);

        FormQuestion originalFormQuestion = repository.read(id);

        newFormQuestion = repository.update(originalFormQuestion, newFormQuestion);

        PrintWriter out = resp.getWriter();
        out.print(FormQuestionMapper.fromObjectToJson(newFormQuestion));
    }
}
