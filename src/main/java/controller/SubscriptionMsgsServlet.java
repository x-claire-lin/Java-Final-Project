package controller;

import businesslayer.ProductsBusinessLogic;
import businesslayer.UserSubscriptionBusinessLogic;
import model.Products;
import model.UserSubscription;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Yongxing Lian
 */
@WebServlet(name = "SubscriptionMsgsServlet", urlPatterns = {"/SubscriptionMsgsServlet"})
public class SubscriptionMsgsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        HttpSession session=request.getSession();
        int userID =(int)session.getAttribute("userID");
        String location =(String)session.getAttribute("location");
        UserSubscriptionBusinessLogic businessLogic = new UserSubscriptionBusinessLogic();
        List<UserSubscription> subscriptions = businessLogic.getUserSubscriptionList(userID, location);

        ProductsBusinessLogic businessLogic1 = new ProductsBusinessLogic();
        if (subscriptions != null && subscriptions.size() > 0) {
            List<String> collect = subscriptions.stream().map(UserSubscription::getProductType).collect(Collectors.toList());
            List<Products> productsList = businessLogic1.getAllProductsByCondition(collect, location);
            List<Products> collect1 = productsList.stream().filter(e -> e.getUserCity().equals(location)).collect(Collectors.toList());
            request.setAttribute("productsList", collect1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/subscriptionMsg.jsp");
            dispatcher.forward(request, response);
        }else{
            request.setAttribute("productsList", new ArrayList<>());
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/subscriptionMsg.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Subscription Messages Servlet";
    }
}