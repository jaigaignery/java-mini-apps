
public class Laptop extends Computer{
    private double screenSize;

     public Laptop(double price, int stockQuantity, double cpuSpeed, int ram, boolean ssd, int storage, double screenSize) {
         super(price, stockQuantity, cpuSpeed, ram, ssd, storage);
         this.screenSize = screenSize;
    }

    public String toString(){
        String ssdT=String.valueOf(isSsd());
        if (ssdT.equals("true")){
            ssdT = "SSD";
        }else{
            ssdT = "HDD";
        }
        return screenSize+" inch laptop PC with a "+getCpuSpeed()+"GHz processor, "+getRam()+"GB of RAM, and "+getStorage()+"GB of "+ssdT+" storage. ("+getPrice()+" dollars per unit, "+getStockQuantity()+" units in stock, "+getSoldQuantity()+" units sold)\n";
    }
}