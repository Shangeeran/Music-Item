package shanga;

import com.sun.xml.internal.messaging.saaj.soap.SOAPDocumentFragment;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.bson.Document;

import javax.print.Doc;
import javax.smartcardio.Card;
import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Console extends Application {
    private static StoreManager storeManager;
    private static String args;

    public static void main(String[] args) {
        StoreManager availableStorage = new WestminsterMusicStoreManager();
        //Scanner for get the option
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("Free Storage  : "+ availableStorage.availableStorage());
            System.out.println("Welcome to Westminster Music Store");
            System.out.println("1 : Add Item");
            System.out.println("2 : Delete Item");
            System.out.println("3 : Print Items");
            System.out.println("4 : Sort Items");
            System.out.println("5 : Buy Items");
            System.out.println("6 : Generate Report");

            System.out.print("\t"+"Your Option is : ");
            // Stop strings when we enter Option
            while (!sc.hasNextInt()) {
                System.out.print("Invalid Entry!!, Please Select the Option : ");
                sc.next();
            }
            // Get the option from user assign to option variable
            option = sc.nextInt();

            storeManager = new WestminsterMusicStoreManager();

            switch (option) {
                case 1:
                    addItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    launch(args);
                    break;
                case 4:
                    sortItem();
                    break;
                case 5:
                    buyItem();
                    break;
                case 6:
                    generate();
                    break;
                case 7:
                    exitProgramme();
                    break;
                default:
                    System.out.println("Invalid Option!!! Reenter...");
                    break;
            }

        } while(option!=7); // The option until the not equal 6 programme is run
    }

    //When we enter case 1 the method is directly work
    private static void addItem() {
        //Scanner for Add Items
        Scanner scAdd = new Scanner(System.in);
        System.out.println("Your Items Will be Add On CD or Vinyl");
        System.out.println("\t"+"A : CD");
        System.out.println("\t"+"B : Vinyl");

        System.out.print("\t"+"Choose The Category (A/B) : ");
        String  selection;
        selection = scAdd.nextLine().toUpperCase();
        //Get the category and changed to uppercase letter
        while (!selection.equals("A") && !selection.equals("B")) {
            System.out.print("Please Enter Valid Category : ");
            selection = scAdd.nextLine().toUpperCase();
        }

        //If selection is equal to A this programme is working
        if (selection.equals("A")) {
            //Scanner for CD
            Scanner scCD = new Scanner(System.in);
            System.out.println("Your Items Will be Add On CD");
            System.out.println("Please Enter Correct Details of the Items");

            System.out.print("Item Id : ");
            String itemId = scCD.nextLine();

            System.out.print("Title : ");
            String title = scCD.nextLine();
            //First letter save as uppercase
            title = title.substring(0,1).toUpperCase() + title.substring(1).toLowerCase();

            System.out.print("Genre : ");
            String genre = scCD.nextLine();
            //First letter save as uppercase
            genre = genre.substring(0,1).toUpperCase() + genre.substring(1).toLowerCase();

            System.out.print("Release Date (dd/mm/yyyy) : ");
            // Stop strings when we enter Date
            String date = scCD.nextLine();
            java.util.Date getSaleDate = new java.util.Date();
//            try {
//                getSaleDate = new SimpleDateFormat("dd/mm/yyyy").parse(date);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

            System.out.print("Artist : ");
            String artist = scCD.nextLine();
            //First letter save as uppercase
            artist = artist.substring(0,1).toUpperCase() + artist.substring(1).toLowerCase();

            System.out.print("Duration : ");
            // Stop strings when we enter Duration
            while (!scCD.hasNextInt()){
                System.out.print("Invalid Entry!!, Please Enter the Duration : ");
                scCD.next();
            }
            int duration = scCD.nextInt();

            System.out.print("Price : ");
            // Stop strings when we enter Price
            while (!scCD.hasNextDouble()){
                System.out.print("Invalid Entry!!, Please Enter the Price : ");
                scCD.next();
            }
            double price = scCD.nextDouble();



            Cd item = new Cd(itemId,title,genre,date,artist,price,duration);
            storeManager.addItems(item);

        } else {
            //If selection is equal to B this programme is working
            Scanner scVinyl = new Scanner(System.in); //Scanner for Vinyl
            System.out.println("Your Items Will be Add On Vinyl");
            System.out.println("Please Enter Correct Details of the Items");

            System.out.print("Item Id : ");
            String itemId = scVinyl.nextLine();

            System.out.print("Title : ");
            String title = scVinyl.nextLine();
            //First letter save as uppercase
            title = title.substring(0,1).toUpperCase() + title.substring(1).toLowerCase();

            System.out.print("Genre : ");
            String genre = scVinyl.nextLine();
            //First letter save as uppercase
            genre = genre.substring(0,1).toUpperCase() + genre.substring(1).toLowerCase();

            System.out.print("Release Date (dd/mm/yy) : ");
            // Stop strings when we enter Date
            String date = scVinyl.nextLine();
            java.util.Date getSaleDate = new java.util.Date();
//            try {
//                getSaleDate = new SimpleDateFormat("dd/mm/yyyy").parse(date);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

            System.out.print("Artist : ");
            String artist = scVinyl.nextLine();
            artist = artist.substring(0,1).toUpperCase() + artist.substring(1).toLowerCase();

            System.out.print("Price : ");
            // Stop strings when we enter Price
            while (!scVinyl.hasNextDouble()){
                System.out.print("Invalid Entry!!, Please Enter the Price : ");
                scVinyl.next();
            }
            double price = scVinyl.nextDouble();

            System.out.print("Speed : ");
            while (!scVinyl.hasNextDouble()){
                System.out.print("Invalid Entry!!, Please Enter the Speed : ");
                scVinyl.next();
            }
            double speed = scVinyl.nextDouble();

            System.out.print("Diameter : ");
            // Stop strings when we enter Diameter
            while (!scVinyl.hasNextDouble()){
                System.out.print("Invalid Entry!!, Please Enter the Diameter : ");
                scVinyl.next();
            }
            double diametre = scVinyl.nextDouble();



            storeManager.addItems(new Vinyl(itemId,title,genre,date,artist,price,speed,diametre));

        }
    }

    //When we enter case 2 the method is directly work
    private static void deleteItem() {
        //Scanner for Delete Items
        Scanner scDelete = new Scanner(System.in);
        System.out.println("Your Items will be Delete");
        Database database = new Database();
        System.out.print("Enter The Id : ");
        String input = scDelete.next();
        System.out.println("Searching.........");
        List<Document> documents  = database.getData("Item Id",input);

        //If Id is available
        if (!documents.isEmpty()){
            for (Document document : documents) {
                database.delete(document);
            }
        } else {
            //If Id is unavailable
            System.out.println("Sorry! Id not found");
            System.out.println("Please try again ");
            System.out.println("");
        }
    }

    //When we enter case 4 the method is directly work
    private static void sortItem() {
        System.out.println("Your Items Will be Sort");
        System.out.println("Sorting by Title");
        storeManager.sort(storeManager.list(),SortCategory.TITLE);
        System.out.println("Done! Now You can View");
        try {
            launch(args);
        } catch (IllegalStateException e) {
            System.out.println("Error : Application launch must not be called more than once");
        }

    }

    //When we enter case 5 the method is directly work
    private static void buyItem() {
        //Scanner for Buy Items
        Scanner scBuy = new Scanner(System.in);
        Database database = new Database();
        System.out.println("Are You Ready to Buy Items");
        System.out.print("Enter The Items Id : ");
        String itemId = scBuy.nextLine();
        System.out.println("Searching.........");
        List<Document> items = database.getData("Item Id",itemId);

        //If Id is available
        if(!items.isEmpty()){
            for(Document item : items){
                System.out.print("How many Items Do You Want to buy : ");
                int qty = scBuy.nextInt();
                System.out.println("Total price is : "+item.getDouble("Price")*qty + " LKR");
                storeManager.buyItems(item,qty);
                System.out.println("Congratulations, You Are Welcome");
                System.out.println("");
            }
        }else{ //If Id is unavailable
            System.out.println("Sorry! Items not found!");
            System.out.println("Please try again ");
            System.out.println("");
        }
    }

    //When we enter case 6 the method is directly work
    private static void generate() {
        System.out.println("Generate report........");
        System.out.println("Programme is updating..");
        System.out.println("Sorry! Please try again later");
//        try {
//            List<MusicItem> boughtItem = storeManager.generateReport();
//            if (!boughtItem.isEmpty()) {
//                PrintWriter writer = new printWriter("sales-report.txt","UTF-8");
//                writer.println("");
//                for (MusicItem item : boughtItem) {
//                    if (item instanceof Shop) {
//                        writer.println(item.getItemID() + item.getTitle() +((Shop) item).getCount() + item.getPrice() + ((Shop) item).getSaleDate());
//                    }
//                }
//                writer.close();
//            } else {
//                System.out.println("No Sales Report found!");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        System.out.println("");
    }

    //When we enter case 7 the method is directly work
    private static void exitProgramme() {
        System.out.println("Thank you!");
        System.exit(0); //Programme exit
    }


    //When we enter case 3 the method is directly work
    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView tableView = new TableView();
        Database database = new Database();
        //create header title
        final Label label = new Label("Song List");
        label.setFont(new Font(25));
        //create search field
        final TextField txtSearch = new TextField();
        txtSearch.setPromptText("Song Title");
        txtSearch.setPadding(new Insets(10,10,10,10));
        //create search view
        HBox hBox = new HBox();

        //create search button
        final Button search = new Button("Search");
        search.setPadding(new Insets(10,10,10,10));
        //add action li
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String find = txtSearch.getText();
                List<Document> documents = database.getData("Title",find);
                if (!documents.isEmpty()){
                    tableView.getItems().clear();
                    for (Document doc : documents) {
                        String itemId = doc.getString("Item Id");
                        String title = (String) doc.get("Title");
                        String genre = (String) doc.get("Genre");
                        String artist = (String) doc.get("Artist");
                        double price = (double) doc.get("Price");
                        String date = (String) doc.get("Date");
                        String type = (String) doc.get("Type");
                        if (type.equals("CD")) {
                            int duration = (int) doc.get("Duration");
                            tableView.getItems().add(new Cd(itemId,title,genre,artist,date,price,duration));
                        } else {
                            double speed = (double) doc.get("Speed");
                            double diameter = (double) doc.get("Diameter");
                            tableView.getItems().add(new Vinyl(itemId,title,genre,artist,date,price,speed,diameter));
                        }
                    }
                }
            }

        });

        //create reset button because eturn to all song
        final Button reset = new Button("Reset");
        reset.setPadding(new Insets(10,10,10,10));
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               tableView.getItems().clear();
                for (Document doc : database.getData()) {
                    String itemId = doc.getString("Item Id");
                    String title = (String) doc.get("Title");
                    String genre = (String) doc.get("Genre");
                    String artist = (String) doc.get("Artist");
                    double price = (double) doc.get("Price");
                    String date = (String) doc.get("Date");
                    String type = (String) doc.get("Type");
                    if (type.equals("CD")) {
                        int duration = (int) doc.get("Duration");
                        tableView.getItems().add(new Cd(itemId,title,genre,artist,date,price,duration));
                    } else {
                        double speed = (double) doc.get("Speed");
                        double diameter = (double) doc.get("Diameter");
                        tableView.getItems().add(new Vinyl(itemId,title,genre,artist,date,price,speed,diameter));
                    }
                }
            }
        });
        hBox.getChildren().addAll(txtSearch,search,reset);

        TableColumn<String, MusicItem> column1 = new TableColumn<>("Item Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("itemID"));

        TableColumn<String, MusicItem> column2 = new TableColumn<>("Item Title");
        column2.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<String, MusicItem> column3 = new TableColumn<>("Item Genre");
        column3.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<String, MusicItem> column4 = new TableColumn<>("Item Artist");
        column4.setCellValueFactory(new PropertyValueFactory<>("artist"));

        TableColumn<Double, MusicItem> column5 = new TableColumn<>("Item Price");
        column5.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<String, MusicItem> column6 = new TableColumn<>("Release Date");
        column6.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Double, MusicItem> column7 = new TableColumn<>("Item Duration");
        column7.setCellValueFactory(new PropertyValueFactory<>("duration"));

        TableColumn<Double, MusicItem> column8 = new TableColumn<>("Item Speed");
        column8.setCellValueFactory(new PropertyValueFactory<>("speed"));

        TableColumn<Double, MusicItem> column9 = new TableColumn<>("Item Diameter");
        column9.setCellValueFactory(new PropertyValueFactory<>("diameter"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        tableView.getColumns().add(column8);
        tableView.getColumns().add(column9);



        for (Document doc : database.getData()) {
            String itemId = doc.getString("Item Id");
            String title = (String) doc.get("Title");
            String genre = (String) doc.get("Genre");
            String artist = (String) doc.get("Artist");
            double price = (double) doc.get("Price");
            String date = (String) doc.get("Date");
            String type = (String) doc.get("Type");
            if (type.equals("CD")) {
                int duration = (int) doc.get("Duration");
                tableView.getItems().add(new Cd(itemId,title,genre,artist,date,price,duration));
            } else {
                double speed = (double) doc.get("Speed");
                double diameter = (double) doc.get("Diameter");
                tableView.getItems().add(new Vinyl(itemId,title,genre,artist,date,price,speed,diameter));
            }
        }
        VBox vBox = new VBox(tableView,hBox);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
