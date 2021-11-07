package aop.annotation;

import mappers.FormQuestionMapper;
import models.FormQuestion;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;


public class FormQuestionPayloadValidator implements ConstraintValidator<FormQuestionPayloadValidate, HttpServletRequest> {


    @Override
    public void initialize(FormQuestionPayloadValidate constraintAnnotation) {
    }

    @Override
    public boolean isValid(HttpServletRequest request, ConstraintValidatorContext constraintValidatorContext) {
        FormQuestion formQuestion = null;

        try {
            formQuestion = FormQuestionMapper.fromJsonToObject(request.getReader());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert formQuestion != null;

        return false;
    }
}
