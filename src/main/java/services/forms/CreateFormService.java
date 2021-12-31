package services.forms;

import database.FormRepository;
import mappers.FormMapper;
import models.Form;
import services.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFormService implements Service {

    @Inject
    private FormRepository repository;

    @Inject
    private FormMapper formMapper;

    public CreateFormService() {

    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Form form = formMapper.fromJsonToObject(req.getReader());
        form = repository.create(form);

        PrintWriter out = resp.getWriter();
        out.print(formMapper.fromObjectToJson(form));
    }
}
