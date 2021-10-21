package models;


import java.util.Date;
import java.util.List;

public class PostDetails {

    private String id;
    private String postId;
    private String title;
    private String description;
    private List<String> imagesPaths;
    private List<ObjectCategory> categories;
    private Date createdDate;

    private PostDetails(String id, String postId, String title, String description,
                       List<String> imagesPaths, List<ObjectCategory> categories, Date createdDate) {

        this.id = id;
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.imagesPaths = imagesPaths;
        this.categories = categories;
        this.createdDate = createdDate;
    }

    public class PostDetailsBuilder {

        private String id;
        private String postId;
        private String title;
        private String description;
        private List<String> imagesPaths;
        private List<ObjectCategory> categories;
        private Date createdDate;

        public PostDetailsBuilder(String id, String postId) {

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

        public PostDetailsBuilder withCategories(List<ObjectCategory> categories) {

            this.categories = categories;
            return this;
        }

        public PostDetails build() {

            return new PostDetails(this.id, this.postId, this.title, this.description, this.imagesPaths,
                    this.categories, this.createdDate);
        }
    }
}
