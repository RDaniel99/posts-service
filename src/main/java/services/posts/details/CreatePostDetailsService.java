package services.posts.details;

import database.PostDetailsRepository;
import mappers.PostDetailsMapper;
import models.PostDetails;
import services.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreatePostDetailsService implements Service {

    @Inject
    private PostDetailsRepository repository;

    @Inject
    private PostDetailsMapper postDetailsMapper;

    public CreatePostDetailsService() {

        repository = new PostDetailsRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // TODO: Add validation
        PostDetails details = postDetailsMapper.fromJsonToObject(req.getReader());
        details = repository.create(details);

        // TODO: This should be part of servlet, not service
        // TODO: To do in future, not now
        PrintWriter out = resp.getWriter();
        out.print(postDetailsMapper.fromObjectToJson(details));
    }
}
