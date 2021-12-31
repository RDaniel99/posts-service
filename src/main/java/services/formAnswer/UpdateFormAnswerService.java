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

public class UpdateFormAnswerService implements Service {

    @Inject
    private  FormAnswerRepository repository;

    @Inject
    private FormAnswerMapper formAnswerMapper;

    public UpdateFormAnswerService() {

    }


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String path = req.getPathInfo();

        FormAnswer newFormAnswer = formAnswerMapper.fromJsonToObject(req.getReader());
        Integer id = PathUtils.getEntityId(path);

        FormAnswer originalFormAnswer = repository.read(id);

        newFormAnswer = repository.update(originalFormAnswer, newFormAnswer);

        PrintWriter out = resp.getWriter();
        out.print(formAnswerMapper.fromObjectToJson(newFormAnswer));
    }
}
