package database;

import models.ObjectCategory;
import models.Post;
import models.PostDetails;
import models.Status;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class PostDetailsRepository implements Database, Repository<PostDetails> {

    private Connection connection;
    private final String queryInsertPostDetails = "INSERT INTO postsdetails(post_id, title, category, description) " +
            "VALUES(%d, \"%s\", \"%s\", \"%s\")";
    private final String querySelectPostDetailsById = "SELECT * FROM postsdetails WHERE id = %d";

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

        PostDetails details = null;

        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(String.format(querySelectPostDetailsById, id));

            if(rs.next()) {

                details = convertToPostDetails(rs);
            }

            stmt.close();
        } catch(Exception ignored) {

            return null;
        }

        return details;
    }

    private PostDetails convertToPostDetails(ResultSet rs) throws SQLException {

        Integer id = rs.getInt("id");
        Integer postId = rs.getInt("post_id");
        String title = rs.getString("title");
        String description = rs.getString("description");
        ObjectCategory category = ObjectCategory.valueOf(rs.getString("category"));

        return new PostDetails.PostDetailsBuilder(id, postId)
                .withCategory(category)
                .withDescription(description)
                .withTitle(title)
                .build();
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
