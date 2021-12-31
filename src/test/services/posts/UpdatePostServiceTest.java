package services.posts;

import database.PostsRepository;
import exceptions.CrudException;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UpdatePostServiceTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    PostsRepository postsRepository;

    @Mock
    PrintWriter printWriter;

    @Mock
    PostMapper postMapper;

    @Spy
    @InjectMocks
    UpdatePostService service = new UpdatePostService();

    public void setup() throws SQLException, IOException, CrudException {

        MockitoAnnotations.initMocks(this);

        when(httpServletRequest.getParameter("id")).thenReturn("15");

        when(postsRepository.update(any(), any())).thenReturn(new Post.PostBuilder(1,1).build());

        when(httpServletResponse.getWriter()).thenReturn(printWriter);
    }

    @Test
    public void execute() throws Exception {

        setup();
        //execute
        service.execute(httpServletRequest, httpServletResponse);

        //verify
        verify(postsRepository).update(any(), any());
    }


}