package servlets.posts.details;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.posts.details.UpdatePostDetailsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class UpdatePostDetailsServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    UpdatePostDetailsService updatePostDetailsService;

    @InjectMocks
    UpdatePostDetailsServlet updateFormAnswerServlet = new UpdatePostDetailsServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException, ServletException {

        setup();
        //execute
        updateFormAnswerServlet.doPut(httpServletRequest, httpServletResponse);

        //verify
        verify(updatePostDetailsService).execute(any(), any());
    }

}