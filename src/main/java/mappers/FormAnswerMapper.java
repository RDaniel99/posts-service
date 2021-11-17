package mappers;

import com.google.gson.Gson;
import models.Form;
import models.FormAnswer;

import java.io.BufferedReader;

public class FormAnswerMapper {

    public static FormAnswer fromJsonToObject(BufferedReader reader) {

        return new Gson().fromJson(reader, FormAnswer.class);
    }

    public static String fromObjectToJson(FormAnswer formAnswer) {

        return new Gson().toJson(formAnswer);
    }
}
