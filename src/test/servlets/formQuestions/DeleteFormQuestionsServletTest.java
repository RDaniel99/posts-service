package servlets.formQuestions;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.formQuestions.DeleteFormQuestionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class DeleteFormQuestionsServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    DeleteFormQuestionService deleteFormQuestionService;

    @InjectMocks
    DeleteFormQuestionsServlet deleteFormQuestionsServlet = new DeleteFormQuestionsServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException {

        setup();
        //execute
        deleteFormQuestionsServlet.doDelete(httpServletRequest, httpServletResponse);

        //verify
        verify(deleteFormQuestionService).execute(any(), any());
    }
}