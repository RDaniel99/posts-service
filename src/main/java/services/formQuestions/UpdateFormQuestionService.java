package services.formQuestions;

import database.FormsQuestionsRepository;
import mappers.FormQuestionMapper;
import models.FormQuestion;
import services.Service;
import services.utils.PathUtils;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateFormQuestionService implements Service {

    @Inject
    private  FormsQuestionsRepository repository;

    @Inject
    private FormQuestionMapper formQuestionMapper;

    public UpdateFormQuestionService() {

    }


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String path = req.getPathInfo();

        FormQuestion newFormQuestion = formQuestionMapper.fromJsonToObject(req.getReader());
        Integer id = PathUtils.getEntityId(path);

        FormQuestion originalFormQuestion = repository.read(id);

        newFormQuestion = repository.update(originalFormQuestion, newFormQuestion);

        PrintWriter out = resp.getWriter();
        out.print(formQuestionMapper.fromObjectToJson(newFormQuestion));
    }
}
