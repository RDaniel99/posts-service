package services.formAnswer;

import database.FormAnswerRepository;
import mappers.FormAnswerMapper;
import models.FormAnswer;
import org.junit.Ignore;
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

@Ignore
class UpdateFormAnswerServiceTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    FormAnswerRepository formAnswerRepository;

    @Mock
    PrintWriter printWriter;

    @Mock
    FormAnswerMapper formAnswerMapper;

    @Spy
    @InjectMocks
    UpdateFormAnswerService service = new UpdateFormAnswerService();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);

        when(httpServletRequest.getPathInfo()).thenReturn("/15");

        when(formAnswerRepository.update(any(), any())).thenReturn(new FormAnswer.Builder().build());

        when(httpServletResponse.getWriter()).thenReturn(printWriter);
    }

    @Test
    public void execute() throws Exception {

        setup();
        //execute
        service.execute(httpServletRequest, httpServletResponse);

        //verify
        verify(formAnswerRepository).update(any(), any());
    }


}