package controller;

import dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    public void init() {
        productDAO= new ProductDAO();
    }

    public DeleteProductServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String errorString = null;

        try {
            productDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        if (errorString != null) {
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/deleteProductError.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }
}
