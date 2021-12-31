package services.formAnswer;

import database.FormAnswerRepository;
import mappers.FormAnswerMapper;
import models.FormAnswer;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReadFormAnswerServiceTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    FormAnswerRepository formAnswerRepository;

    @Mock
    FormAnswerMapper formAnswerMapper;

    @Mock
    PrintWriter printWriter;

    @Spy
    @InjectMocks
    ReadFormAnswerService service = new ReadFormAnswerService();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);

        when(httpServletRequest.getPathInfo()).thenReturn("/15");

        when(formAnswerRepository.read(anyInt())).thenReturn(new FormAnswer.Builder().build());

        when(httpServletResponse.getWriter()).thenReturn(printWriter);
    }

    @Test
    public void execute() throws Exception {

        setup();
        //execute
        service.execute(httpServletRequest, httpServletResponse);

        //verify
        verify(formAnswerRepository).read(any());
    }

}