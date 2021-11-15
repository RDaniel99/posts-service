package services.posts;

import database.PostsRepository;
import services.Service;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePostService implements Service {

    private PostsRepository repository;

    public DeletePostService() {

        this.repository = new PostsRepository();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Integer postId = Integer.parseInt(req.getParameter("id"));
        repository.delete(postId);
    }
}
