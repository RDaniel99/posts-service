package services.formAnswer;

import database.FormAnswerRepository;
import mappers.FormAnswerMapper;
import models.FormAnswer;
import services.Service;
import services.utils.PathUtils;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadFormAnswerService implements Service {

    @Inject
    private  FormAnswerRepository repository;

    @Inject
    private FormAnswerMapper mapper;

    public ReadFormAnswerService() {

    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String path = req.getPathInfo();

        Integer id = PathUtils.getEntityId(path);
        FormAnswer formAnswer = repository.read(id);

        PrintWriter out = resp.getWriter();
        out.print(mapper.fromObjectToJson(formAnswer));

    }
}
