package services.posts.details;

import database.PostDetailsRepository;
import exceptions.CrudException;
import mappers.PostDetailsMapper;
import models.PostDetails;
import services.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdatePostDetailsService implements Service {

    @Inject
    private PostDetailsRepository repository;

    @Inject
    private PostDetailsMapper postDetailsMapper;

    public UpdatePostDetailsService() {

    }


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out = resp.getWriter();

        // TODO: Add validation
        PostDetails newPostDetails = postDetailsMapper.fromJsonToObject(req.getReader());
        Integer postDetailsId = Integer.parseInt(req.getParameter("id"));

        PostDetails originalPostDetails = repository.read(postDetailsId);
        try {
            newPostDetails = repository.update(originalPostDetails, newPostDetails);
        } catch (CrudException exception) {
            out.println(exception.getReason().getReasonText());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return ;
        }

        // TODO: This should be part of servlet, not service
        // TODO: To do in future, not now

        out.print(postDetailsMapper.fromObjectToJson(newPostDetails));
    }
}
