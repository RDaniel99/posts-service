package dtos;

import models.Post;
import models.Status;

public class PostDTO {

    private Integer id;
    private Integer userId;
    private Status status;
    private Boolean hasForm;
    private PostDetailsDTO details;

    public PostDTO(Integer id, Integer userId, Status status, Boolean hasForm, PostDetailsDTO details) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.hasForm = hasForm;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getHasForm() {
        return hasForm;
    }

    public void setHasForm(Boolean hasForm) {
        this.hasForm = hasForm;
    }

    public PostDetailsDTO getDetails() {
        return details;
    }

    public void setDetails(PostDetailsDTO details) {
        this.details = details;
    }


    public static class PostDTOBuilder {

        private Integer id;
        private Integer userId;
        private Status status;
        private Boolean hasForm;
        private PostDetailsDTO details;

        public PostDTOBuilder(Integer id, Integer userId) {

            this.id = id;
            this.userId = userId;
        }

        public PostDTOBuilder withStatus(Status status) {

            this.status = status;
            return this;
        }

        public PostDTOBuilder hasForm(Boolean hasForm) {

            this.hasForm = hasForm;
            return this;
        }

        public PostDTOBuilder withDetails(PostDetailsDTO details) {

            this.details = details;
            return this;
        }

        public PostDTO build() {

            return new PostDTO(this.id, this.userId, this.status, this.hasForm, this.details);
        }
    }
}
