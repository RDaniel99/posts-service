package mappers;

import com.google.gson.Gson;
import models.Form;

import java.io.BufferedReader;

public class FormMapper {

    public  Form fromJsonToObject(BufferedReader reader) {

        return new Gson().fromJson(reader, Form.class);
    }

    public  String fromObjectToJson(Form form) {

        return new Gson().toJson(form);
    }
}
