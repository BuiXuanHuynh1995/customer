package dao;

import db.DBConnect;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    @Override
    public List<Product> findAll() {
        List<Product> list=new ArrayList<>();
        try(Connection connection= DBConnect.getConnection();
        PreparedStatement statement=connection.prepareStatement("select product.id,product.name,category.name from product inner join category on product.category_id=category.id")) {
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String category=resultSet.getString(3);

                Product product=new Product(id,name,category);
                list.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        try (Connection connection= DBConnect.getConnection();
             PreparedStatement statement=connection.prepareStatement("insert into product values (?,?)")){
            statement.setString(1,product.getName());
            statement.setString(2,product.getCategory_name());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(int id, Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement("select product.name=?,category.name=? from product inner join category on product.category_id=category.id where id=?" );) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getCategory_name());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try( Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from product where id=?");) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Product> findByCategoryId(int category_id) {
        List<Product> list = new ArrayList<>();
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement("select product.id, product.name, country.name from product inner join country on product.category_id = category.id where product.category_id = ?");) {
            statement.setInt(1, category_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String category = resultSet.getString(3);

                Product product = new Product(id, name, category);
                list.add(product);
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        return list;
    }
}
