import businesslayer.AuthorityService;
import businesslayer.UserService;
import controller.AuthorityServlet;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author Yongxing Lian
 * @created 2024-08-04
 */
public class AuthorityServletTest {

    private AuthorityServlet authorityServlet;
    private HttpServletRequest mockRequest;
    private HttpServletResponse mockResponse;
    private RequestDispatcher mockDispatcher;
    private UserService mockUserService;
    private AuthorityService mockAuthorityService;

    @BeforeEach
    public void setUp() {
        authorityServlet = new AuthorityServlet();
        mockRequest = Mockito.mock(HttpServletRequest.class);
        mockResponse = Mockito.mock(HttpServletResponse.class);
        mockDispatcher = Mockito.mock(RequestDispatcher.class);
        mockUserService = Mockito.mock(UserService.class);
        mockAuthorityService = Mockito.mock(AuthorityService.class);
    }

    @Test
    public void testDoGet_Success() throws Exception {
        List<User> users = new ArrayList<>();
        when(mockUserService.getAllUsers()).thenReturn(users);
        when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockDispatcher);

        authorityServlet.doGet(mockRequest, mockResponse);

        verify(mockRequest).setAttribute("msg", "Password is incorrect");
        verify(mockRequest).setAttribute("users", users);
        verify(mockDispatcher).forward(mockRequest, mockResponse);
    }

    @Test
    public void testDoPost_Success() throws Exception {
        when(mockRequest.getParameter("Email")).thenReturn("test@example.com");
        when(mockRequest.getParameter("password")).thenReturn("password");
        User user = new User();
        user.setUserPassword("password");
        when(mockUserService.getUserByEmail(anyString())).thenReturn(user);

        authorityServlet.doPost(mockRequest, mockResponse);

        verify(mockRequest).getParameter("Email");
        verify(mockRequest).getParameter("password");
        verify(mockUserService).getUserByEmail("test@example.com");
        verify(mockRequest).setAttribute("msg", "Password is incorrect");
    }

    @Test
    public void testCheckUser_Success() throws Exception {
        when(mockRequest.getParameter("Email")).thenReturn("test@example.com");
        when(mockRequest.getParameter("password")).thenReturn("password");
        User user = new User();
        user.setUserPassword("password");
        when(mockUserService.getUserByEmail(anyString())).thenReturn(user);

        Boolean result = authorityServlet.checkUser(mockRequest, mockResponse);

        assertTrue(result);
        verify(mockRequest).getParameter("Email");
        verify(mockRequest).getParameter("password");
        verify(mockUserService).getUserByEmail("test@example.com");
    }
}