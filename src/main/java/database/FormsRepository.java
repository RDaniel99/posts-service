package database;

import models.Form;

import java.sql.*;

public class FormsRepository implements Database, Repository<Form> {

    private Connection connection;

    public FormsRepository() {

        this.connection = Database.getConnection();
    }

    public void setConnection(Connection connection) {

        this.connection = connection;
    }

    @Override
    public Form create(Form form) {

        String createQuery = "INSERT INTO forms(post_id) VALUE(?)";
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
            //TO-DO: User Friendly message
        }
        return form;
    }


    @Override
    public Form read(Integer id) {

        Form form = new Form();

        String createQuery = "SELECT * From forms WHERE id = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                form.setId(rs.getInt(1));
                form.setPostId(rs.getInt(2));
            }

            stmt.close();
        } catch (SQLException exception) {
            //TO-DO: User Friendly message
        }
        return form;
    }

    @Override
    public Form update(Form object) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {

        String createQuery = "DELETE From forms WHERE id = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);

            int rs = stmt.executeUpdate();
            if (rs == 0) {

                return false;
            }

            stmt.close();
        } catch (SQLException exception) {
            //TO-DO: User Friendly message
        }
        return true;
    }
}
