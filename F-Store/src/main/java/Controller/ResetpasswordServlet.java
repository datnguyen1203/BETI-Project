/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAOs.UserDAO;
import Modals.User;
<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
<<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
import Ultis.Helper;
========
>>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/UserController.java
=======
import Ultis.Helper;
>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/ResetpasswordServlet.java
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
=======
>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/ResetpasswordServlet.java

/**
 *
 * @author nhvie
 */
<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
<<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
public class ResetpasswordServlet extends HttpServlet {
========
public class UserController extends HttpServlet {
>>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/UserController.java
=======
public class ResetpasswordServlet extends HttpServlet {
>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/ResetpasswordServlet.java

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
<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
<<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
            request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
========
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
>>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/UserController.java
=======
            request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/ResetpasswordServlet.java
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
<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
<<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
        processRequest(request, response);
    }

========
        String path = request.getRequestURI();
        if (path.startsWith("/Beti-shop/User/Edit")) {
            String[] s = path.split("/");
            String id = s[s.length - 1];
            UserDAO dao = new UserDAO();
            User u = dao.GetUserId(id);

            if (u == null) {
                response.sendRedirect("/Beti-shop");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("thongtinnguoidung", u);
                request.getRequestDispatcher("/userInformation.jsp").forward(request, response);
            }
        }
    }

>>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/UserController.java
=======
        processRequest(request, response);
    }

>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/ResetpasswordServlet.java
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
<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
<<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
=======
>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/ResetpasswordServlet.java
        String email = request.getParameter("email").trim();
        UserDAO udao = new UserDAO();
        User user = udao.GetUser(email);
        if (user != null) {
            String newpass = Helper.getAlphaNumericString(8);
            Helper.send(email, "Reset Password", "New Password for your account is " + newpass);
            String hashPassword = Helper.hashPassword(newpass, "MD5");
            udao.updatePassword(email, hashPassword);
            request.setAttribute("report", "New Password is sent to email. Please check email to receive new password");
        } else {
            request.setAttribute("email", email);
            request.setAttribute("error", "Email not registered");
        }
        doGet(request, response);
<<<<<<< HEAD:F-Store/src/main/java/Controller/ResetpasswordServlet.java
========
        if (request.getParameter("editbtn") != null && request.getParameter("editbtn").equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("emailedit");
            String name = request.getParameter("usernameedit");
            Date DOB = Date.valueOf(request.getParameter("birthdayedit"));
            String phone = request.getParameter("phoneedit");
            String address = request.getParameter("addressedit");

            User u = new User(id, email, name, DOB, phone, address);
            UserDAO dao = new UserDAO();
            int result = dao.Update(u);
            if (result != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("thongtinnguoidung", u);
                request.setAttribute("thongBaoCapNhat", "Chỉnh sửa thành công.");
                request.getRequestDispatcher("/userInformation.jsp").forward(request, response);
            } else {
                request.setAttribute("thongBaoCapNhat", "Chỉnh sửa không thành công, vui lòng thử lại.");
                request.getRequestDispatcher("/userInformation.jsp").forward(request, response);
            }
        }

        if (request.getParameter("changepassbtn") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            String newpass = request.getParameter("newpass");
            String alertMess = "";
            User u = new User(id, newpass);
            UserDAO dao = new UserDAO();
            int result = dao.UpdatePassword(u);
            if (result != 0) {
                alertMess = "Thay đổi thành công, mời bạn đăng nhập lại.";
                request.setAttribute("alertMess1", alertMess);
                response.sendRedirect("/Beti-shop/Login");
            } else {
                alertMess = "Thay đổi thất bại, mời bạn thử lại!";
                request.setAttribute("alertMess", alertMess);
                request.getRequestDispatcher("/userInformation.jsp").forward(request, response);
            }

        }
>>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/UserController.java
=======
>>>>>>> d48a67e6cf14d14948dc1c4d1c92b60f01ea8a5f:Beti-shop/src/main/java/Controller/ResetpasswordServlet.java
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
