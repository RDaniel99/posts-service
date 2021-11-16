package mappers;

import com.google.gson.Gson;
import models.Post;
import models.PostDetails;

import java.io.BufferedReader;

public class PostDetailsMapper {

    public static PostDetails fromJsonToObject(BufferedReader reader) {

        return new Gson().fromJson(reader, PostDetails.class);
    }

    public static String fromObjectToJson(PostDetails details) {

        return new Gson().toJson(details);
    }
}
