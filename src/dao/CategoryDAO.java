package dao;

import db.DBConnect;
import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    @Override
    public List<Category> findAll() {
        List<Category> list=new ArrayList<>();
        try(Connection connection= DBConnect.getConnection();
            PreparedStatement statement=connection.prepareStatement("select * from category")) {
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                Category category=new Category(id,name);
                list.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addCategory(Category category) throws SQLException {

    }

    @Override
    public boolean update(int id, Category category) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}
