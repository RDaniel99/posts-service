package services.posts;

import database.PostsRepository;
import mappers.PostMapper;
import models.Post;
import services.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreatePostService implements Service {

    private final PostsRepository repository;

    public CreatePostService() {

        repository = new PostsRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // TODO: Add validation
        Post post = PostMapper.fromJsonToObject(req.getReader());
        post = repository.create(post);

        PrintWriter out = resp.getWriter();
        out.print(PostMapper.fromObjectToJson(post));
    }
}
