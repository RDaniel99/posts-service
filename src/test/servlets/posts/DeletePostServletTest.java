package servlets.posts;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.posts.DeletePostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class DeletePostServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    DeletePostService deletePostService;

    @InjectMocks
    DeletePostServlet deletePostServlet = new DeletePostServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException, ServletException {

        setup();
        //execute
        deletePostServlet.doDelete(httpServletRequest, httpServletResponse);

        //verify
        verify(deletePostService).execute(any(), any());
    }

}