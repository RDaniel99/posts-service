package database;

import exceptions.CrudException;
import models.FormAnswer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static constants.FormAnswerDatabase.*;
import static exceptions.CrudException.Reason.*;


public class FormAnswerRepository implements Database, Repository<FormAnswer> {

    @Override
    public FormAnswer create(FormAnswer formAnswer) {

        String createQuery = String.format("INSERT INTO %s(%s, %s, %s) VALUE(?, ?, ?)", DATABASE_NAME, FORM_QUESTION_ID, USER_ID, CONTENT);

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, formAnswer.getQuestionId());
            stmt.setInt(2, formAnswer.getUserId());
            stmt.setString(3, formAnswer.getContent());

            stmt.executeUpdate();

            System.out.println(stmt);
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                formAnswer.setId(rs.getInt(1));
            }

            stmt.close();
        } catch (SQLException exception) {
            //TODO: User Friendly message
        }
        return formAnswer;
    }

    @Override
    public FormAnswer read(Integer id) {

        FormAnswer formAnswer = null;
        String createQuery = String.format("SELECT * From %s WHERE %s = ?", DATABASE_NAME, FORM_ANSWER_ID);

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                formAnswer = convertToFormAnswer(rs);
            }

            stmt.close();
        } catch (SQLException exception) {
            //TODO: User Friendly message
        }

        return formAnswer;
    }


    public FormAnswer readByQuestionAndUserId(Integer userId, Integer questionId) {

        FormAnswer formAnswer = null;
        String createQuery = String.format("SELECT * From %s WHERE %s = ? AND %s = ?", DATABASE_NAME, FORM_QUESTION_ID, USER_ID);

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, questionId);
            stmt.setInt(2, userId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                formAnswer = convertToFormAnswer(rs);
            }

            stmt.close();
        } catch (SQLException exception) {
            //TODO: User Friendly message
        }

        return formAnswer;
    }


    @Override
    public FormAnswer update(FormAnswer originalFormAnswer, FormAnswer newFormAnswer) {

        try {

            String setStmt = generateSetString(originalFormAnswer, newFormAnswer);

            String updateQuery = String.format("UPDATE %s SET %s WHERE id=%d", DATABASE_NAME, setStmt, originalFormAnswer.getId());

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(String.format(updateQuery, setStmt, originalFormAnswer.getId()));

        } catch (CrudException | SQLException ignored) {

            return originalFormAnswer;
        }

        return newFormAnswer;
    }

    private String generateSetString(FormAnswer originalFormAnswer, FormAnswer newFormAnswer) throws CrudException {

        StringBuilder builder = new StringBuilder();

        if (newFormAnswer.getId() != null && !originalFormAnswer.getId().equals(newFormAnswer.getId())) {

            throw new CrudException(ID_CANNOT_BE_CHANGED);
        }

        if (newFormAnswer.getUserId() != null && !originalFormAnswer.getUserId().equals(newFormAnswer.getUserId())) {

            throw new CrudException(USER_ID_CANNOT_BE_CHANGED);
        }

        if (newFormAnswer.getQuestionId() != null && !originalFormAnswer.getQuestionId().equals(newFormAnswer.getQuestionId())) {

            throw new CrudException(QUESTION_ID_CANNOT_BE_CHANGED);
        }

        if (newFormAnswer.getContent() != null && !originalFormAnswer.getContent().equals(newFormAnswer.getContent())) {

            builder.append("content = ");
            builder.append("\"").append(newFormAnswer.getContent()).append("\"");
        }

        return builder.toString();
    }

    @Override
    public boolean delete(Integer id) {

        String createQuery = String.format("DELETE From %s WHERE %s = ?", DATABASE_NAME, FORM_ANSWER_ID);

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);

            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException exception) {
            //TODO: User Friendly message
            return false;
        }

        return true;
    }

    private FormAnswer convertToFormAnswer(ResultSet resultSet) throws SQLException {

        return new FormAnswer.Builder()
                .withId(resultSet.getInt(1))
                .withQuestionId(resultSet.getInt(2))
                .withUserId(resultSet.getInt(3))
                .withContent(resultSet.getString(4))
                .build();
    }
}
