package models;

/**
 * A class that represents the structure and information for a form answer
 */
public class FormAnswer {

    /**
     * The question this answer is associated with
     */
    private String questionId;

    /**
     * The user that answered to the question
     */
    private String userId;

    /**
     * The question content
     */
    private String content;

    private FormAnswer() {

    }

    public static class Builder {

        private FormAnswer formAnswerInstance;

        public Builder() {

            formAnswerInstance = new FormAnswer();
        }

        public Builder withQuestionId(String questionId) {

            formAnswerInstance.questionId = questionId;
            return this;
        }

        public Builder withUserId(String userId) {

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
