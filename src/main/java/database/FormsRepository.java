package database;

import models.Form;
import models.FormQuestion;

public class FormsRepository implements Database, Repository<Form> {

    @Override
    public Form create(Form object) {
        return null;
    }

    @Override
    public Form read(Integer id) {
        return null;
    }

    @Override
    public Form update(Form object) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
