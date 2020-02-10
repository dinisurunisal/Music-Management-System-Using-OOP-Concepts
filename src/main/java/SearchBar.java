import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SearchBar {
    public Scene getScene(){

        Scene scene1 = new Scene(new VBox(),1000,500);


        VBox vBox2 = new VBox();                        //Vertical Box
        vBox2.setPadding(new Insets(60, 50, 50, 50));
        vBox2.setSpacing(40);

        HBox hBox2 = new HBox();                        //Horizontal Box
        hBox2.setPadding(new Insets(50));
        hBox2.setSpacing(20);


        GridPane pane = new GridPane();   //Grid pane is used to keep in line the label and the field box
        pane.setAlignment(Pos.BOTTOM_CENTER);
        pane.setVgap(4);
        pane.setHgap(10);
        pane.setPadding(new Insets(150,25,25,25));

        Label name = new Label ("Enter the item to be searched:");
        name.setFont(Font.font("Arial",30));
        pane.add(name,0,0);
        TextField nameField = new TextField();
        nameField.setFont(Font.font("Arial",30));
        pane.add(nameField,1 , 0);

        Button button = new Button("Proceed");
        button.setFont(Font.font("Castellar",30));
        pane.add(button, 1, 10);


        VBox root = (VBox) scene1.getRoot();
        root.getChildren().addAll(pane);



        return scene1;
    }
}
