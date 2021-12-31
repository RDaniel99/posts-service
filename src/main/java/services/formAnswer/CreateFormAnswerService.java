package services.formAnswer;

import database.FormAnswerRepository;
import mappers.FormAnswerMapper;
import models.FormAnswer;
import services.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFormAnswerService implements Service {

    @Inject
    private FormAnswerRepository formAnswerRepository;

    @Inject
    private FormAnswerMapper formAnswerMapper;

    public CreateFormAnswerService() {

    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        FormAnswer formAnswer = formAnswerMapper.fromJsonToObject(req.getReader());
        formAnswer = formAnswerRepository.create(formAnswer);

        PrintWriter out = resp.getWriter();
        out.print(formAnswerMapper.fromObjectToJson(formAnswer));
    }
}
