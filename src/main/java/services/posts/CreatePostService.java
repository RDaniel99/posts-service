package services.posts;

import database.PostsRepository;
import mappers.PostMapper;
import models.Post;
import services.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreatePostService implements Service {

    @Inject
    private PostsRepository repository;

    @Inject
    private PostMapper postMapper;

    public CreatePostService() {

    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // TODO: Add validation
        Post post = postMapper.fromJsonToObject(req.getReader());
        post = repository.create(post);

        // TODO: This should be part of servlet, not service
        // TODO: To do in future, not now
        PrintWriter out = resp.getWriter();
        out.print(postMapper.fromObjectToJson(post));
    }
}
