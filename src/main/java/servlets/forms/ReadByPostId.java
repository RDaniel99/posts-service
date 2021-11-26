package servlets.forms;

import services.forms.ReadByPostIdService;
import services.forms.ReadFormService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/forms/get")
public class ReadByPostId extends HttpServlet {

    private ReadByPostIdService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new ReadByPostIdService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}

