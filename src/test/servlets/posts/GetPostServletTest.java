package servlets.posts;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.posts.GetPostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class GetPostServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    GetPostService getPostService;

    @InjectMocks
    GetPostServlet formQuestionsServlet = new GetPostServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException, ServletException {

        setup();
        //execute
        formQuestionsServlet.doGet(httpServletRequest, httpServletResponse);

        //verify
        verify(getPostService).execute(any(), any());
    }

}