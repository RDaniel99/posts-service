package database;

import models.PostDetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostDetailsRepository implements Database, Repository<PostDetails> {

    private Connection connection;
    private final String queryInsertPostDetails = "INSERT INTO postsdetails(post_id, title, category, description) " +
            "VALUES(%d, \"%s\", \"%s\", \"%s\")";

    public PostDetailsRepository() {
        connection = Database.getConnection();
    }

    @Override
    public PostDetails create(PostDetails details) {
        try {
            Statement stmt = connection.createStatement();

            stmt.executeUpdate(String.format(queryInsertPostDetails, details.getPostId(), details.getTitle(),
                    details.getCategory(), details.getDescription()), Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                details.setId(rs.getInt(1));
            }

            stmt.close();
        } catch(Exception ignored) {}

        return details;
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
