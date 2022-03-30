
public abstract class Appliance extends Product{
    private String colour;
    private String brand;
    private int wattage;

    //getters for toString functions
    public String getColour() {
        return colour;
    }
    public String getBrand() {
        return brand;
    }
    public int getWattage() {
        return wattage;
    }

    public Appliance(double price, int stockQuantity, int wattage, String colour, String brand){
        super(price, stockQuantity);
        this.wattage  = wattage;
        this.colour = colour;
        this.brand = brand;
    }
}

