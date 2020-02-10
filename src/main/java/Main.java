
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    static WestminsterMusicStoreManager managerOb = new WestminsterMusicStoreManager();   //Object Created of class westminster
    static Scanner input = new Scanner(System.in);

    MongoClient mongoClient = (MongoClient) new com.mongodb.MongoClient("local host",27017);  //Mongodb is added
    MongoDatabase mongoDB = mongoClient.getDatabase("MusicDatabase");
     MongoCollection<Document> itemCollection = mongoDB.getCollection("itemCollection");



    public static void main(String[] args) {
        System.out.println("\n*****  Welcome to Westminster Music Store Manager  *****");
        mainMenu();
    }

    private static void mainMenu() {
        int choose;
        do {                                                                        //do while is used
            System.out.println("\nSelect Option: ");
            System.out.println("  1) Add a new item");
            System.out.println("  2) Delete an item");
            System.out.println("  3) Print the list of items");
            System.out.println("  4) Sort the item ");
            System.out.println("  5) Buy an item ");
            System.out.println("  6) Generate a report ");
            System.out.println("  7) Search items");
            System.out.print(">");
            choose = intValidator();   //method is declared to identify non-numeric characters

            switch (choose) {         //switch allows to check each and every case
                case 1:
                    addItems();
                    break;

                case 2:
                    deleteItem();
                    break;

                case 3:
                    managerOb.printList();
                    mainMenu();
                    break;

                case 4:
                    sortItems();
                    break;

                case 5:
                    buyItem();
                    break;

                case 6:
                    generateReport();
                    managerOb.generateReport();
                    break;

                case 7:
                    managerOb.searchItem();
                    mainMenu();
                    break;

                default:
                    System.out.println("Invalid option. Re-enter!!!");

            }

        } while (choose < 1 || choose > 7);             //while choice is less than 1 or more than 4
    }

    private static int intValidator() {    //provide an error message for a non-numeric
        while (!input.hasNextInt()) {                                       ///when not interpreted as an integer
            System.out.println("Please enter a numeric value!! Re-enter!");
            System.out.print(">");
            input.next(); //to clean the value
        }
        return input.nextInt();
    }

    private static BigDecimal bigDValidator() {    //Input Validation for Big Decimal
        while (!input.hasNextBigDecimal()) {
            System.out.println("Please enter a numeric value!! Re-enter!");
            System.out.print(">");
            input.next(); //to clean the value
        }
        return input.nextBigDecimal();
    }

    private static double doubleValidator() {      //Input Validation for Double
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a numeric value!! Re-enter!");
            System.out.print(">");
            input.next(); //to clean the value
        }
        return input.nextDouble();
    }


    private static void addItems() {        //Add items method

        System.out.println("Enter item ID: ");
        String itemID = input.next();
        for(MusicItem item : managerOb.getStoreItem()){
            if(item.getItemID().equals(itemID)){         //Check whether the item already exists using equals
                System.out.println("Item Id already exists!!");
                addItems();

                //Document doc = Main.addItems(itemCollection).append("id", itemID);
                //itemCollection.insertOne(doc);

            }else {
                continue;
            }
        }

        System.out.println("Enter item title: ");
        String title = input.next();

        System.out.println("Enter item genre: ");
        String genre = input.next();

        System.out.println("Enter item artist: ");
        String artist = input.next();

        System.out.println("Enter release date: ");
        int releaseDate = intValidator();

        System.out.println("Enter the price: ");
        BigDecimal price = bigDValidator();   //Big decimal is validated

        //Document doc = Main.addItems(itemCollection)
        // .append("title", title)
        // .append("genre", genre)
        // .append("artist", artist)
        // .append("releaseDate", date)
        // .append("price", price)
        //itemCollection.insertOne(doc);

        int type;
        do {
            System.out.println("Enter the type:   1)CD   2)Vinyl");
            type = intValidator();

            if (type == 1) {
                System.out.println("Enter the duration: ");
                int duration = intValidator();
                System.out.println("\n Item is successfully added!!!!!");

                MusicItem item = new CD(itemID, title, genre, releaseDate, artist, price, duration);  //the following taken from music item
                try {
                    managerOb.addNewItem(item);    //info gets added to the array list
                } catch (StoreFullException e) {
                    e.printStackTrace();
                }
                mainMenu();  //Directed to the main menu

            } else if (type == 2) {
                System.out.println("Enter the diameter: ");
                double diameter = doubleValidator();

                System.out.println("Enter the speed: ");
                double speed = doubleValidator();
                System.out.println("\n Item is successfully added!!!!!");

                MusicItem item = new Vinyl(itemID, title, genre, releaseDate, artist, price, speed, diameter);
                try {
                    managerOb.addNewItem(item);
                } catch (StoreFullException e) {
                    e.printStackTrace();
                }
                mainMenu();
            } else {
                System.out.println("Invalid option.Re-enter!!!");
            }
        }while (type < 1 || type > 2 );


    }

    private static void deleteItem(){      //Delete item method

        System.out.println("Enter item ID :");
        String itemID=input.next();
        for(MusicItem item : managerOb.getStoreItem()){   //Enhanced for loop is used
            if(item.getItemID().equals(itemID)){          //Check whether the item matches with the ID
                managerOb.deleteItem(item);
                System.out.println("Item is deleted Successfully!!");
                mainMenu();
            }else {
                System.out.println("Item is not Found!!");
                mainMenu();
            }
        }
    }

    private static void sortItems(){
        managerOb.sortItem();    //Get sorted from the WestminsterMusicStoreManager
        mainMenu();
    }

    private static void buyItem(){

        System.out.println("Enter Item ID : ");
        String buyID = input.next();
        for (MusicItem item : managerOb.getStoreItem()){

            if(item.getItemID().equals(buyID)){                     //Check whether the item matches with the ID

                try {
                    managerOb.buyItem(item);
                    System.out.println("Item Bought successfully!!");
                    mainMenu();
                } catch (StoreItemNotFoundException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("ItemId you entered is not available!!");
            }
        }mainMenu();

    }

    private static void generateReport(){

        System.out.println("Items Bought :");
        for(MusicItem item: managerOb.getBoughtItem()){   //If items are bought only the it will generate the report
            System.out.println(item);

        }mainMenu();
    }



}