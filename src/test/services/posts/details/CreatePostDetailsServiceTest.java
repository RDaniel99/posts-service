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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreatePostDetailsServiceTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    PostDetailsRepository postDetailsRepository;

    @Mock
    PostDetailsMapper postDetailsMapper;

    @Mock
    PrintWriter printWriter;

    @Spy
    @InjectMocks
    CreatePostDetailsService service = new CreatePostDetailsService();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);

        when(httpServletResponse.getWriter()).thenReturn(printWriter);

        when(postDetailsMapper.fromJsonToObject(any())).thenReturn(new PostDetails.PostDetailsBuilder(1,1).build());

        when(postDetailsRepository.create(new PostDetails.PostDetailsBuilder(1,1).build())).thenReturn(new PostDetails.PostDetailsBuilder(1,1).build());
    }

    @Test
    public void execute() throws Exception {

        setup();
        //execute
        service.execute(httpServletRequest, httpServletResponse);

        //verify
        verify(postDetailsRepository).create(any());
    }

}