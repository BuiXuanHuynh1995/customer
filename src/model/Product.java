package model;

public class Product {
    private int id;
    private String name;
    private int category_id;
    private String category_name;

    public Product() {
    }

    public Product(String name, String category_name) {
        this.name = name;
        this.category_name = category_name;
    }

    public Product(int id, String name, String category_name) {
        this.id = id;
        this.name = name;
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
