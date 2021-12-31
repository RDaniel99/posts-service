package models;

import java.util.Objects;

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

    public Integer getId() {

        return id;
    }

    public String getContent() {

        return content;
    }

    public Integer getFormId() {

        return formId;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    private FormQuestion() {

    }

    public static class Builder {

        public final FormQuestion formQuestionInstance;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormQuestion that = (FormQuestion) o;
        return Objects.equals(id, that.id) && Objects.equals(formId, that.formId) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, formId, content);
    }
}
