package controller;

import businesslayer.AuthorityService;
import businesslayer.UserService;
import dataaccesslayer.DiscountDaoImpl;
import model.Author;
import model.DiscountView;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "PurchaseServlet", urlPatterns = {"/PurchaseServlet"})
public class PurchaseServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        AuthorityService authorBusinessLogic = new AuthorityService();
//        List<Author> authors = null;
//
//        try {
//            authors = authorBusinessLogic.getAllAuthors();
//        } catch (SQLException ex) {
//            log(ex.getMessage());
//        }
//
//        request.setAttribute("authors", authors);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("views/authors.jsp");
//        dispatcher.forward(request, response);
        //request.setAttribute("msg", "Password is incorrect");
        UserService UB=new UserService();
        DiscountDaoImpl discount = new DiscountDaoImpl();
         List<User>  users= null;
         ArrayList<DiscountView> discountarray = null;
         
        try {
            discountarray = discount.getAllDiscountProducts();

            
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
           try {
             users = UB.getAllUsers();
        } catch (SQLException ex) {
            log(ex.getMessage());
        }
        
        
            request.setAttribute("dis", discountarray);

            //request.setAttribute("users", users);


        RequestDispatcher dispatcher = request.getRequestDispatcher("views/purchase.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //UserService UB=new UserService();
        DiscountDaoImpl discount = new DiscountDaoImpl();
          //List<User>  users= null;
          ArrayList<DiscountView> discountarray =null;
          String a ="";
        try {
            discountarray = discount.getAllDiscountProducts();
            a= discountarray.get(0).getProductName();

            
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            request.setAttribute("dis", discountarray);

            //request.setAttribute("users", users);


        RequestDispatcher dispatcher = request.getRequestDispatcher("views/purchase.jsp");
        dispatcher.forward(request, response);
          
          
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void addAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthorityService authorBusinessLogic = new AuthorityService();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorBusinessLogic.addAuthor(author);
    }
    
    private Boolean checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        UserService UB=new UserService();
        Boolean isExist=false;
        String email=request.getParameter("Email");
        String password=request.getParameter("password");
        User user = UB.getUserByEmail(email);
        if( user!=null && user.getUserPassword().equals(password)){
                 isExist=true;            
        }
        return isExist;
    }

}