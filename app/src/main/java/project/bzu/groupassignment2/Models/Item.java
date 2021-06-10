package project.bzu.groupassignment2.Models;

import project.bzu.groupassignment2.R;

public class Item {
    private String name;
    private Double price;
    private String rating;
    private int quantity;
    private int imageID;
    public static final Item[] items={
            new Item("Franklin Sports Grip-Rite 100 Rubber Junior Football",4.88,"5", R.drawable.football),
            new Item("FC Barcelona Home Jersey 2020/21 (Nike)",64.96,"4", R.drawable.barcelona_kit),
            new Item("F.C. Barcelona 2020/21 Stadium Goalkeeper Shorts",28.47,"3", R.drawable.barcelona_shorts),
            new Item("METIS NEOPRENE HEX DUMBBELLS X2 [1LB-22LBS] - PAIR",29.99,"2", R.drawable.dumbells),
            new Item("Adidas Running Shoes (Black)",61.9,"1", R.drawable.shoes),
    };
    public Item() {
    }

    public Item(String name, Double price, int quantity, int imageID) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageID = imageID;
    }

    public Item(String name, Double price, String rating, int imageID) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.imageID = imageID;
    }

    public Item(String name, Double price, String rating, int quantity, int imageID) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.quantity = quantity;
        this.imageID = imageID;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
    public double getTotalBeforeTax(){
        return price*quantity;

    }
    public double getTotalAfterTax(){
        return  (getTotalBeforeTax()*0.14)+getTotalBeforeTax();
    }
    @Override
    public String toString() {
        return "Item{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating='" + rating + '\'' +
                ", quantity=" + quantity +
                ", imageID=" + imageID +
                '}';
    }
}