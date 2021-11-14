package models;

/**
 * A class that contains the structure and information af a Form
 */
public class FormQuestion {


    private Integer id;

    /**
     * The id of the form that contains this question
     */
    private Integer formId;

    /**
     * The question content
     */
    private String content;

    public String getContent() {

        return content;
    }

    public Integer getFormId() {

        return formId;
    }

    public Integer getId() {

        return id;
    }

    private FormQuestion() {

    }

    public static class Builder {

        private final FormQuestion formQuestionInstance;

        public Builder() {

            formQuestionInstance = new FormQuestion();
        }

        public Builder withId(Integer id) {

            formQuestionInstance.id = id;
            return this;
        }

        public Builder withFormId(Integer formId) {

            formQuestionInstance.formId = formId;
            return this;
        }

        public Builder withContent(String content) {

            formQuestionInstance.content = content;
            return this;
        }

        public FormQuestion build() {

            return formQuestionInstance;
        }
    }

}
