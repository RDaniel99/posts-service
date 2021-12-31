package servlets.forms;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.forms.CreateFormService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class CreateFormServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    CreateFormService createFormService;

    @InjectMocks
    CreateFormServlet createFormServlet = new CreateFormServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException {

        setup();
        //execute
        createFormServlet.doPost(httpServletRequest, httpServletResponse);

        //verify
        verify(createFormService).execute(any(), any());
    }

}