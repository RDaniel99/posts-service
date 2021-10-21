package models;

/**
 * A class that contains the structure and information af a Form
 */
public class FormQuestion {

    private String id;

    /**
     * The id of the form that contains this question
     */
    private String formId;

    /**
     * The question content
     */
    private String content;

    private FormQuestion(){

    }

    public static class Builder{

        private final FormQuestion formQuestionInstance;

        public Builder(){

            formQuestionInstance = new FormQuestion();
        }

        public Builder withId(String id){

            formQuestionInstance.id = id;
            return this;
        }

        public Builder withFormId(String formId){

            formQuestionInstance.formId = formId;
            return this;
        }

        public Builder withContent(String content){

            formQuestionInstance.content = content;
            return this;
        }

        public FormQuestion build(){

            return formQuestionInstance;
        }
    }

}
