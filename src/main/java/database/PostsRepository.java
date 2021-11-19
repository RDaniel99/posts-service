package database;

import exceptions.CrudException;
import models.Post;
import models.Status;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static exceptions.CrudException.Reason.ID_CANNOT_BE_CHANGED;
import static exceptions.CrudException.Reason.USER_ID_CANNOT_BE_CHANGED;

// TODO: Implement Singleton pattern
public class PostsRepository implements Database, Repository<Post> {

    private Connection connection;
    private final String queryInsertPost = "INSERT INTO posts(user_id, status, has_form) VALUES(%d, \"%s\", %b)";
    private final String queryDeletePost = "DELETE FROM posts WHERE id=%d";
    private final String querySelectPostById = "SELECT * FROM posts WHERE id=%d";
    private final String queryUpdatePostById = "UPDATE posts SET %s WHERE id=%d";

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
    public Post read(Integer id) {

        Post post = null;

        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(String.format(querySelectPostById, id));

            if(rs.next()) {

                post = convertToPost(rs);
            }

            stmt.close();
        } catch(Exception ignored) {

            return null;
        }

        return post;
    }

    private Post convertToPost(ResultSet rs) throws SQLException {

        Integer id = rs.getInt("id");
        Integer userId = rs.getInt("user_id");
        Boolean hasForm = rs.getBoolean("has_form");
        Status status = Status.valueOf(rs.getString("status"));

        return new Post.PostBuilder(id, userId).hasForm(hasForm).withStatus(status).build();
    }

    @Override
    public Post update(Post originalPost, Post newPost) throws CrudException {

        String setStmt = generateSetString(originalPost, newPost);

        try {

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(String.format(queryUpdatePostById, setStmt, originalPost.getId()));

        } catch (SQLException ignored) {
            // TODO: Create TranslatorHandler for exceptions
            return originalPost;
        }

        return newPost;
    }

    private String generateSetString(Post originalPost, Post newPost) throws CrudException {

        StringBuilder builder = new StringBuilder();
        boolean appendComma = false;

        if(newPost.getId() != null && !originalPost.getId().equals(newPost.getId())) {

            throw new CrudException(ID_CANNOT_BE_CHANGED);
        }

        if(newPost.getUserId() != null && !originalPost.getUserId().equals(newPost.getUserId())) {

            throw new CrudException(USER_ID_CANNOT_BE_CHANGED);
        }

        if(newPost.getStatus() != null && !originalPost.getStatus().equals(newPost.getStatus())) {

            appendComma = true;
            builder.append("status = ");
            // TODO: Add Constant
            builder.append("\"" + newPost.getStatus() + "\"");
        }

        if(newPost.getHasForm() != null && !originalPost.getHasForm().equals(newPost.getHasForm())) {

            if(appendComma) {

                builder.append(", ");
            }

            // TODO: Should we delete the Form if it changes from 1 to 0?
            // TODO: Or keep it for future changes?
            // TODO: To see, not mandatory right now
            appendComma = true;
            builder.append("has_form = ");
            builder.append(newPost.getHasForm());
        }

        return builder.toString();
    }

    @Override
    public boolean delete(Integer id) {
        try {
            Statement stmt = connection.createStatement();

            stmt.executeUpdate(String.format(queryDeletePost, id));

            stmt.close();
        } catch(Exception ignored) {

            return false;
        }

        return true;
    }
}
