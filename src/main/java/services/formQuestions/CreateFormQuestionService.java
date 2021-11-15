package services.formQuestions;

import database.FormsQuestionsRepository;
import mappers.FormQuestionMapper;
import models.FormQuestion;
import services.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFormQuestionService implements Service {

    private final FormsQuestionsRepository formsQuestionsRepository;


    public CreateFormQuestionService() {

        this.formsQuestionsRepository = new FormsQuestionsRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        FormQuestion formQuestion = FormQuestionMapper.fromJsonToObject(req.getReader());
        formQuestion = formsQuestionsRepository.create(formQuestion);

        PrintWriter out = resp.getWriter();
        out.print(FormQuestionMapper.fromObjectToJson(formQuestion));
    }
}
