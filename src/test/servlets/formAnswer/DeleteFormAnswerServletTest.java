package servlets.formAnswer;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.formAnswer.DeleteFormAnswerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class DeleteFormAnswerServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    DeleteFormAnswerService deleteFormAnswerService;

    @InjectMocks
    DeleteFormAnswerServlet deleteFormAnswerServlet = new DeleteFormAnswerServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException {

        setup();
        //execute
        deleteFormAnswerServlet.doDelete(httpServletRequest, httpServletResponse);

        //verify
        verify(deleteFormAnswerService).execute(any(), any());
    }
}