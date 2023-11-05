package Controller;

import DAOs.UserDAO;
import Modals.User;
import Ultis.Common;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/admin/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.GetUser(email);
        if(user == null || user.getUserID() == Integer.parseInt(id)){
            userDAO.updateUser(Integer.parseInt(id),email,name,phone,address, Common.convertStringtoDate(dob));
        }
        else {
            request.getSession().setAttribute("error","Email existed!");
        }
        response.sendRedirect("/Admin/listuser");
    }
}
