
import dataaccesslayer.DatabaseConnection;
import dataaccesslayer.DiscountDaoImpl;
import model.DiscountView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Yongxing Lian
 * @created 2024-08-04
 */
public class DiscountDaoImplTest {

    private DiscountDaoImpl discountDao;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws Exception {
        mockConnection = Mockito.mock(Connection.class);
        mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        mockResultSet = Mockito.mock(ResultSet.class);

        DatabaseConnection databaseConnection = Mockito.mock(DatabaseConnection.class);
        when(databaseConnection.createConnection()).thenReturn(mockConnection);

        discountDao = new DiscountDaoImpl() {
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
    public void testGetAllDiscountProducts_Success() throws Exception {
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);

        List<DiscountView> expectedDiscounts = new ArrayList<>();
        DiscountView discount1 = new DiscountView();
        discount1.setProductID(1);
        discount1.setProductName("Discount Product 1");
        discount1.setDiscountPrice(50.0);
        expectedDiscounts.add(discount1);

        DiscountView discount2 = new DiscountView();
        discount2.setProductID(2);
        discount2.setProductName("Discount Product 2");
        discount2.setDiscountPrice(30.0);
        expectedDiscounts.add(discount2);

        when(mockResultSet.getInt("productID")).thenReturn(discount1.getProductID()).thenReturn(discount2.getProductID());
        when(mockResultSet.getString("productName")).thenReturn(discount1.getProductName()).thenReturn(discount2.getProductName());
        when(mockResultSet.getDouble("discountPrice")).thenReturn(discount1.getDiscountPrice()).thenReturn(discount2.getDiscountPrice());

        List<DiscountView> actualDiscounts = discountDao.getAllDiscountProducts();

        assertEquals(expectedDiscounts.size(), actualDiscounts.size());
        for (int i = 0; i < expectedDiscounts.size(); i++) {
            assertEquals(expectedDiscounts.get(i).getProductID(), actualDiscounts.get(i).getProductID());
            assertEquals(expectedDiscounts.get(i).getProductName(), actualDiscounts.get(i).getProductName());
            assertEquals(expectedDiscounts.get(i).getDiscountPrice(), actualDiscounts.get(i).getDiscountPrice());
        }

        verify(mockConnection).prepareStatement("SELECT * from DiscountView ORDER BY productID");
        verify(mockPreparedStatement).executeQuery();
    }
}