package database;

import exceptions.FormReadException;
import models.Form;

import java.sql.*;

import static constants.FormsDatabase.*;

public class FormRepository implements Database, Repository<Form> {

    private Connection connection;

    public FormRepository() {

        this.connection = Database.getConnection();
    }

    public void setConnection(Connection connection) {

        this.connection = connection;
    }

    @Override
    public Form create(Form form) {

        String createQuery = String.format("INSERT INTO %s(%s) VALUE(?)", DATABASE_NAME, FORMS_POST_ID);
        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, form.getPostId());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {

                form.setId(rs.getInt(1));
            }

            stmt.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            //TODO: User Friendly message
        }
        return form;
    }


    @Override
    public Form read(Integer id) throws FormReadException {

        Form form = null;
        String createQuery = String.format("SELECT * From %s WHERE %s = ?", DATABASE_NAME, FORMS_ID);

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                form = convertToForm(rs);
            }
            else{

                throw new FormReadException(FormReadException.Reason.FORM_NOT_FOUND);
            }

            stmt.close();
        } catch (SQLException exception) {
            //TODO: User Friendly message
        }

        return form;
    }


    public Form readByPostId(Integer id) throws FormReadException {

        Form form = null;
        String createQuery = String.format("SELECT * From %s WHERE %s = ?", DATABASE_NAME, FORMS_POST_ID);

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                form = convertToForm(rs);
            }
            else{

                throw new FormReadException(FormReadException.Reason.FORM_NOT_FOUND);
            }

            stmt.close();
        } catch (SQLException exception) {
            //TO-DO: User Friendly message
        }

        return form;
    }

    @Override
    public Form update(Form originalObject, Form newObject) {

        return null;
    }

    @Override
    public boolean delete(Integer id) {

        String createQuery = String.format("DELETE From %s WHERE %s = ?", DATABASE_NAME, FORMS_ID);

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

    private Form convertToForm(ResultSet resultSet) throws SQLException {

        Form form = new Form();
        form.setId(resultSet.getInt(1));
        form.setPostId(resultSet.getInt(2));

        return form;
    }
}
