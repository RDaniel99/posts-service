package models;

/**
 * A class that contains the structure and information af a Form
 */
public class Form {

    private String id;

    /**
     * The id of the post the form is related with
     */
    private String postId;


    public String getPostId() {

        return postId;
    }

    public void setPostId(String postId) {

        this.postId = postId;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

}
