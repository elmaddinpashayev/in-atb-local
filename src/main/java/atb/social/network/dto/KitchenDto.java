package atb.social.network.dto;

public class KitchenDto {

    private String name;
    private String category;
    private Double price;

    public KitchenDto(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public KitchenDto() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public KitchenDto(String name, String category, Double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
