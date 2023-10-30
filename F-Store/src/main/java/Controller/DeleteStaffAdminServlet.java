package Controller;

import DAOs.StaffDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteStaffAdminServlet", value = "/deleteStaff")
public class DeleteStaffAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        StaffDAO staffDAO = new StaffDAO();
        staffDAO.deleteStaffID(Integer.parseInt(id));
        response.sendRedirect("/admin/liststaff?report=delete");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
