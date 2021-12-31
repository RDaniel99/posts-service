package servlets.formAnswer;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.formAnswer.ReadFormAnswerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ReadFormAnswerServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    ReadFormAnswerService readFormAnswerService;

    @InjectMocks
    ReadFormAnswerServlet readFormAnswerServlet = new ReadFormAnswerServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException {

        setup();
        //execute
        readFormAnswerServlet.doGet(httpServletRequest, httpServletResponse);

        //verify
        verify(readFormAnswerService).execute(any(), any());
    }

}