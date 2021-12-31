package services.forms;

import database.FormRepository;
import mappers.FormMapper;
import models.Form;
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

class CreateFormServiceTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    FormRepository formRepository;

    @Mock
    FormMapper formMapper;

    @Mock
    PrintWriter printWriter;

    @Spy
    @InjectMocks
    CreateFormService service = new CreateFormService();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);

        when(httpServletResponse.getWriter()).thenReturn(printWriter);

        when(formMapper.fromJsonToObject(any())).thenReturn(new Form());

        when(formRepository.create(new Form())).thenReturn(new Form());
    }

    @Test
    public void execute() throws Exception {

        setup();
        //execute
        service.execute(httpServletRequest, httpServletResponse);

        //verify
        verify(formRepository).create(any());
    }


}