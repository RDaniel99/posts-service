package database;

import models.Post;
import models.PostDetails;

public class PostsDatabase implements Database, Repository<PostDetails, Post> {

    // TODO: Schimbat denumirile in interfata Repository

    @Override
    public PostDetails createT(PostDetails object) {
        return null;
    }

    @Override
    public PostDetails readT(String id) {
        return null;
    }

    @Override
    public PostDetails updateT(PostDetails object) {
        return null;
    }

    @Override
    public boolean deleteT(String id) {
        return false;
    }

    @Override
    public Post createK(Post object) {
        return null;
    }

    @Override
    public Post readK(String id) {
        return null;
    }

    @Override
    public Post updateK(Post object) {
        return null;
    }

    @Override
    public boolean deleteK(String id) {
        return false;
    }
}
