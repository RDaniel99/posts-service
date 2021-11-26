package mappers;

import com.google.gson.Gson;
import dtos.PostDTO;
import models.Post;

import java.io.BufferedReader;
import java.util.List;

public class PostMapper {

    public static Post fromJsonToObject(BufferedReader reader) {

        return new Gson().fromJson(reader, Post.class);
    }

    public static String fromObjectToJson(Post post) {

        return new Gson().toJson(post);
    }

    public static String fromListOfObjectsToJson(List posts) {

        return new Gson().toJson(posts);
    }

    public static String fromDtoToJson(PostDTO dto) {

        return new Gson().toJson(dto);
    }

    public static Post fromDtoToObject(PostDTO dto) {

        return new Post.PostBuilder(dto.getId(), dto.getUserId())
                .withStatus(dto.getStatus())
                .hasForm(dto.getHasForm())
                .build();
    }

    public static PostDTO fromObjectToDto(Post post) {

        return new PostDTO.PostDTOBuilder(post.getId(), post.getUserId())
                .withStatus(post.getStatus())
                .hasForm(post.getHasForm())
                .build();
    }
}
