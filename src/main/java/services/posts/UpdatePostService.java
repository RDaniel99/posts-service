package services.posts;

import database.PostsRepository;
import exceptions.CrudException;
import mappers.PostMapper;
import models.Post;
import services.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdatePostService implements Service {

    @Inject
    private PostsRepository repository;

    @Inject
    private PostMapper postMapper;

    public UpdatePostService() {

    }


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out = resp.getWriter();

        // TODO: Add validation
        Post newPost = postMapper.fromJsonToObject(req.getReader());
        Integer postId = Integer.parseInt(req.getParameter("id"));

        Post originalPost = repository.read(postId);
        try {

            newPost = repository.update(originalPost, newPost);
        } catch (CrudException exception) {
            out.println(exception.getReason().getReasonText());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ;
        }
        // TODO: This should be part of servlet, not service
        // TODO: To do in future, not now

        out.print(postMapper.fromObjectToJson(newPost));
    }
}
