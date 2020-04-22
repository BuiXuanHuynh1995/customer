package controller;

import dao.ProductDAO;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateProductServlet",urlPatterns = "/createProduct")
public class CreateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    public void init() {
        productDAO= new ProductDAO();
    }

    public CreateProductServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String category_name= (String) request.getParameter("category_name");
        Product product = new Product(name,category_name);
        try {
            productDAO.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("product", product);


            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/createProduct.jsp");
            dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/createProduct.jsp");
        dispatcher.forward(request, response);
    }

}
