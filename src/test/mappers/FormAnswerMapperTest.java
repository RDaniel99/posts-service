package mappers;

import models.FormAnswer;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormAnswerMapperTest {

    private final FormAnswer formAnswer = new FormAnswer.Builder().withUserId(1).withQuestionId(1).withContent("Hello").build();

    private FormAnswerMapper formAnswerMapper;
    private void setup() {

        formAnswerMapper = new FormAnswerMapper();
    }
    @Test
    void convertFromJsonToObject() {

        //setup
        setup();
        String json = createFormJson();

        //execute
        FormAnswer resultedFormAnswer = formAnswerMapper.fromJsonToObject(new BufferedReader(new StringReader(json)));

        //verify
        assertEquals(formAnswer, resultedFormAnswer);
    }


    private String createFormJson() {

        return "{ \"userId\": 1, \"questionId\": 1, \"content\": \"Hello\" }";
    }


}