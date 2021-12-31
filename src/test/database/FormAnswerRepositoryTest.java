package database;

import models.FormAnswer;
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

class FormAnswerRepositoryTest {


    private final Integer FORM_ANSWER_ID = 1;
    private final Integer QUESTION_ID = 1;

    @Mock
    Connection connection;
    @Mock
    PreparedStatement stmt;
    @Mock
    ResultSet rs;

    @InjectMocks
    FormAnswerRepository repository = new FormAnswerRepository();

    @BeforeEach
    public void setup() throws SQLException {

        MockitoAnnotations.initMocks(this);

        repository.setConnection(connection);

        when(connection.prepareStatement(anyString(), eq(Statement.RETURN_GENERATED_KEYS))).thenReturn(stmt);
        when(stmt.getGeneratedKeys()).thenReturn(rs);
        when(stmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getInt(eq(1))).thenReturn(FORM_ANSWER_ID);
        when(rs.getInt(eq(2))).thenReturn(QUESTION_ID);
    }

    @Test
    public void createForm() throws SQLException {

        // setup
        FormAnswer formAnswer = new FormAnswer.Builder().withId(FORM_ANSWER_ID).withQuestionId(QUESTION_ID).build();

        // execute
        formAnswer = repository.create(formAnswer);

        // verify
        assertEquals(FORM_ANSWER_ID, formAnswer.getId());
    }

    @Test
    public void readForm() throws SQLException {

        // setup

        // execute
        FormAnswer formAnswer = repository.read(FORM_ANSWER_ID);

        // verify
        assertEquals(FORM_ANSWER_ID, formAnswer.getId());
    }

    @Test
    public void deleteForm() throws SQLException {

        // setup

        // execute
        Boolean result = repository.delete(FORM_ANSWER_ID);

        // verify
        assertEquals(true, result);
    }
}