package mappers;

import com.google.gson.Gson;
import models.FormAnswer;

import java.io.BufferedReader;

public class FormAnswerMapper {

    public  FormAnswer fromJsonToObject(BufferedReader reader) {

        return new Gson().fromJson(reader, FormAnswer.class);
    }

    public  String fromObjectToJson(FormAnswer formAnswer) {

        return new Gson().toJson(formAnswer);
    }
}
