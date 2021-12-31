package mappers;

import models.Post;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostMapperTest {

    private final Post post = new Post.PostBuilder(1, 1).build();

    private  PostMapper postMapper;

    private void setup(){

        postMapper = new PostMapper();
    }

    @Test
    void convertFromJsonToObject() {

        setup();
        //setup
        String json = createFormJson();

        //execute
        Post postResulted = postMapper.fromJsonToObject(new BufferedReader(new StringReader(json)));

        //verify
        assertEquals(post, postResulted);
    }


    private String createFormJson() {

        return "{ \"id\": 1, \"userId\": 1 }";
    }

}