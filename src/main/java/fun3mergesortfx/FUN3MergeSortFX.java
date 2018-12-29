package fun3mergesortfx;

import algorithm.MergeSortLogic;
import algorithm.Offer;
import algorithm.OfferList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FUN3MergeSortFX extends Application {

    private Label sortingTimeLabel;
    private String compareSelectedMethod;
    private String getSelectedMethod;
    ListView<Offer> list = new ListView<>();
    ComboBox<ComboBoxOption> comboBox;
    private MergeSortLogic logic = new MergeSortLogic();

    @Override
    public void start(Stage primaryStage) throws Exception {
        //#region Grid pane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        //#endregion

        //#region Label for displaying sorting time
        sortingTimeLabel = new Label("Sorting duration: 0 ms");
        grid.add(sortingTimeLabel, 1, 1);
        //#endergion

        //#region List that displays the results
        list.setPrefHeight(600);
        list.setPrefWidth(300);
        ObservableList<Offer> offers = FXCollections.observableArrayList(logic.TopDownMergeSort(OfferList.offerList, "checkDouble", "getPrice"));
        list.setItems(offers);
        listCellFactory();
        grid.add(list, 1, 3);
        //#endergion

        //#region Combo box that applies the chosen filter
        ObservableList<ComboBoxOption> options =
                FXCollections.observableArrayList(
                        new ComboBoxOption("Price", "checkDouble", "getPrice"),
                        new ComboBoxOption("Item Id", "checkInt", "getItemId"),
                        new ComboBoxOption("Sender Id", "checkInt", "getSenderId")
                );
        comboBox = new ComboBox<>(options);
        comboBoxCellFactory();
        comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            compareSelectedMethod = newValue.getCompareMethodName();
            getSelectedMethod = newValue.getGetMethodName();
            comboBoxCellFactory();
        });
        grid.add(comboBox, 5, 1);
        //#endregion

        //#region Button to begin sort
        Button sortButton = new Button();
        sortButton.setText("Sort");
        sortButton.setOnAction(this::beginSorting);
        grid.add(sortButton, 6, 1);
        //#endregion

        // Create the scene and add the grid pane
        Group root = new Group();
        Scene scene = new Scene(root, 530, 730);
        root.getChildren().add(grid);

        // Define title and assign the scene for main window
        primaryStage.setTitle("Merge sort algorithm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void beginSorting(ActionEvent event){
        //call sorting methods
        if(compareSelectedMethod != null && !compareSelectedMethod.equals("") && getSelectedMethod != null && !getSelectedMethod.equals("")){
            ObservableList<Offer> offers = FXCollections.observableArrayList(logic.TopDownMergeSort(OfferList.offerList, compareSelectedMethod, getSelectedMethod));
            list.setItems(offers);
            listCellFactory();
        }
    }

    private void comboBoxCellFactory(){
        comboBox.setCellFactory(param -> new ListCell<ComboBoxOption>(){
            @Override
            protected void updateItem(ComboBoxOption option, boolean empty){
                super.updateItem(option, empty);

                if (empty || option == null || option.getText() == null) {
                    setText(null);
                } else {
                    setText(option.getText());
                }
            }
        });
        comboBox.setButtonCell(new ListCell<ComboBoxOption>(){
            @Override
            protected void updateItem(ComboBoxOption option, boolean empty){
                super.updateItem(option, empty);
                if (empty || option == null || option.getText() == null) {
                    setText(null);
                } else {
                    setText(option.getText());
                }
            }
        });
    }

    private void listCellFactory(){
        list.setCellFactory(param -> new ListCell<Offer>(){
            @Override
            protected void updateItem(Offer offer, boolean empty){
                super.updateItem(offer, empty);

                if (empty || offer == null || offer.getPrice() == null) {
                    setText(null);
                } else {
                    setText(offer.getPrice().toString());
                }
            }
        });
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
