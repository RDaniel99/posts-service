package services.posts;

import database.PostsRepository;
import dtos.PostDTO;
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

        if(isFullDetails(req)) {

            getPostByIdWithFullDetails(req, resp);
        }
        else {

            getPostByIdWithBasicDetails(req, resp);
        }
    }

    private boolean isFullDetails(HttpServletRequest req) {

        String details = req.getParameter("details");

        return details == null || details.equals("FULL");
    }

    public void getPostByIdWithBasicDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));

        Post post = repository.read(id);

        PrintWriter out = resp.getWriter();
        out.write(PostMapper.fromObjectToJson(post));
    }

    public void getPostByIdWithFullDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));

        PostDTO postDTO = repository.readFull(id);

        PrintWriter out = resp.getWriter();
        out.write(PostMapper.fromDtoToJson(postDTO));
    }
}
