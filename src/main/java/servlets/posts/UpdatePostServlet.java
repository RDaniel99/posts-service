package servlets.posts;

import services.posts.UpdatePostService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/posts/update")
public class UpdatePostServlet extends HttpServlet {

    @Inject
    private UpdatePostService service;

    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        service.execute(req, resp);
    }
}
