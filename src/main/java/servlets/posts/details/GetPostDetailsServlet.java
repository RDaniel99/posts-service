package servlets.posts.details;

import services.posts.GetPostService;
import services.posts.details.GetPostDetailsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/posts/details/get")
public class GetPostDetailsServlet extends HttpServlet {

    private GetPostDetailsService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new GetPostDetailsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        service.execute(req, resp);
    }
}
