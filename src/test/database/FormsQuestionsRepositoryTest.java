package database;

import models.FormQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

class FormsQuestionsRepositoryTest {

    private final Integer FORM_QUESTION_ID = 1;
    private final Integer FORM_ID = 1;

    @Mock
    Connection connection;
    @Mock
    PreparedStatement stmt;
    @Mock
    ResultSet rs;

    @InjectMocks
    FormsQuestionsRepository repository = new FormsQuestionsRepository();

    @BeforeEach
    public void setup() throws SQLException {

        MockitoAnnotations.initMocks(this);

        repository.setConnection(connection);

        when(connection.prepareStatement(anyString(), eq(Statement.RETURN_GENERATED_KEYS))).thenReturn(stmt);
        when(stmt.getGeneratedKeys()).thenReturn(rs);
        when(stmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getInt(eq(1))).thenReturn(FORM_QUESTION_ID);
        when(rs.getInt(eq(2))).thenReturn(FORM_ID);
    }

    @Test
    public void createForm() throws SQLException {

        // setup
        FormQuestion formQuestion = new FormQuestion.Builder().withId(FORM_QUESTION_ID).withFormId(FORM_ID).build();

        // execute
        formQuestion = repository.create(formQuestion);

        // verify
        assertEquals(FORM_QUESTION_ID, formQuestion.getId());
    }

    @Test
    public void readForm() throws SQLException {

        // setup

        // execute
        FormQuestion formQuestion = repository.read(FORM_QUESTION_ID);

        // verify
        assertEquals(FORM_QUESTION_ID, formQuestion.getId());
    }

    @Test
    public void deleteForm() throws SQLException {

        // setup

        // execute
        Boolean result = repository.delete(FORM_QUESTION_ID);

        // verify
        assertEquals(true, result);
    }

}