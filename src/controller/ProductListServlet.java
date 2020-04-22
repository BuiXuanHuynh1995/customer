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
import java.util.List;

@WebServlet(name = "ProductListServlet",urlPatterns = "/productList")
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    public void init() {
        productDAO= new ProductDAO();
    }

    public ProductListServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = null;
        list = productDAO.findAll();

        request.setAttribute("productList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/productList.jsp");
        dispatcher.forward(request, response);
    }
}
