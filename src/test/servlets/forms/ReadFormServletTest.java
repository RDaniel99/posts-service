package servlets.forms;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.forms.ReadFormService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ReadFormServletTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    ReadFormService readFormService;

    @InjectMocks
    ReadFormServlet formQuestionsServlet = new ReadFormServlet();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doDelete() throws SQLException, IOException {

        setup();
        //execute
        formQuestionsServlet.doGet(httpServletRequest, httpServletResponse);

        //verify
        verify(readFormService).execute(any(), any());
    }

}