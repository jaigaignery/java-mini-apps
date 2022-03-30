
//Got rid of sellProducts(), as I preferred to handle the selling of items in event handlers.
//Also, used ArrayLists instead of Arrays as they were much easier to deal with in terms
//of updating ListViews and selling items via indices. Hope that's okay! :)

import java.util.ArrayList;

public class ElectronicStore {
public final int MAX_PRODUCTS = 10; //Maximum number of products the store can have
private int curProducts;
        String name;
        Product[] stock;
        ArrayList<Product> fullStock;
        ArrayList<Product> fullStockCopy;
        ArrayList<Product> mostPop;
        ArrayList<Product> cart;
        double revenue;
        int totSalesQuantity;
        double cartAmount;
        double avgSales;

public ElectronicStore(String initName) {
        revenue = 0.0;
        name = initName;
        stock = new Product[MAX_PRODUCTS];
        fullStock = new ArrayList<>();
        mostPop = new ArrayList<>();
        cart = new ArrayList<>();
        curProducts = 0;
        cartAmount = 0;
        }

public String getName() {
        return name;
        }

public boolean addProduct(Product newProduct) {
        if (curProducts < MAX_PRODUCTS) {
        stock[curProducts] = newProduct;
        curProducts++;
        return true;
        }
        return false;
        }

public double getRevenue() {
        return revenue;
        }

public static ElectronicStore createStore() {
        ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
        Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
        Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
        Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
        Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
        Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
        Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
        ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
        ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        return store1;
        }

public void initStock() {
        for (Product product : stock) {
        if (product != null) {
        fullStock.add(product);
        }
        }
        }

public void initMostPop() {
        for (int i = 0; i < 3; i++) {
        if (fullStock.get(i) != null) {
        mostPop.add(fullStock.get(i));
        }
        }
        }

public void sellCart() {
        for (Product p : cart) {
        p.sellUnits(1);
        }
        }

public void setMostPop() {
        for (int i = 0; i <fullStockCopy.size()-1; i++) {
        if (mostPop.size()<3){
        mostPop.add(fullStockCopy.get(i));
        }
        }
        }
        }