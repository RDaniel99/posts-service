package mappers;

import models.Form;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormMapperShould {

    private final Form form = new Form(1, 1);

    private FormMapper formMapper;

    private void setup(){

        formMapper = new FormMapper();
    }

    @Test
    void convertFromJsonToObject() {

        setup();
        //setup
        String json = createFormJson();

        //execute
        Form resultedForm = formMapper.fromJsonToObject(new BufferedReader(new StringReader(json)));

        //verify
        assertEquals(form, resultedForm);
    }

    @Test
    void convertFromObjectToJSON() {

        setup();
        //setup
        String json = createFormJson();

        //execute
        String resultedJson = formMapper.fromObjectToJson(form);

        //verify
        assertEquals(json, resultedJson);
    }


    private String createFormJson() {

        return "{\"id\":1,\"postId\":1}";
    }

}