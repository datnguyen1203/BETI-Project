/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAOs.ProductDAO;
import DAOs.orderDAO;
import Modals.Order;
import Modals.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ManagerControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ManagerControl</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ManagerControl at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        String path = request.getRequestURI();

        switch (path) {
            case "/Beti-shop/manager":
                request.setAttribute("mana", "choose");
                request.getRequestDispatcher("/listproduct.jsp").forward(request, response);
                break;
            case "/Beti-shop/manager/ShowOrder":
                orderDAO ordao = new orderDAO();
                List<Order> orderList = ordao.getAllOrder();
                request.setAttribute("ord", "choose");
                request.setAttribute("listOr", orderList);
                request.getRequestDispatcher("/showOrder.jsp").forward(request, response);
                break;
            case "/Beti-shop/manager/monthRevenue":
                orderDAO or = new orderDAO();
                List<Order> listRevenue = or.monthlyRevenue();
                request.setAttribute("mth", "choose");
                request.setAttribute("listRevenue", listRevenue);
                request.getRequestDispatcher("/MonthRevenue.jsp").forward(request, response);
                break;

        }
        String[] s = path.split("/");
        String action = s[s.length - 2];
        String pro_id = URLDecoder.decode(s[s.length - 1], "UTF-8");
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
        processRequest(request, response);
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
