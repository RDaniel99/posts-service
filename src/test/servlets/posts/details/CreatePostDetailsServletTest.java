package servlets.posts.details;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.posts.details.CreatePostDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class CreatePostDetailsServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    CreatePostDetailsService createPostDetailsService;

    @InjectMocks
    CreatePostDetailsServlet createPostDetailsServlet = new CreatePostDetailsServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException {

        setup();
        //execute
        createPostDetailsServlet.doPost(httpServletRequest, httpServletResponse);

        //verify
        verify(createPostDetailsService).execute(any(), any());
    }

}