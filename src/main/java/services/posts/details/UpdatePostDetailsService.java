package services.posts.details;

import database.PostDetailsRepository;
import mappers.PostDetailsMapper;
import mappers.PostMapper;
import models.Post;
import models.PostDetails;
import services.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdatePostDetailsService implements Service {

    private PostDetailsRepository repository;

    public UpdatePostDetailsService() {

        repository = new PostDetailsRepository();
    }


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // TODO: Add validation
        PostDetails newPostDetails = PostDetailsMapper.fromJsonToObject(req.getReader());
        Integer postDetailsId = Integer.parseInt(req.getParameter("id"));

        PostDetails originalPostDetails = repository.read(postDetailsId);
        newPostDetails = repository.update(originalPostDetails, newPostDetails);

        // TODO: This should be part of servlet, not service
        // TODO: To do in future, not now
        PrintWriter out = resp.getWriter();
        out.print(PostDetailsMapper.fromObjectToJson(newPostDetails));
    }
}
