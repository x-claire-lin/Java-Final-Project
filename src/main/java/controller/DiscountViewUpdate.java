package controller;

import businesslayer.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Qirong Chen
 */
@WebServlet(name = "DiscountViewUpdate", urlPatterns = {"/DiscountViewUpdate"})
public class DiscountViewUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DiscountViewServlet");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 获取请求参数中的ID，并将其转换为整数
            int id = Integer.parseInt(request.getParameter("id"));
            double amount = Double.parseDouble(request.getParameter("amount"));
            // 创建ProductService实例
            ProductService pbl = new ProductService();

            // 使用获取的ID值来更新捐赠
            // 假设你还有一个从请求参数中获取金额的逻辑
            pbl.updateDiscount(id, amount);

            // 重定向到 doGet() 方法中去处理其他逻辑
            doGet(request, response);
        } catch (NumberFormatException e) {
            // 如果参数无法解析为整数，捕获异常并进行适当的错误处理
            // 例如，可以返回一个错误页面或者向客户端发送一个错误消息
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}