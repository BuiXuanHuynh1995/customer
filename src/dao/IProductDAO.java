package dao;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public List<Product> findAll();

    public void addProduct(Product product) throws SQLException;

    public boolean update(int id,Product product) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public List<Product> findByCategoryId(int category_id);
}
