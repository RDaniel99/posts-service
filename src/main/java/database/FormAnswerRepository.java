package database;

import models.FormAnswer;

public class FormAnswerRepository implements Database, Repository<FormAnswer> {

    @Override
    public FormAnswer create(FormAnswer object) {
        return null;
    }

    @Override
    public FormAnswer read(Integer id) {
        return null;
    }

    @Override
    public FormAnswer update(FormAnswer originalObject, FormAnswer newObject) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
