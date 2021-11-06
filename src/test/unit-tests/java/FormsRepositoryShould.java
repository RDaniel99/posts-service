
import database.FormsRepository;
import models.Form;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

public class FormsRepositoryShould {

    private final Integer FORM_ID = 1;
    private final Integer POST_ID = 1;

    @Mock
    Connection connection;
    @Mock
    PreparedStatement stmt;
    @Mock
    ResultSet rs;

    @InjectMocks
    FormsRepository repository = new FormsRepository();

    @BeforeEach
    public void setup() throws SQLException {

        MockitoAnnotations.initMocks(this);

        repository.setConnection(connection);

        when(connection.prepareStatement(anyString(), eq(Statement.RETURN_GENERATED_KEYS))).thenReturn(stmt);
        when(stmt.getGeneratedKeys()).thenReturn(rs);
        when(stmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getInt(eq(1))).thenReturn(FORM_ID);
        when(rs.getInt(eq(2))).thenReturn(POST_ID);
    }

    @Test
    public void createForm() throws SQLException {

        // setup
        Form form = new Form(null, POST_ID);

        // execute
        form = repository.create(form);

        // verify
        assertEquals(FORM_ID, form.getId());
    }

    @Test
    public void readForm() throws SQLException {

        // setup

        // execute
        Form form = repository.read(FORM_ID);

        // verify
        assertEquals(FORM_ID, form.getId());
    }

    @Test
    public void deleteForm() throws SQLException {

        // setup

        // execute
        Boolean result = repository.delete(FORM_ID);

        // verify
        assertEquals(true, result);
    }
}