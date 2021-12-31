package services.posts.details;

import database.PostDetailsRepository;
import mappers.PostDetailsMapper;
import models.PostDetails;
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

class GetPostDetailsServiceTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    PostDetailsRepository postDetailsRepository;

    @Mock
    PrintWriter printWriter;

    @Mock
    PostDetailsMapper postDetailsMapper;

    @Spy
    @InjectMocks
    GetPostDetailsService service = new GetPostDetailsService();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);

        when(httpServletRequest.getParameter(any())).thenReturn("15");

        when(postDetailsRepository.read(anyInt())).thenReturn(new PostDetails.PostDetailsBuilder(1,1).build());

        when(httpServletResponse.getWriter()).thenReturn(printWriter);
    }

    @Test
    public void execute() throws Exception {

        setup();
        //execute
        service.execute(httpServletRequest, httpServletResponse);

        //verify
        verify(postDetailsRepository).read(any());
    }

}