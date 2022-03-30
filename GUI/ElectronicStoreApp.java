import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class ElectronicStoreApp extends Application {

    ElectronicStore model;
    ElectronicStoreView view;

    public void start(Stage primaryStage) {

        model = ElectronicStore.createStore();
        view = new ElectronicStoreView(model);
        model.initStock();
        model.initMostPop();
        model.fullStockCopy = (ArrayList<Product>) model.fullStock.clone();

        primaryStage.setTitle("Electronic Store App - " + model.getName());
        primaryStage.setScene(new Scene(view, 800, 400));
        primaryStage.show();
        primaryStage.setResizable(false);

        view.update();

        view.getResetStore().setOnAction(e -> {
            view.getResetStore().getScene().getWindow().hide();
            start(primaryStage);
        });
        view.getRemoveFromCart().setOnAction(e -> handleRemoveFromCart());
        view.getCompleteSale().setOnAction(e -> handleCompleteSale());
        view.getAddToCart().setOnAction(e -> handleAddToCart());
        view.getStockView().setOnMouseReleased(e -> handleStockListSelection());
        view.getCartView().setOnMouseReleased(e -> handleCartListSelection() );
    }

    public void handleAddToCart(){
        Product selected = view.getStockView().getSelectionModel().getSelectedItem();
        int tempQuant = selected.getStockQuantity();
        if(tempQuant>0) {
            model.cart.add(selected);
            selected.setStockQuantity(selected.getStockQuantity()-1);
            view.curCart+=selected.getPrice();
        }
        model.fullStock.removeIf(product -> product.getStockQuantity() == 0);
        view.update();

    }
    public void handleRemoveFromCart(){
        Product selected = view.getCartView().getSelectionModel().getSelectedItem();
        if (selected.getStockQuantity()==0){
            model.fullStock.add(selected);
        }
        int stockQuantity = selected.getStockQuantity();
        int soldQuantity = selected.getSoldQuantity();
        selected.setStockQuantity(stockQuantity + 1);
        selected.setSoldQuantity(soldQuantity - 1);
        model.cart.remove(selected);
        view.curCart-=selected.getPrice();
        view.update();
    }
    public void handleCompleteSale(){
        model.sellCart();
        model.revenue += view.curCart;
        view.curCart = 0;
        model.totSalesQuantity+=1;
        model.avgSales = (model.getRevenue()/model.totSalesQuantity);
        model.cart.clear();
        model.mostPop.clear();
        Collections.sort(model.fullStockCopy);
        model.setMostPop();
        view.update();
    }
    public void handleStockListSelection(){
        view.update();
    }
    public void handleCartListSelection(){
        view.update();
    }

    public static void main(String[] args){
        launch(args);
    }
}
