import java.util.Scanner;

public class ElectronicStore {
    private String name;
    private final int MAX_PRODUCTS = 10;
    private  double revenue = 0;
    private Product[] products = new Product[MAX_PRODUCTS];

    ElectronicStore(String name) {
        this.name = name;
    }

    String getName(){
        return name;
    }

    void addProduct(Product p){
        for (int i=0; i<products.length; i++) {
            if (products[i] == null) {
                products[i] = p;
                break;
            }
        }
    }
    void sellProducts(){
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Please enter which product you would like to sell: ");
            int item = input.nextInt();
            System.out.println("Please enter how many units of this product you would like to sell: ");
            int amount = input.nextInt();
            if (item<=MAX_PRODUCTS) {
                if ((products[item] != null) && (products[item].getStockQuantity() >= amount) && (amount >= 0)) {
                    revenue += products[item].sellUnits(amount);
                }
            }
        }
    }
    void sellProducts(int item, int amount){

        if (item<=MAX_PRODUCTS) {
            if ((products[item] != null)&&(products[item].getStockQuantity()>=amount)&&(amount>0)) {
                revenue += products[item].sellUnits(amount);
            }
        }
    }
    double getRevenue(){
        return revenue;
    }
    void printStock(){
        for (int i=0; i<products.length; i++){
            if (products[i]!=null) {
                System.out.print(i+". "+products[i]);
            }
        }
    }
}