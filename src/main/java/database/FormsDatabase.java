package database;

import models.Form;
import models.FormQuestion;

public class FormsDatabase implements Database, Repository<Form, FormQuestion> {

    // TODO: Schimbat numele in Repository

    @Override
    public Form createT(Form object) {
        return null;
    }

    @Override
    public Form readT(String id) {
        return null;
    }

    @Override
    public Form updateT(Form object) {
        return null;
    }

    @Override
    public boolean deleteT(String id) {
        return false;
    }

    @Override
    public FormQuestion createK(FormQuestion object) {
        return null;
    }

    @Override
    public FormQuestion readK(String id) {
        return null;
    }

    @Override
    public FormQuestion updateK(FormQuestion object) {
        return null;
    }

    @Override
    public boolean deleteK(String id) {
        return false;
    }
}
