package mappers;

import com.google.gson.Gson;
import dtos.PostDetailsDTO;
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

    public static PostDetailsDTO fromObjectToDto(PostDetails details) {

        return new PostDetailsDTO.PostDetailsDTOBuilder(details.getId(), details.getPostId())
                .withCategory(details.getCategory())
                .withDescription(details.getDescription())
                .withImages(details.getImagesPaths())
                .withTitle(details.getTitle())
                .build();
    }

    public static PostDetails fromDtoToObject(PostDetailsDTO dto) {

        return new PostDetails.PostDetailsBuilder(dto.getId(), dto.getPostId())
                .withTitle(dto.getTitle())
                .withDescription(dto.getDescription())
                .withCategory(dto.getCategory())
                .withImages(dto.getImagesPaths())
                .build();
    }
}
