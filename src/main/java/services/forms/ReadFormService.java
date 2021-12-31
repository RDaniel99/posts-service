package services.forms;

import database.FormRepository;
import exceptions.FormReadException;
import mappers.FormMapper;
import models.Form;
import services.Service;
import services.utils.PathUtils;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadFormService implements Service {

    @Inject
    private  FormRepository repository;

    @Inject
    private FormMapper formMapper;

    public ReadFormService() {

    }


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, FormReadException {

        String path = req.getPathInfo();

        Integer id = PathUtils.getEntityId(path);
        Form form = repository.read(id);

        PrintWriter out = resp.getWriter();
        out.print(formMapper.fromObjectToJson(form));
    }
}
