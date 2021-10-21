package database;

import models.Post;

public class PostsRepository implements Database, Repository<Post> {

    @Override
    public Post create(Post object) {
        return null;
    }

    @Override
    public Post read(String id) {
        return null;
    }

    @Override
    public Post update(Post object) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
