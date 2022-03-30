import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;

public class ElectronicStoreView extends Pane{

    private final Button removeFromCart;
    private final Button addToCart;
    private final Button resetStore;
    private final Button completeSale;
    private TextField numSalesText;
    private TextField dollarsPerSaleText;
    private TextField revenueText;
    private ListView<Product> cartView;
    private ListView<Product> stockView;
    private ListView<Product> mostPopView;
    Label currentCart;
    ElectronicStore model;
    public double curCart;

    public Button getRemoveFromCart() {
        return removeFromCart;
    }
    public Button getAddToCart() {
        return addToCart;
    }
    public Button getResetStore() {
        return resetStore;
    }
    public Button getCompleteSale() {
        return completeSale;
    }
    public ListView<Product> getCartView() {
        return cartView;
    }
    public ListView<Product> getStockView() {
        return stockView;
    }
    public ListView<Product> getMostPopView() {
        return mostPopView;
    }

    public ElectronicStoreView(ElectronicStore model){
        this.model = model;

        addToCart = new Button("Add to Cart");
        addToCart.relocate(330,340);
        addToCart.setPrefSize(100,50);

        removeFromCart = new Button("Remove from Cart");
        removeFromCart.relocate(530,340);
        removeFromCart.setPrefSize(100,50);

        completeSale = new Button("Complete Sale");
        completeSale.relocate(650,340);
        completeSale.setPrefSize(100,50);

        resetStore = new Button("Reset Store");
        resetStore.relocate(30,340);
        resetStore.setPrefSize(100,50);

        curCart = 0;

        addToCart.setDisable(true);
        completeSale.setDisable(true);
        removeFromCart.setDisable(true);

        final Label storeSummary = new Label("Store Summary:");
        storeSummary.relocate(20,10);

        final Label numSales = new Label("# of Sales:");
        numSales.relocate(20,40);

        final Label revenue = new Label("Revenue:");
        revenue.relocate(20,70);

        final Label dollarsPerSale = new Label("$/Sale:");
        dollarsPerSale.relocate(20,100);

        final Label mostPop = new Label("Most Popular Items:");
        mostPop.relocate(20,130);

        final Label storeStock = new Label("Store Stock:");
        storeStock.relocate(350,10);

        currentCart = new Label("Current Cart: ($"+curCart+")");
        currentCart.relocate(600,10);

        stockView = new ListView<>();
        stockView.relocate(260, 40);
        stockView.setPrefSize(250,300);

        cartView = new ListView<>();
        cartView.relocate(515, 40);
        cartView.setPrefSize(250,300);

        mostPopView = new ListView<>();
        mostPopView.relocate(20, 160);
        mostPopView.setPrefSize(235,180);

        numSalesText = new TextField();
        numSalesText.relocate(80, 40);
        numSalesText.setPrefSize(100,25);

        revenueText = new TextField();
        revenueText.relocate(76, 70);
        revenueText.setPrefSize(100,25);

        dollarsPerSaleText = new TextField();
        dollarsPerSaleText.relocate(66, 100);
        dollarsPerSaleText.setPrefSize(100,25);

        numSalesText.setText("0");
        dollarsPerSaleText.setText("N/A");
        revenueText.setText("0");


        getChildren().addAll(addToCart, removeFromCart, completeSale, resetStore,
                                    storeSummary, revenue, numSales, dollarsPerSale, mostPop,
                                    storeStock, currentCart, stockView, cartView, mostPopView,
                                    dollarsPerSaleText, revenueText, numSalesText);
    }

    public void update(){
        stockView.setItems(FXCollections.observableArrayList(model.fullStock));
        cartView.setItems(FXCollections.observableArrayList(model.cart));
        mostPopView.setItems(FXCollections.observableArrayList(model.mostPop));
        currentCart.setText("Current Cart: ($"+curCart+")");
        numSalesText.setText(String.valueOf(model.totSalesQuantity));
        revenueText.setText(String.valueOf(model.revenue));
        dollarsPerSaleText.setText(String.valueOf(model.avgSales));

        if(stockView.getSelectionModel().getSelectedIndex()<0){
            addToCart.setDisable(true);
        }else{
            addToCart.setDisable(false);
        }

        if(cartView.getSelectionModel().getSelectedIndex()<0){
           removeFromCart.setDisable(true);
        }else{
            removeFromCart.setDisable(false);
        }

        if(model.cart.size()<1){
            completeSale.setDisable(true);
        }else{
            completeSale.setDisable(false);
        }
    }
}

