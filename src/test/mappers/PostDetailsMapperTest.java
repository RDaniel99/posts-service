package mappers;

import models.PostDetails;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostDetailsMapperTest {

    private final PostDetails postDetails = new PostDetails.PostDetailsBuilder(1, 1).withDescription("Hello").build();

    private PostDetailsMapper postDetailsMapper;

    private void setup(){

        postDetailsMapper = new PostDetailsMapper();
    }

    @Test
    void convertFromJsonToObject() {

        setup();
        //setup
        String json = createFormJson();

        //execute
        PostDetails postDetailsResulted = postDetailsMapper.fromJsonToObject(new BufferedReader(new StringReader(json)));

        //verify
        assertEquals(postDetails.getId(), postDetailsResulted.getId());
    }


    private String createFormJson() {

        return "{ \"id\": 1, \"postId\": 1, \"description\": \"Hello\" }";
    }

}