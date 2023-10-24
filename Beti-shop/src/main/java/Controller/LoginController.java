/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAOs.StaffDAO;
import DAOs.UserDAO;
import Modals.Staff;
import Modals.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class LoginController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        if (path.endsWith("/Beti-shop/Login")) {
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        } else {
            if (path.endsWith("/Staff/Product")) {
                request.getRequestDispatcher("/listproduct.jsp").forward(request, response);
            }
        }
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
        if (request.getParameter("btnLogin") != null && request.getParameter("btnLogin").equals("login")) {
            String email = request.getParameter("email1");
            String pass = request.getParameter("password1");
            String role = request.getParameter("role");

            switch (role) {
                case "user":
                    User user = new User(email, pass);
                    UserDAO lgdao1 = new UserDAO();
                    User ac1 = lgdao1.GetUser(email);
                    boolean ketqua1 = false;
                    try {
                        ketqua1 = lgdao1.Login(user);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (ketqua1) {
                        Cookie c = new Cookie("user", String.valueOf(ac1.getUserID()));
                        Cookie cfull = new Cookie("nameUser", URLEncoder.encode(ac1.getUserName(), "UTF-8"));
                        c.setMaxAge(60 * 60);
                        cfull.setMaxAge(60 * 60);
                        response.addCookie(c);
                        response.addCookie(cfull);
                        response.sendRedirect("/Beti-shop/");
                      } else {
                        response.sendRedirect("/Beti-shop/Login");
                    }
                case "staff":
                    Staff staff = new Staff(email, pass);
                    StaffDAO lgdao2 = new StaffDAO();
                    Staff ac = lgdao2.GetStaff(email);
                    boolean ketqua = false;
                    try {
                        ketqua = lgdao2.Login(staff);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (ketqua) {
                        Cookie c = new Cookie("staff", String.valueOf(ac.getStaffID()));
                        Cookie cfull = new Cookie("nameStaff", URLEncoder.encode(ac.getStaffName(), "UTF-8"));
                        c.setMaxAge(60 * 60);
                        cfull.setMaxAge(60 * 60);
                        response.addCookie(c);
                        response.addCookie(cfull);
                        response.sendRedirect("/Beti-shop/manager");
                        
                    break;
                    } else {
                        response.sendRedirect("/Beti-shop/Login");
                    }
                default:
                    response.sendRedirect("/Beti-shop/Login");
                    break;

            }

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
