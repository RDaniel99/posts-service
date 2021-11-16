package models;


import java.util.Date;
import java.util.List;

public class PostDetails {

    private Integer id;
    private Integer postId;
    private String title;
    private String description;
    private List<String> imagesPaths;
    private ObjectCategory category;
    private Date createdDate;

    private PostDetails(Integer id, Integer postId, String title, String description,
                        List<String> imagesPaths, ObjectCategory category, Date createdDate) {

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

    public Integer getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImagesPaths() {
        return imagesPaths;
    }

    public ObjectCategory getCategory() {
        return category;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static class PostDetailsBuilder {

        private Integer id;
        private Integer postId;
        private String title;
        private String description;
        private List<String> imagesPaths;
        private ObjectCategory category;
        private Date createdDate;

        public PostDetailsBuilder(Integer id, Integer postId) {

            this.id = id;
            this.postId = postId;
            this.createdDate = new Date();
        }

        public PostDetailsBuilder withTitle(String title) {

            this.title = title;
            return this;
        }

        public PostDetailsBuilder withDescription(String description) {

            this.description = description;
            return this;
        }

        public PostDetailsBuilder withImages(List<String> imagesPaths) {

            this.imagesPaths = imagesPaths;
            return this;
        }

        public PostDetailsBuilder withCategory(ObjectCategory category) {

            this.category = category;
            return this;
        }

        public PostDetails build() {

            return new PostDetails(this.id, this.postId, this.title, this.description, this.imagesPaths,
                    this.category, this.createdDate);
        }
    }
}
