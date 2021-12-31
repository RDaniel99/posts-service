package mappers;

import models.FormQuestion;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormQuestionMapperTest {

    private final FormQuestion formQuestion = new FormQuestion.Builder().withFormId(1).withId(1).withContent("Hello").build();

    private  FormQuestionMapper formQuestionMapper;

    private void setup(){

            formQuestionMapper = new FormQuestionMapper();
    }

    @Test
    void convertFromJsonToObject() {

        setup();
        //setup
        String json = createFormJson();

        //execute
        FormQuestion formQuestionResulted = formQuestionMapper.fromJsonToObject(new BufferedReader(new StringReader(json)));

        //verify
        assertEquals(formQuestion, formQuestionResulted);
    }


    private String createFormJson() {

        return "{ \"id\": 1, \"formId\": 1, \"content\": \"Hello\" }";
    }

}