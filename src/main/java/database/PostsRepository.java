package database;

import models.Post;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostsRepository implements Database, Repository<Post> {

    private Connection connection;
    private final String queryInsertPost = "INSERT INTO posts(user_id, status, has_form) VALUES(%d, \"%s\", %b)";

    public PostsRepository() {

        this.connection = Database.getConnection();
    }

    public void setConnection(Connection connection) {

        this.connection = connection;
    }

    @Override
    public Post create(Post post) {

        try {
            Statement stmt = connection.createStatement();

            stmt.executeUpdate(String.format(queryInsertPost, post.getUserId(), post.getStatus(), post.getHasForm()),
                    Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                post.setId(rs.getInt(1));
            }

            stmt.close();
        } catch(Exception ignored) {}

        return post;
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
