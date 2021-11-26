package database;

import exceptions.CrudException;
import models.Form;
import models.FormQuestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static constants.FormQuestionsDatabase.*;
import static exceptions.CrudException.Reason.*;

public class FormsQuestionsRepository implements Database, Repository<FormQuestion> {

    @Override
    public FormQuestion create(FormQuestion formQuestion) {

        String createQuery = String.format("INSERT INTO %s(%s, %s) VALUE(?, ?)", DATABASE_NAME, FORM_ID, CONTENT);
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

            //TODO: User Friendly message
        }
        return formQuestion;
    }

    @Override
    public FormQuestion read(Integer id) {

        FormQuestion formQuestion = null;
        String createQuery = String.format("SELECT * From %s WHERE %s = ?", DATABASE_NAME, ID);

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                formQuestion = convertToFormQuestion(rs);
            }

            stmt.close();
        } catch (SQLException exception) {
            //TODO: User Friendly message
        }

        return formQuestion;
    }

    public List<FormQuestion> readByFormID(Integer id) {

        List<FormQuestion> formQuestionList = new ArrayList<>();

        String createQuery = String.format("SELECT * From %s WHERE %s = ?", DATABASE_NAME, FORM_ID);

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {

                formQuestionList.add(convertToFormQuestion(rs));
            }

            stmt.close();
        } catch (SQLException exception) {
            //TODO: User Friendly message
        }

        return formQuestionList;
    }


    @Override
    public FormQuestion update(FormQuestion originalFormQuestion, FormQuestion newFormQuestion) {

        try {

            String setStmt = generateSetString(originalFormQuestion, newFormQuestion);

            String updateQuery = String.format("UPDATE %s SET %s WHERE id=%d", DATABASE_NAME, setStmt, originalFormQuestion.getId());

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(String.format(updateQuery, setStmt, originalFormQuestion.getId()));

        } catch (CrudException | SQLException ignored) {

            return originalFormQuestion;
        }

        return newFormQuestion;
    }

    private String generateSetString(FormQuestion originalFormQuestion, FormQuestion newFormQuestion) throws CrudException {

        StringBuilder builder = new StringBuilder();

        if (newFormQuestion.getId() != null && !originalFormQuestion.getId().equals(newFormQuestion.getId())) {

            throw new CrudException(ID_CANNOT_BE_CHANGED);
        }

        if (newFormQuestion.getFormId() != null && !originalFormQuestion.getFormId().equals(newFormQuestion.getFormId())) {

            throw new CrudException(FORM_ID_CANNOT_BE_CHANGED);
        }

        if (newFormQuestion.getContent() != null && !originalFormQuestion.getContent().equals(newFormQuestion.getContent())) {

            builder.append("content = ");
            builder.append("\"" + newFormQuestion.getContent() + "\"");
        }

        return builder.toString();
    }

    @Override
    public boolean delete(Integer id) {

        String createQuery = String.format("DELETE From %s WHERE %s = ?", DATABASE_NAME, ID);

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);

            stmt.executeUpdate();

            stmt.close();
        } catch (Exception exception) {
            //TODO: User Friendly message
            return false;
        }

        return true;
    }

    private FormQuestion convertToFormQuestion(ResultSet resultSet) throws SQLException {

        return new FormQuestion.Builder()
                .withId(resultSet.getInt(1))
                .withFormId(resultSet.getInt(2))
                .withContent(resultSet.getString(3))
                .build();
    }
}
