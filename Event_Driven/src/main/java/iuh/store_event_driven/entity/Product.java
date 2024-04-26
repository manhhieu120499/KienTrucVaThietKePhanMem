package iuh.store_event_driven.entity;
public class Product {
    private String title;
    private String brand;
    private String mainImageUrl;
    private int ratingsTotal;
    private double rating;
    private Price price;

    public Product() {
    }

    public Product(String title, String brand, String mainImageUrl, int ratingsTotal, double rating, Price price) {
        this.title = title;
        this.brand = brand;
        this.mainImageUrl = mainImageUrl;
        this.ratingsTotal = ratingsTotal;
        this.rating = rating;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }

    public int getRatingsTotal() {
        return ratingsTotal;
    }

    public void setRatingsTotal(int ratingsTotal) {
        this.ratingsTotal = ratingsTotal;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", mainImageUrl='" + mainImageUrl + '\'' +
                ", ratingsTotal=" + ratingsTotal +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
