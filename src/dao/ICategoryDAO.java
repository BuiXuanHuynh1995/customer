package dao;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO {
    public List<Category> findAll();

    public void addCategory(Category category) throws SQLException;

    public boolean update(int id,Category category) throws SQLException;

    public boolean delete(int id) throws SQLException;
}
