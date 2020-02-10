import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InterfaceMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        //This is displayed as the the first Sight of the user. User can select print and search from this.

        VBox vBox = new VBox();                 //Vertical Box
        vBox.setPadding(new Insets(60, 50, 50, 50));
        vBox.setSpacing(40);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(50));
        hBox.setSpacing(40);                     //Horizontal Box

        Label label = new Label("Welcome!!");
        label.setFont(Font.font("Ravie",100));

        label.setTextFill(Color.web("#FFFFFF"));

        Button btn1 = new Button("Search");
        Button btn2 = new Button("Print");
        btn1.setFont(Font.font("Castellar",30));

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {   //Actions taken to direct th the Search option

                // change scenes here
                changeScenes();
            }
        });


        btn2.setFont(Font.font("Castellar",30));

        btn2.setOnAction(new EventHandler<ActionEvent>() {    //Actions taken to direct th the Search option
            @Override
            public void handle(ActionEvent actionEvent) {

                // change scenes here
                changeScenes2();
            }
        });
        hBox.setAlignment(Pos.BASELINE_CENTER);    //Position of the horizontal box


        vBox.setAlignment(Pos.TOP_CENTER);     //Position of the vertical box
        hBox.getChildren().addAll(btn1,btn2);
        vBox.getChildren().addAll(label,hBox);

        Scene scene = new Scene(vBox, 1000, 500);


        BackgroundFill background_fill = new BackgroundFill(Color.DARKSLATEBLUE,        // create background fill
                CornerRadii.EMPTY, Insets.EMPTY);



        Background background = new Background(background_fill);        // create a Background


        vBox.setBackground(background);         // set a background

        primaryStage.setTitle("Hello World Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void changeScenes()    //Change scenes when button is clicked
    {
        SearchBar ci = new SearchBar();
        Scene scene = ci.getScene();

        // set new title
        primaryStage.setTitle("Search Bar");

        // change the scene on the stage
        primaryStage.setScene(scene);



    }

    private void changeScenes2(){   //Change scenes when button is clicked

        PrintBar su = new PrintBar();
        Scene scene2 = su.getScene2();

        // set new title
        primaryStage.setTitle("Print Bar");

        primaryStage.setScene(scene2);
    }
}
