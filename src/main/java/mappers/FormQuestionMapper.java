package mappers;

import com.google.gson.Gson;
import models.FormQuestion;

import java.io.BufferedReader;

public class FormQuestionMapper {

    public  FormQuestion fromJsonToObject(BufferedReader reader) {

        return new Gson().fromJson(reader, FormQuestion.class);
    }

    public  String fromObjectToJson(FormQuestion formQuestion) {

        return new Gson().toJson(formQuestion);
    }
}
