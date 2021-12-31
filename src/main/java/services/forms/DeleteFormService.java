package services.forms;

import database.FormRepository;
import services.Service;
import services.utils.PathUtils;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteFormService implements Service {

    @Inject
    private FormRepository repository;

    public DeleteFormService() {

    }


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String path = req.getPathInfo();

        Integer id = PathUtils.getEntityId(path);
        Boolean result = repository.delete(id);

        PrintWriter out = resp.getWriter();
        out.print(result);
    }

}
