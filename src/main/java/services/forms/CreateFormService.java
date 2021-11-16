package services.forms;

import database.FormRepository;
import mappers.FormMapper;
import models.Form;
import services.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFormService implements Service {

    private final FormRepository repository;

    public CreateFormService() {

        repository = new FormRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Form form = FormMapper.fromJsonToObject(req.getReader());
        form = repository.create(form);

        PrintWriter out = resp.getWriter();
        out.print(FormMapper.fromObjectToJson(form));
    }
}
