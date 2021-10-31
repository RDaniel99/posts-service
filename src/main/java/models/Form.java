package models;

/**
 * A class that contains the structure and information af a Form
 */
public class Form {

    private Integer id;

    /**
     * The id of the post the form is related with
     */
    private Integer postId;


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

}
