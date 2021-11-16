package models;

/**
 * A class that represents the structure and information for a form answer
 */
public class FormAnswer {

    private Integer id;

    /**
     * The question this answer is associated with
     */
    private Integer questionId;

    /**
     * The user that answered to the question
     */
    private Integer userId;

    /**
     * The question content
     */
    private String content;

    public Integer getQuestionId() {

        return questionId;
    }

    public String getContent() {

        return content;
    }

    public Integer getUserId() {

        return userId;
    }

    private FormAnswer() {

    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static class Builder {

        private FormAnswer formAnswerInstance;

        public Builder() {

            formAnswerInstance = new FormAnswer();
        }

        public Builder withId(Integer id) {

            formAnswerInstance.id = id;
            return this;
        }

        public Builder withQuestionId(Integer questionId) {

            formAnswerInstance.questionId = questionId;
            return this;
        }

        public Builder withUserId(Integer userId) {

            formAnswerInstance.userId = userId;
            return this;
        }

        public Builder withContent(String content) {

            formAnswerInstance.content = content;
            return this;
        }

        public FormAnswer build() {

            return formAnswerInstance;
        }
    }

}
