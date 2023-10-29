/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAOs.UserDAO;
import Modals.User;
import Ultis.Helper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nhvie
 */
public class ChangePasswordServlet extends HttpServlet {

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
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
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
        processRequest(request, response);
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
        String email = request.getParameter("email");
        String oldpass = request.getParameter("oldpass");
        String newpass = request.getParameter("newpass");
        String confirmPass = request.getParameter("confirmpass");
        UserDAO udao = new UserDAO();
        User user = udao.GetUser(email);
        if (user == null) {
            request.setAttribute("error", "Email not registered");
            request.setAttribute("email", email);
            request.setAttribute("oldpass", oldpass);
            request.setAttribute("newpass", newpass);
            request.setAttribute("confirmPass", confirmPass);
        } else if (!user.getUserPassword().equals(oldpass)) {
            request.setAttribute("error", "Password wrong!");
            request.setAttribute("email", email);
            request.setAttribute("oldpass", oldpass);
            request.setAttribute("newpass", newpass);
            request.setAttribute("confirmPass", confirmPass);
        } else if(!newpass.equals(confirmPass)){
            request.setAttribute("error", "Password Confirm not match!");
            request.setAttribute("email", email);
            request.setAttribute("oldpass", oldpass);
            request.setAttribute("newpass", newpass);
            request.setAttribute("confirmPass", confirmPass);
        } else {
            String hashPassword = Helper.hashPassword(newpass, "MD5");
            udao.updatePassword(email, hashPassword);
            request.setAttribute("report", "Change Password successful!");
        }
        doGet(request, response);
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
