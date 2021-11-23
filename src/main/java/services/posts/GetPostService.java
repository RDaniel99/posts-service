package services.posts;

import database.PostsRepository;
import dtos.PostDTO;
import mappers.PostMapper;
import models.Post;
import services.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class GetPostService implements Service {

    private PostsRepository repository;

    public GetPostService() {

        this.repository = new PostsRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // TODO: Validation

        if(isFullDetails(req)) {

            getWithFullDetails(req, resp);
        }
        else {

            getWithBasicDetails(req, resp);
        }
    }

    private boolean isFullDetails(HttpServletRequest req) {

        String details = req.getParameter("details");

        return details == null || details.equals("FULL");
    }

    private void getWithBasicDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Optional<Integer> id;

        try {
            id = Optional.of(Integer.parseInt(req.getParameter("id")));
        } catch (Exception ignored) {
            id = Optional.empty();
        }

        if(id.isPresent()) {

            getPostByIdWithBasicDetails(id.get(), resp);
        }
        else {

            getPostsWithBasicDetails(req, resp);
        }
    }

    private void getPostsWithBasicDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Optional<Integer> userId = getUserIdParameterValue(req);
        Optional<String> status = getStatusParameterValue(req);

        List<Post> posts = repository.readAll(userId, status);

        PrintWriter out = resp.getWriter();
        out.write(PostMapper.fromListOfObjectsToJson(posts));
    }

    private void getPostByIdWithBasicDetails(Integer id, HttpServletResponse resp) throws IOException {

        Post post = repository.read(id);

        PrintWriter out = resp.getWriter();
        out.write(PostMapper.fromObjectToJson(post));
    }

    private void getWithFullDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Optional<Integer> id;

        try {
            id = Optional.of(Integer.parseInt(req.getParameter("id")));
        } catch (Exception ignored) {
            id = Optional.empty();
        }

        if(id.isPresent()) {

            getPostByIdWithFullDetails(id.get(), resp);
        }
        else {

            getPostsWithFullDetails(req, resp);
        }
    }

    private void getPostByIdWithFullDetails(Integer id, HttpServletResponse resp) throws IOException {

        PostDTO postDTO = repository.readFull(id);

        PrintWriter out = resp.getWriter();
        out.write(PostMapper.fromDtoToJson(postDTO));
    }

    private void getPostsWithFullDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Optional<Integer> userId = getUserIdParameterValue(req);
        Optional<String> status = getStatusParameterValue(req);

        List<PostDTO> postsDTOs = repository.readAllFull(userId, status);

        PrintWriter out = resp.getWriter();
        out.write(PostMapper.fromListOfObjectsToJson(postsDTOs));
    }

    private Optional<Integer> getUserIdParameterValue(HttpServletRequest req) {

        Optional<Integer> userId;

        try {
            userId = Optional.of(Integer.parseInt(req.getParameter("userId")));
        } catch (Exception ignored) {
            userId = Optional.empty();
        }

        return userId;
    }

    private Optional<String> getStatusParameterValue(HttpServletRequest req) {

        Optional<String> status;

        try {
            status = Optional.of(req.getParameter("status"));
        } catch (Exception ignored) {
            status = Optional.empty();
        }

        return status;
    }
}
