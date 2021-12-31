package servlets.formQuestions;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.formQuestions.UpdateFormQuestionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class UpdateFormQuestionsServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    UpdateFormQuestionService updateFormQuestionService;

    @InjectMocks
    UpdateFormQuestionsServlet updateFormQuestionsServlet = new UpdateFormQuestionsServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException {

        setup();
        //execute
        updateFormQuestionsServlet.doPut(httpServletRequest, httpServletResponse);

        //verify
        verify(updateFormQuestionService).execute(any(), any());
    }

}