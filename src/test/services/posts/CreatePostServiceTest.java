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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreatePostServiceTest {

    @Mock
    HttpServletResponse httpServletResponse;

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    PostsRepository postsRepository;

    @Mock
    PostMapper postMapper;

    @Mock
    PrintWriter printWriter;

    @Spy
    @InjectMocks
    CreatePostService service = new CreatePostService();

    public void setup() throws SQLException, IOException {

        MockitoAnnotations.initMocks(this);

        when(httpServletResponse.getWriter()).thenReturn(printWriter);

        when(postMapper.fromJsonToObject(any())).thenReturn(new Post.PostBuilder(1,1).build());

        when(postsRepository.create(new Post.PostBuilder(1,1).build())).thenReturn(new Post.PostBuilder(1,1).build());
    }

    @Test
    public void execute() throws Exception {

        setup();
        //execute
        service.execute(httpServletRequest, httpServletResponse);

        //verify
        verify(postsRepository).create(any());
    }

}