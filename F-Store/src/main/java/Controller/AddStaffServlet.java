package Controller;

import DAOs.StaffDAO;
import Modals.Staff;
import Ultis.Common;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddStaffServlet", value = "/admin/addStaff")
public class AddStaffServlet extends HttpServlet {
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
        StaffDAO staffDAO = new StaffDAO();
        Staff staff = staffDAO.GetStaff(email);
        String report = "";
        if(staff == null){
            staffDAO.addStaff(email,name,phone,address, Common.convertStringtoDate(dob),password);
            report = "addsuccess";
        }
        else {
            report = "addfailed";
        }
        response.sendRedirect("liststaff");
    }
}
