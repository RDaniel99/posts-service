package services.formQuestions;

import database.FormsQuestionsRepository;
import mappers.FormQuestionMapper;
import models.FormQuestion;
import services.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFormQuestionService implements Service {

    @Inject
    private  FormsQuestionsRepository formsQuestionsRepository;

    @Inject
    private FormQuestionMapper formQuestionMapper;

    public CreateFormQuestionService() {

    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        FormQuestion formQuestion = formQuestionMapper.fromJsonToObject(req.getReader());
        formQuestion = formsQuestionsRepository.create(formQuestion);

        PrintWriter out = resp.getWriter();
        out.print(formQuestionMapper.fromObjectToJson(formQuestion));
    }
}
