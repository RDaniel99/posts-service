package servlets.posts;

import services.posts.CreatePostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/posts")
public class CreatePostServlet extends HttpServlet {

    private CreatePostService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new CreatePostService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
