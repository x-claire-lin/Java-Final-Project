/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import businesslayer.SubscriptionMsgBusinessLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ydx22
 */
@WebServlet(name = "SubscriptionMsgsDeleteServlet", urlPatterns = {"/SubscriptionMsgsDeleteServlet"})
public class SubscriptionMsgsDeleteServlet extends HttpServlet {
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("/SubscriptionMsgsServlet");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            // 获取请求参数中的ID，并将其转换为整数
            int id = Integer.parseInt(request.getParameter("id"));
            
            // 创建ProductsBusinessLogic实例
            SubscriptionMsgBusinessLogic Smbl = new SubscriptionMsgBusinessLogic();

            // 使用获取的ID值来更新捐赠
            // 假设你还有一个从请求参数中获取金额的逻辑
            Smbl.deleteSubscriptionMsg(id);
            // 重定向到 doGet() 方法中去处理其他逻辑
            doGet(request, response);
        } catch (NumberFormatException e) {
            // 如果参数无法解析为整数，捕获异常并进行适当的错误处理
            // 例如，可以返回一个错误页面或者向客户端发送一个错误消息
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        }
        
        
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

}