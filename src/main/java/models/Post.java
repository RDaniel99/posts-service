package models;

import java.util.Objects;

public class Post {

    private Integer id;
    private Integer userId;
    private Status status;
    private Boolean hasForm;

    private Post(Integer id, Integer userId, Status status, Boolean hasForm) {

        this.id = id;
        this.userId = userId;
        this.status = status;
        this.hasForm = hasForm;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Status getStatus() {
        return status;
    }

    public Boolean getHasForm() {
        return hasForm;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setHasForm(Boolean hasForm) {
        this.hasForm = hasForm;
    }

    public static class PostBuilder {

        private Integer id;
        private Integer userId;
        private Status status;
        private Boolean hasForm;

        public PostBuilder(Integer id, Integer userId) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(userId, post.userId) && status == post.status && Objects.equals(hasForm, post.hasForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, status, hasForm);
    }
}
