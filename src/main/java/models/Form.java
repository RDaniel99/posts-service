package models;

import java.util.Objects;

/**
 * A class that contains the structure and information af a Form
 */
public class Form {

    private Integer id;

    /**
     * The id of the post the form is related with
     */
    private Integer postId;

    public Form(){

    }

    public Form(Integer id, Integer postId) {

        this.id = id;
        this.postId = postId;
    }

    public Integer getPostId() {

        return postId;
    }

    public void setPostId(Integer postId) {

        this.postId = postId;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Form form = (Form) o;
        return Objects.equals(id, form.id) && Objects.equals(postId, form.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postId);
    }
}
