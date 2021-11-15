package servlets.posts;

import services.posts.GetPostService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/posts/get")
public class GetPostServlet extends HttpServlet {

    private GetPostService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new GetPostService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        service.execute(req, resp);
    }
}
