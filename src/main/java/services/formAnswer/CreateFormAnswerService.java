package services.formAnswer;

import database.FormAnswerRepository;
import mappers.FormAnswerMapper;
import models.FormAnswer;
import services.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFormAnswerService implements Service {

    private final FormAnswerRepository formAnswerRepository;


    public CreateFormAnswerService() {

        this.formAnswerRepository = new FormAnswerRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        FormAnswer formAnswer = FormAnswerMapper.fromJsonToObject(req.getReader());
        formAnswer = formAnswerRepository.create(formAnswer);

        PrintWriter out = resp.getWriter();
        out.print(FormAnswerMapper.fromObjectToJson(formAnswer));
    }
}
