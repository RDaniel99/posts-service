package servlets.formQuestions;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.formQuestions.ReadFormQuestionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ReadFormQuestionsServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    ReadFormQuestionService readFormQuestionService;

    @InjectMocks
    ReadFormQuestionsServlet readFormQuestionsServlet = new ReadFormQuestionsServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException {

        setup();
        //execute
        readFormQuestionsServlet.doGet(httpServletRequest, httpServletResponse);

        //verify
        verify(readFormQuestionService).execute(any(), any());
    }

}