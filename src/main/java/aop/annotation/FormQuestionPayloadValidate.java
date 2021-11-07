package aop.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = FormQuestionPayloadValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@ReportAsSingleViolation
@Documented
public @interface FormQuestionPayloadValidate {

    String message() default "Wrong!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
