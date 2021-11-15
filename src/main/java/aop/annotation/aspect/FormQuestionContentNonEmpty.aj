package aop.annotation.aspect;

import models.Form;
import models.FormQuestion;

public aspect FormQuestionContentNonEmpty {

    pointcut checkNotEmpty(FormQuestion.Builder builder):
            call(FormQuestion FormQuestion.Builder.build()) && args() && target(builder);

    before(FormQuestion.Builder builder): checkNotEmpty(builder) {
    }

    FormQuestion around(FormQuestion.Builder builder):
            checkNotEmpty(builder) {
        if (builder.formQuestionInstance.getContent() == null) {
            return null;
        }
        return proceed(builder);
    }

    after(FormQuestion.Builder builder): checkNotEmpty(builder) {
    }
}

