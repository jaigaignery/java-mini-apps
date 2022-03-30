
public abstract class Product {
    private double price;
    private int stockQuantity;
    private int soldQuantity;

    //getters for toString functions
    public double getPrice() {
        return price;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public int getSoldQuantity() {
        return soldQuantity;
    }

    public Product(double price, int stockQuantity){
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    double sellUnits(int amount){
        double revenue = 0;
        revenue += amount * price;
        stockQuantity = stockQuantity - amount;
        soldQuantity+=amount;
        return revenue;
    }
}
