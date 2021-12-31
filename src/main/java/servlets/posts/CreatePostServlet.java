package servlets.posts;

import services.posts.CreatePostService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/posts/create")
public class CreatePostServlet extends HttpServlet {

    @Inject
    private CreatePostService service;

    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
