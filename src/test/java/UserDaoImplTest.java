import dataaccesslayer.DatabaseConnection;
import dataaccesslayer.UserDaoImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

/**
 * @author Yongxing Lian
 * @created 2024-08-04
 */
public class UserDaoImplTest {

    private UserDaoImpl userDao;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;

    @BeforeEach
    public void setUp() throws Exception {
        userDao = new UserDaoImpl();
        mockConnection = Mockito.mock(Connection.class);
        mockPreparedStatement = Mockito.mock(PreparedStatement.class);

        DatabaseConnection databaseConnection = Mockito.mock(DatabaseConnection.class);
        when(databaseConnection.createConnection()).thenReturn(mockConnection);

        userDao = new UserDaoImpl() {
            protected Connection getConnection() throws SQLException {
                return mockConnection;
            }
        };
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (mockConnection != null) {
            mockConnection.close();
        }
    }

    @Test
    public void testDeleteUserByID_Success() throws Exception {

        int userId = 1;
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        userDao.deleteUserByID(userId);

        verify(mockConnection).prepareStatement("Delete from Users where userID = ?;");
        verify(mockPreparedStatement).setInt(7, userId);
        verify(mockPreparedStatement).executeUpdate();
    }

    @Test
    public void testDeleteUserByID_SQLException() throws Exception {

        int userId = 7;
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        doThrow(new SQLException()).when(mockPreparedStatement).executeUpdate();


        assertThrows(SQLException.class, () -> {
            userDao.deleteUserByID(userId);
        });
    }

    @Test
    public void testDeleteUserByID_NoUserDeleted() throws Exception {

        int userId = 7;
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(0);

        userDao.deleteUserByID(userId);

        verify(mockPreparedStatement).setInt(1, userId);
        verify(mockPreparedStatement).executeUpdate();
    }
}