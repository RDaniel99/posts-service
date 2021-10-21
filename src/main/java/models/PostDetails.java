package models;


import java.util.Date;
import java.util.List;

// TODO: See if we have to use annotations
public class PostDetails {

    private String id;

    private String postId;

    private String title;

    private String description;

    private List<String> imagesPaths;

    private List<ObjectCategory> categories;

    private Date createdDate;

    // TODO: Create builder
}
