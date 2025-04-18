package buoi16.model;

public class ProductionDetailModel {


    private Integer productionId;
    private String color;
    private String size;
    private String image;
    private int quality;

    @Override
    public String toString() {
        return "ProductionDetailModel{" +
                "productionId=" + productionId +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", image='" + image + '\'' +
                ", quality=" + quality +
                '}';
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
