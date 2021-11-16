package servlets.posts.details;

import services.posts.CreatePostService;
import services.posts.details.CreatePostDetailsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/posts/details/create")
public class CreatePostDetailsServlet extends HttpServlet {

    private CreatePostDetailsService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new CreatePostDetailsService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        service.execute(req, resp);
    }
}
