
public class Fridge extends Appliance{
    private double cubicFeet;
    private boolean hasFreezer;

    public Fridge(double price, int stockQuantity, int wattage, String colour, String brand, double cubicFeet, boolean hasFreezer){
        super(price, stockQuantity, wattage, colour, brand);
        this.cubicFeet = cubicFeet;
        this.hasFreezer = hasFreezer;
    }
    public String toString(){
        String freeze=String.valueOf(hasFreezer);
        if (freeze.equals("true")){
            freeze = " with a freezer";
        }else{
            freeze = "";
        }

        return cubicFeet+" cu. ft. "+getBrand()+" fridge"+freeze+" ("+getColour()+", "+getWattage()+" watts) ("+getPrice()+" dollars each, "+getStockQuantity()+" in stock, "+getSoldQuantity()+" sold)\n";
    }
}