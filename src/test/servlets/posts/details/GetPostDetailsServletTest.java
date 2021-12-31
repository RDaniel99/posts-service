package servlets.posts.details;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.posts.details.GetPostDetailsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class GetPostDetailsServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    GetPostDetailsService getPostDetailsService;

    @InjectMocks
    GetPostDetailsServlet getPostDetailsServlet = new GetPostDetailsServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException, ServletException {

        setup();
        //execute
        getPostDetailsServlet.doGet(httpServletRequest, httpServletResponse);

        //verify
        verify(getPostDetailsService).execute(any(), any());
    }

}