package mappers;

import com.google.gson.Gson;
import models.Post;

import java.io.BufferedReader;

public class PostMapper {

    public static Post fromJsonToObject(BufferedReader reader) {

        return new Gson().fromJson(reader, Post.class);
    }

    public static String fromObjectToJson(Post post) {

        return new Gson().toJson(post);
    }
}
