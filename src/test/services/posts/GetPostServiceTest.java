package services.posts;

import database.PostsRepository;
import mappers.PostMapper;
import models.Post;
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

class GetPostServiceTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    PostsRepository postRepository;

    @Mock
    PrintWriter printWriter;

    @Mock
    PostMapper postMapper;

    @Spy
    @InjectMocks
    GetPostService service = new GetPostService();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);

        when(httpServletRequest.getParameter(any())).thenReturn("15");

        when(postRepository.read(anyInt())).thenReturn(new Post.PostBuilder(1, 1).build());

        when(httpServletResponse.getWriter()).thenReturn(printWriter);
    }

    @Test
    public void execute() throws Exception {

        setup();
        //execute
        service.execute(httpServletRequest, httpServletResponse);

        //verify
        verify(postRepository).read(any());
    }

}