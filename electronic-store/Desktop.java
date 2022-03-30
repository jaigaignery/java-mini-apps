
public class Desktop extends Computer{
    private String profile;

    public Desktop(double price, int stockQuantity, double cpuSpeed, int ram, boolean ssd, int storage, String profile) {
        super(price, stockQuantity, cpuSpeed, ram, ssd, storage);
        this.profile = profile;
    }
    public String toString(){
        String ssdT=String.valueOf(isSsd());
        if (ssdT.equals("true")){
            ssdT = "SSD";
        }else{
            ssdT = "HDD";
        }
        return profile+" Desktop PC with a "+getPrice()+"GHz processor, "+getRam()+"GB of RAM, and "+getStorage()+"GB of "+ssdT+" storage. ("+getPrice()+" dollars per unit, "+getStockQuantity()+" units in stock, "+getSoldQuantity()+" units sold)\n";
    }
}
