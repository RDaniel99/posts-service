package dtos;

import models.ObjectCategory;
import models.PostDetails;

import java.util.Date;
import java.util.List;

public class PostDetailsDTO {

    private Integer id;
    private Integer postId;
    private String title;
    private String description;
    private List<String> imagesPaths;
    private ObjectCategory category;
    private Date createdDate;

    public PostDetailsDTO(Integer id, Integer postId, String title, String description, List<String> imagesPaths,
                          ObjectCategory category, Date createdDate) {
        this.id = id;
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.imagesPaths = imagesPaths;
        this.category = category;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImagesPaths() {
        return imagesPaths;
    }

    public void setImagesPaths(List<String> imagesPaths) {
        this.imagesPaths = imagesPaths;
    }

    public ObjectCategory getCategory() {
        return category;
    }

    public void setCategory(ObjectCategory category) {
        this.category = category;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public static class PostDetailsDTOBuilder {

        private Integer id;
        private Integer postId;
        private String title;
        private String description;
        private List<String> imagesPaths;
        private ObjectCategory category;
        private Date createdDate;

        public PostDetailsDTOBuilder(Integer id, Integer postId) {

            this.id = id;
            this.postId = postId;
            this.createdDate = new Date();
        }

        public PostDetailsDTOBuilder withTitle(String title) {

            this.title = title;
            return this;
        }

        public PostDetailsDTOBuilder withDescription(String description) {

            this.description = description;
            return this;
        }

        public PostDetailsDTOBuilder withImages(List<String> imagesPaths) {

            this.imagesPaths = imagesPaths;
            return this;
        }

        public PostDetailsDTOBuilder withCategory(ObjectCategory category) {

            this.category = category;
            return this;
        }

        public PostDetailsDTO build() {

            return new PostDetailsDTO(this.id, this.postId, this.title, this.description, this.imagesPaths,
                    this.category, this.createdDate);
        }
    }
}
