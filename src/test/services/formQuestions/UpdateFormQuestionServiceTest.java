package services.formQuestions;

import database.FormsQuestionsRepository;
import mappers.FormQuestionMapper;
import models.FormQuestion;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UpdateFormQuestionServiceTest {


    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    FormsQuestionsRepository formsQuestionsRepository;

    @Mock
    PrintWriter printWriter;

    @Mock
    FormQuestionMapper formQuestionMapper;

    @Spy
    @InjectMocks
    UpdateFormQuestionService service = new UpdateFormQuestionService();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);

        when(httpServletRequest.getPathInfo()).thenReturn("/15");

        when(formsQuestionsRepository.update(any(), any())).thenReturn(new FormQuestion.Builder().build());

        when(httpServletResponse.getWriter()).thenReturn(printWriter);
    }

    @Test
    public void execute() throws Exception {

        setup();
        //execute
        service.execute(httpServletRequest, httpServletResponse);

        //verify
        verify(formsQuestionsRepository).update(any(), any());
    }

}