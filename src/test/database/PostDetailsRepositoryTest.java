package database;

import models.Post;
import models.PostDetails;
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

class PostDetailsRepositoryTest {

    @Mock
    Connection connection;
    @Mock
    Statement stmt;
    @Mock
    ResultSet rs;

    @Spy
    @InjectMocks
    PostDetailsRepository repository = new PostDetailsRepository();

    public void setup() throws SQLException {

        MockitoAnnotations.initMocks(this);

        repository.setConnection(connection);

        when(connection.createStatement()).thenReturn(stmt);
        when(stmt.getGeneratedKeys()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getInt(eq(1))).thenReturn(5);
    }

    @Test
    public void testIfRepoCreatesPostDetails() throws SQLException {

        // setup
        setup();
        PostDetails postDetails = new PostDetails.PostDetailsBuilder(null, 20)
                .build();

        // execute
        postDetails = repository.create(postDetails);

        // verify
        assertEquals(5, postDetails.getId());

        verify(stmt).executeUpdate(
                eq("INSERT INTO postsdetails(post_id, title, category, description) VALUES(20, \"null\", \"null\", \"null\")"),
                eq(RETURN_GENERATED_KEYS)
        );
    }

}