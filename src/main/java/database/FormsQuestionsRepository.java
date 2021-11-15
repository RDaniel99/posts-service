package database;

import models.FormQuestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FormsQuestionsRepository implements Database, Repository<FormQuestion> {

    @Override
    public FormQuestion create(FormQuestion formQuestion) {

        String createQuery = "INSERT INTO formquestions(form_id, content) VALUE(?, ?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, formQuestion.getFormId());
            stmt.setString(2, formQuestion.getContent());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                formQuestion.setId(rs.getInt(1));
            }

            stmt.close();
        } catch (SQLException exception) {
            //TO-DO: User Friendly message
        }
        return formQuestion;
    }

    @Override
    public FormQuestion read(Integer id) {
        return null;
    }

    @Override
    public FormQuestion update(FormQuestion object) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
