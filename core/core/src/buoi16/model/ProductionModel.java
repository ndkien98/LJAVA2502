package buoi16.model;

import java.util.List;

public class ProductionModel {

    private Integer id;
    private String name;
    private float price;
    private String description;
    private int total;

    List<ProductionDetailModel> detailModels;

    public void setDetailModels(List<ProductionDetailModel> detailModels) {
        this.detailModels = detailModels;
    }

    public List<ProductionDetailModel> getDetailModels() {
        return detailModels;
    }

    @Override
    public String toString() {
        return "ProductionModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", total=" + total +
                ", detailModels=" + detailModels +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
