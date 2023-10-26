package Controller;

import DAOs.UserDAO;
import Modals.User;
import Ultis.Common;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/admin/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String dob = request.getParameter("dob");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.GetUser(email);
        String report = "";
        if(user == null){
            userDAO.addUser(email,name,phone,address, Common.convertStringtoDate(dob),password);
            report = "addsuccess";
        }
        else {
            report = "addfailed";
        }
        response.sendRedirect("/Admin/listuser?report="+report);
    }
}
