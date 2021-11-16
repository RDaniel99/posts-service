package database;

import javafx.geometry.Pos;
import models.PostDetails;

public class PostDetailsRepository implements Database, Repository<PostDetails> {

    @Override
    public PostDetails create(PostDetails object) {
        return null;
    }

    @Override
    public PostDetails read(Integer id) {
        return null;
    }

    @Override
    public PostDetails update(PostDetails originalDetails, PostDetails newObject) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
