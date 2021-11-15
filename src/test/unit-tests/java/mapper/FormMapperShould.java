import mappers.FormMapper;
import models.Form;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import javax.json.JsonObject;

import java.io.BufferedReader;
import java.io.StringReader;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

class FormMapperShould {

    private final Form form = new Form(1, 1);

    @Test
    void convertFromJsonToObject() {

        //setup
        String json = createFormJson();

        //execute
        Form resultedForm = FormMapper.fromJsonToObject(new BufferedReader(new StringReader(json)));

        //verify
        assertEquals(form, resultedForm);
    }


    private String createFormJson() {

        return "{ \"postId\": 1, \"id\": 1 }";
    }

}