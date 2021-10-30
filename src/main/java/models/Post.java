package models;

public class Post {

    private String id;
    private String userId;
    private Status status;
    private Boolean hasForm;

    private Post(String id, String userId, Status status, Boolean hasForm) {

        this.id = id;
        this.userId = userId;
        this.status = status;
        this.hasForm = hasForm;
    }

    public static class PostBuilder {

        private String id;
        private String userId;
        private Status status;
        private Boolean hasForm;

        public PostBuilder(String id, String userId) {

            this.id = id;
            this.userId = userId;
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

            return new Post(this.id, this.userId, this.status, this.hasForm);
        }
    }
}
