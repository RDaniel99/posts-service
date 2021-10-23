package database;

import models.Form;
import models.FormQuestion;

public class FormsQuestionsRepository implements Database, Repository<FormQuestion>{
    @Override
    public FormQuestion create(FormQuestion object) {
        return null;
    }

    @Override
    public FormQuestion read(String id) {
        return null;
    }

    @Override
    public FormQuestion update(FormQuestion object) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
