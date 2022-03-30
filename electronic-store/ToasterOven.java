
public class ToasterOven extends Appliance {
    private int width;
    private boolean convection;

    public ToasterOven(double price, int stockQuantity, int wattage, String colour, String brand, int width, boolean convection) {
        super(price, stockQuantity, wattage, colour, brand);
        this.width = width;
        this.convection = convection;
    }

    public String toString() {
        String convectionT = String.valueOf(this.convection);
        if (convectionT.equals("true")) {
            convectionT = " with convection";
        } else {
            convectionT = "";
        }
        return width+" inch "+getBrand()+" toaster oven"+convectionT+" ("+getColour()+", "+getWattage()+" watts) ("+getPrice()+" dollars each, "+getStockQuantity()+" in stock, "+getSoldQuantity()+" sold)\n";
    }
}
