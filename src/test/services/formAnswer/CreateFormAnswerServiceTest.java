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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateFormAnswerServiceTest {

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
    CreateFormAnswerService service = new CreateFormAnswerService();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);

        when(httpServletResponse.getWriter()).thenReturn(printWriter);

        when(formAnswerMapper.fromJsonToObject(any())).thenReturn(new FormAnswer.Builder().build());

        when(formAnswerRepository.create(new FormAnswer.Builder().build())).thenReturn(new FormAnswer.Builder().build());
    }

    @Test
    public void execute() throws Exception {

        setup();
        //execute
        service.execute(httpServletRequest, httpServletResponse);

        //verify
        verify(formAnswerRepository).create(any());
    }
}