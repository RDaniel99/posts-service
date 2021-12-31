package database;

import models.Post;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static models.Status.PENDING_FOUND;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PostsRepositoryTest {

    @Mock
    Connection connection;
    @Mock
    Statement stmt;
    @Mock
    ResultSet rs;

    @Spy
    @InjectMocks
    PostsRepository repository = new PostsRepository();

    public void setup() throws SQLException {

        MockitoAnnotations.initMocks(this);

        repository.setConnection(connection);

        when(connection.createStatement()).thenReturn(stmt);
        when(stmt.getGeneratedKeys()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getInt(eq(1))).thenReturn(5);
    }

    @Test
    public void testIfRepoCreatesPost() throws SQLException {

        // setup
        setup();
        Post post = new Post.PostBuilder(null, 20)
                .withStatus(PENDING_FOUND)
                .hasForm(true)
                .build();

        // execute
        post = repository.create(post);

        // verify
        assertEquals(5, post.getId());

        verify(stmt).executeUpdate(
                eq("INSERT INTO posts(user_id, status, has_form) VALUES(20, \"PENDING_FOUND\", true)"),
                eq(RETURN_GENERATED_KEYS)
        );
    }

}