package services.posts;

import database.PostsRepository;
import mappers.PostMapper;
import models.Post;
import services.Service;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetPostService implements Service {

    private PostsRepository repository;

    public GetPostService() {

        this.repository = new PostsRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // TODO: Validation
        Integer id = Integer.parseInt(req.getParameter("id"));

        Post post = repository.read(id);

        // TODO: This should be part of servlet, not service
        // TODO: To do in future, not now
        PrintWriter out = resp.getWriter();
        out.print(PostMapper.fromObjectToJson(post));
    }
}
