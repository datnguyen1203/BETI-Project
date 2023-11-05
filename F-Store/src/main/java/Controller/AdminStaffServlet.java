package Controller;

import DAOs.StaffDAO;
import DAOs.UserDAO;
import Modals.Staff;
import Modals.User;
import Ultis.Common;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminStaffServlet", value = "/admin/liststaff")
public class AdminStaffServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        String report = request.getParameter("report");
        int pagenum = request.getParameter("pagenum") != null ? Integer.parseInt(request.getParameter("pagenum")) : 1;
        StaffDAO staffDAO = new StaffDAO();
        List<Staff> list = staffDAO.getAllUsers();
        int totalPage = list.size() % 5 == 0 ? (list.size() / 5) : (list.size() / 5 + 1);
        List<User> pagingList = Common.pagination(list, 5, pagenum);
        request.setAttribute("list", pagingList);
        request.setAttribute("totalpage", totalPage);
        request.setAttribute("pagenum", pagenum);
        request.setAttribute("report", report);
        request.setAttribute("mana", 0);
        request.getRequestDispatcher("/AdminStaffManager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
