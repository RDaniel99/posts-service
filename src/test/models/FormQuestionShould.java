package models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FormQuestionShould {

    FormQuestion.Builder builder;

    @BeforeEach
    public void before() {

        builder = new FormQuestion.Builder();
    }

    @Test
    public void givenEmptyContentThenFail() {

        builder.withFormId(1).withId(2).build();
    }

    @Test
    public void givenWithContentThenSuccess() {

        builder.withFormId(1).withId(2).withContent("Hello").build();
    }
}
