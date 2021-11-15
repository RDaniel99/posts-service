package servlets.posts;

import services.posts.DeletePostService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/api/posts/delete")
public class DeletePostServlet extends HttpServlet {

    private DeletePostService service;

    @Override
    public void init() throws ServletException {
        super.init();

        service = new DeletePostService();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        service.execute(req, resp);
    }


}
