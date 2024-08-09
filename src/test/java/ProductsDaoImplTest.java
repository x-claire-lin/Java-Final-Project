import dataaccesslayer.DatabaseConnection;
import dataaccesslayer.ProductsDaoImpl;
import model.Products;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Yongxing Lian
 * @created 2024-08-04
 */
public class ProductsDaoImplTest {

    private ProductsDaoImpl productsDao;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws Exception {
        productsDao = new ProductsDaoImpl();
        mockConnection = Mockito.mock(Connection.class);
        mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        mockResultSet = Mockito.mock(ResultSet.class);

        DatabaseConnection databaseConnection = Mockito.mock(DatabaseConnection.class);
        when(databaseConnection.createConnection()).thenReturn(mockConnection);

        productsDao = new ProductsDaoImpl() {
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
    public void testGetProductsById_Success() throws Exception {
        int productId = 2;
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);

        Products expectedProduct = new Products();
        expectedProduct.setProductID(productId);
        expectedProduct.setProductName("Test Product");
        expectedProduct.setSalePrice(100.0);
        expectedProduct.setDiscountPrice(90.0);
        expectedProduct.setInventoryAmount(50.0);
        expectedProduct.setDiscountAmount(10.0);
        expectedProduct.setDonationAmount(5.0);
        expectedProduct.setProductType("Type1");
        expectedProduct.setSurplusFlag("N");
        expectedProduct.setUserID(1);
        expectedProduct.setExpiryDate(java.sql.Date.valueOf("2023-12-31"));

        when(mockResultSet.getInt("productID")).thenReturn(expectedProduct.getProductID());
        when(mockResultSet.getString("productName")).thenReturn(expectedProduct.getProductName());
        when(mockResultSet.getDouble("salePrice")).thenReturn(expectedProduct.getSalePrice());
        when(mockResultSet.getDouble("discountPrice")).thenReturn(expectedProduct.getDiscountPrice());
        when(mockResultSet.getDouble("inventoryAmount")).thenReturn(expectedProduct.getInventoryAmount());
        when(mockResultSet.getDouble("discountAmount")).thenReturn(expectedProduct.getDiscountAmount());
        when(mockResultSet.getDouble("donationAmount")).thenReturn(expectedProduct.getDonationAmount());
        when(mockResultSet.getString("productType")).thenReturn(expectedProduct.getProductType());
        when(mockResultSet.getString("surplusFlag")).thenReturn(expectedProduct.getSurplusFlag());
        when(mockResultSet.getInt("userID")).thenReturn(expectedProduct.getUserID());
        when(mockResultSet.getDate("expiryDate")).thenReturn(expectedProduct.getExpiryDate());

        Products actualProduct = productsDao.getProductsById(productId);

        assertEquals(expectedProduct.getProductID(), actualProduct.getProductID());
        assertEquals(expectedProduct.getProductName(), actualProduct.getProductName());
        assertEquals(expectedProduct.getSalePrice(), actualProduct.getSalePrice());
        assertEquals(expectedProduct.getDiscountPrice(), actualProduct.getDiscountPrice());
        assertEquals(expectedProduct.getInventoryAmount(), actualProduct.getInventoryAmount());
        assertEquals(expectedProduct.getDiscountAmount(), actualProduct.getDiscountAmount());
        assertEquals(expectedProduct.getDonationAmount(), actualProduct.getDonationAmount());
        assertEquals(expectedProduct.getProductType(), actualProduct.getProductType());
        assertEquals(expectedProduct.getSurplusFlag(), actualProduct.getSurplusFlag());
        assertEquals(expectedProduct.getUserID(), actualProduct.getUserID());
        assertEquals(expectedProduct.getExpiryDate(), actualProduct.getExpiryDate());

        verify(mockConnection).prepareStatement("SELECT * from products where productId = ?");
        verify(mockPreparedStatement).setInt(1, productId);
        verify(mockPreparedStatement).executeQuery();
    }
}