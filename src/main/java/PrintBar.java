
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PrintBar {

    private TableView table = new TableView();

    public Scene getScene2(){

        //WestminsterMusicStoreManager newobj = new WestminsterMusicStoreManager();
        //for(MusicItem item : newobj.getStoreItem()){
        //    System.out.println(item);
        //}

        Scene scene22 = new Scene(new VBox(),1000,500);

        Label label = new Label("Westminster Music Store");
        label.setFont(new Font("Arial", 30));

        table.setEditable(true);

        VBox vbox = new VBox();    //Vertical Box
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10, 20, 0, 20));
        vbox.getChildren().addAll(label, table);

        //A table can be seen built accordingly.

        TableColumn itemId = new TableColumn("ITEM ID");
        itemId.setMinWidth(100);

        TableColumn theTitle = new TableColumn("TITLE");
        theTitle.setMinWidth(100);

        TableColumn theGenre = new TableColumn("GENRE");
        theGenre.setMinWidth(100);

        TableColumn theRD = new TableColumn("RELEASE DATE");
        theRD.setMinWidth(100);

        TableColumn theArtist = new TableColumn("ARTIST");
        theArtist.setMinWidth(100);

        TableColumn thePrice = new TableColumn("PRICE");
        thePrice.setMinWidth(100);

        TableColumn theType = new TableColumn("TYPE");
        theType.setMinWidth(100);

        TableColumn theDuration = new TableColumn("DURATION");
        theDuration.setMinWidth(100);

        TableColumn theSpeed = new TableColumn("SPEED");
        theSpeed.setMinWidth(100);

        TableColumn theDiameter = new TableColumn("DIAMETER");
        theDiameter.setMinWidth(100);


        table.getColumns().addAll(itemId, theTitle, theGenre, theRD, theArtist, thePrice, theType, theDuration, theSpeed, theDiameter);

        VBox root = (VBox) scene22.getRoot();
        root.getChildren().addAll(table);



        return scene22;
    }

}
