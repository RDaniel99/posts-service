package models;

public class Post {

    private String id;
    private String userId;
    private String detailsId;
    private Status status;
    private Boolean hasForm;

    private Post(String id, String userId, String detailsId, Status status, Boolean hasForm) {

        this.id = id;
        this.userId = userId;
        this.detailsId = detailsId;
        this.status = status;
        this.hasForm = hasForm;
    }

    public static class PostBuilder {

        private String id;
        private String userId;
        private String detailsId;
        private Status status;
        private Boolean hasForm;

        public PostBuilder(String id, String userId, String detailsId) {

            this.id = id;
            this.userId = userId;
            this.detailsId = detailsId;
        }

        public PostBuilder withStatus(Status status) {

            this.status = status;
            return this;
        }

        public PostBuilder hasForm(Boolean hasForm) {

            this.hasForm = hasForm;
            return this;
        }

        public Post build() {

            return new Post(this.id, this.userId, this.detailsId, this.status, this.hasForm);
        }
    }
}
