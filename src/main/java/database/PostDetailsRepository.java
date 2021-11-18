package database;

import exceptions.CrudException;
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

import static exceptions.CrudException.Reason.ID_CANNOT_BE_CHANGED;
import static exceptions.CrudException.Reason.USER_ID_CANNOT_BE_CHANGED;

public class PostDetailsRepository implements Database, Repository<PostDetails> {

    private Connection connection;
    private final String queryInsertPostDetails = "INSERT INTO postsdetails(post_id, title, category, description) " +
            "VALUES(%d, \"%s\", \"%s\", \"%s\")";
    private final String querySelectPostDetailsById = "SELECT * FROM postsdetails WHERE id = %d";
    private final String queryUpdatePostDetailsById = "UPDATE postsdetails SET %s WHERE id=%d";

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
    public PostDetails update(PostDetails originalDetails, PostDetails newPostDetails) {
        try {

            String setStmt = generateSetString(originalDetails, newPostDetails);

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(String.format(queryUpdatePostDetailsById, setStmt, originalDetails.getId()));

        } catch (CrudException | SQLException ignored) {
            // TODO: Create TranslatorHandler for exceptions
            return originalDetails;
        }

        return newPostDetails;
    }

    private String generateSetString(PostDetails originalDetails, PostDetails newPostDetails) throws CrudException {

        StringBuilder builder = new StringBuilder();
        boolean appendComma = false;

        if(newPostDetails.getId() != null && !originalDetails.getId().equals(newPostDetails.getId())) {

            // TODO: Put constants for messages
            throw new CrudException(ID_CANNOT_BE_CHANGED);
        }

        if(newPostDetails.getPostId() != null && !originalDetails.getPostId().equals(newPostDetails.getPostId())) {

            // TODO: Put constants for messages
            throw new CrudException(USER_ID_CANNOT_BE_CHANGED);
        }

        if(newPostDetails.getTitle() != null && !originalDetails.getTitle().equals(newPostDetails.getTitle())) {

            appendComma = true;
            builder.append("title = ");
            // TODO: Add Constant
            builder.append("\"" + newPostDetails.getTitle() + "\"");
        }

        if(newPostDetails.getDescription() != null && !originalDetails.getDescription().equals(newPostDetails.getDescription())) {

            if(appendComma) {

                builder.append(", ");
            }

            appendComma = true;
            builder.append("description = ");
            builder.append("\"" + newPostDetails.getDescription() + "\"");
        }

        if(newPostDetails.getCategory() != null && !originalDetails.getCategory().equals(newPostDetails.getCategory())) {

            if(appendComma) {

                builder.append(", ");
            }

            appendComma = true;
            builder.append("category = ");
            builder.append("\"" + newPostDetails.getCategory() + "\"");
        }

        return builder.toString();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
