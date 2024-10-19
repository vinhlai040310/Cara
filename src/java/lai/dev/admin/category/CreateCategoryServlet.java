/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package lai.dev.admin.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import lai.dev.admin.BaseAdminServlet;
import lai.dev.data.dao.CategoryDao;
import lai.dev.data.dao.DatabaseDao;
import lai.dev.data.dao.UserDao;
import lai.dev.data.model.Category;
import lai.dev.data.model.User;

/**
 *
 * @author Admin
 */
public class CreateCategoryServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("admin/category/create.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        HttpSession session = request.getSession();
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();

        if (name.isEmpty() || description.isEmpty()) {
            session.setAttribute("error", "Please fill in all the required information.");
            request.getRequestDispatcher("admin/category/create.jsp").include(request, response);
        } else {
            Category category = new Category(name, description);
            categoryDao.insert(category);
            response.sendRedirect("IndexCategoryServlet");
        }
    }
}
