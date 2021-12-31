package servlets.posts;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.posts.UpdatePostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class UpdatePostServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    UpdatePostService updatePostService;

    @InjectMocks
    UpdatePostServlet updatePostServlet = new UpdatePostServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException, ServletException {

        setup();
        //execute
        updatePostServlet.doPut(httpServletRequest, httpServletResponse);

        //verify
        verify(updatePostService).execute(any(), any());
    }

}