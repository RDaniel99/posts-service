package mappers;

import com.google.gson.Gson;
import models.PostDetails;

import java.io.BufferedReader;

public class PostDetailsMapper {

    public  PostDetails fromJsonToObject(BufferedReader reader) {

        return new Gson().fromJson(reader, PostDetails.class);
    }

    public  String fromObjectToJson(PostDetails details) {

        return new Gson().toJson(details);
    }
}
