package servlets.posts.details;

import services.posts.details.UpdatePostDetailsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/posts/details/update")
public class UpdatePostDetailsServlet extends HttpServlet {

    @Inject
    private UpdatePostDetailsService service;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        service.execute(req, resp);
    }
}
