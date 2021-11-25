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
import java.util.List;

public class ReadFormQuestionByFormIdService implements Service {

    private final FormsQuestionsRepository repository;

    public ReadFormQuestionByFormIdService() {

        this.repository = new FormsQuestionsRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Integer id = Integer.parseInt(req.getParameter("formId"));
        List<FormQuestion> formQuestion = repository.readByFormID(id);

        PrintWriter out = resp.getWriter();
        out.print(FormQuestionMapper.fromObjectListToJson(formQuestion));

    }

}
