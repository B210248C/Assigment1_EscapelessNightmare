package com.example.assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Construct Border Pane Layout
        BorderPane border = new BorderPane();

        // Get image from resources and set background image
        Image bgImg = new Image(Game.class.getResource("background.png").toString(),1200, 700,false,true);

        BackgroundImage bgImage = new BackgroundImage(bgImg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        border.setBackground(new Background(bgImage));

        // Position
        border.setTop(topBar());
        border.setCenter(textTheme());
        border.setRight(descriptionText());

        // Create scene and get css
        Scene scene = new Scene(border, 1200, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // Stage styling
        stage.setTitle("Escapeless Nightmare");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public BorderPane topBar() {

        // Construct Border Pane Layout
        BorderPane border = new BorderPane();

        // Set border style
        border.setStyle("-fx-background-color:black; -fx-opacity:0.8");

        // Set position
        border.setLeft(topLeftHBox());
        border.setCenter(topCenterHBox());
        border.setRight(topRightHBox());

        return border;
    }

    public HBox topLeftHBox(){

        // Top Left
        HBox hbLeft = new HBox();

        //Styling HBox
        hbLeft.setPadding(new Insets(15,0,10,10));
        hbLeft.setMinWidth(300);

        // Get fonts from resources folder
        Font customFont = Font.loadFont(getClass().getResourceAsStream("TiltPrism-Regular-VariableFont_XROT,YROT.ttf"), 35);

        // Create text
        Text text = new Text("Escapeless Nightmare");

        // Styling text
        text.setFont(customFont);
        text.setFill(Color.BLACK);
        text.setStrokeWidth(2);
        text.setStroke(Color.WHITE);

        // Put text into HBox
        hbLeft.getChildren().add(text);

        return hbLeft;
    }

    public HBox topCenterHBox(){

        // Top Center
        HBox hbCenter = new HBox();

        // Styling HBox
        hbCenter.setAlignment(Pos.CENTER);
        hbCenter.setMinWidth(500);

        // Construct Menu Bar
        MenuBar menubar = new MenuBar();

        // Styling css menu bar
        menubar.getStyleClass().add("custom-menubar");

        // Create menu
        Menu menu1 = new Menu("Menu");
        Menu menu2 = new Menu("Docs");
        Menu menu3 = new Menu("Whitepaper");

        // Get menus
        menubar.getMenus().addAll(menu1,menu2,menu3);

        // Put menu bar into HBox
        hbCenter.getChildren().addAll(menubar);

        return hbCenter;
    }

    public HBox topRightHBox(){

        // Top Right
        HBox hbRight = new HBox();

        // Styling HBox
        hbRight.setPadding(new Insets(10,80,10,10));
        hbRight.setSpacing(10);
        hbRight.setMinWidth(300);
        hbRight.setAlignment(Pos.CENTER_RIGHT);

        // Load the image
        Image imageFB = new Image(getClass().getResourceAsStream("facebook.png"));
        Image imageIns = new Image(getClass().getResourceAsStream("instagram.png"));
        Image imageTwi = new Image(getClass().getResourceAsStream("twitter.png"));

        // Create an ImageView
        ImageView imageViewFB = new ImageView(imageFB);
        ImageView imageViewIns = new ImageView(imageIns);
        ImageView imageViewTwi = new ImageView(imageTwi);

        // Set image size
        imageViewFB.setFitWidth(30);
        imageViewFB.setFitHeight(30);
        imageViewIns.setFitWidth(30);
        imageViewIns.setFitHeight(30);
        imageViewTwi.setFitWidth(30);
        imageViewTwi.setFitHeight(30);

        hbRight.getChildren().addAll(imageViewFB,imageViewIns,imageViewTwi);

        return hbRight;
    }

    public VBox textTheme(){

        // Get fonts from resources
        Font customFont = Font.loadFont(getClass().getResourceAsStream("CinzelDecorative-Regular.ttf"), 75);
        Font customFont2 = Font.loadFont(getClass().getResourceAsStream("Julee-Regular.ttf"), 30);

        // Construct vbox to wrap text
        VBox vb = new VBox();

        // Create Vbox for each particular text
        VBox vbEscapeless = new VBox();
        VBox vbNightmare = new VBox();

        Text textE = new Text("Escapeless");
        Text textN = new Text("Nightmare");

        // Styling text
        textE.setFont(customFont);
        textE.setFill(Color.WHITE);
        textN.setFont(customFont);
        textN.setFill(Color.WHITE);
        vbEscapeless.setPadding(new Insets(100,100,20,50));
        vbNightmare.setPadding(new Insets(0,0,0,200));

        // Add texts to their particular vbox
        vbEscapeless.getChildren().addAll(textE);
        vbNightmare.getChildren().addAll(textN);

        //--------------------------------------------------------------------------------------------------------------------------

        // Construct VBox for button
        VBox vbButton = new VBox();

        // Style vbox
        vbButton.setPadding(new Insets(30,0,0,480));

        //Create button
        Button button = new Button("Play");
        button.setFont(customFont2);
        button.setTextFill(Color.RED);
        button.setStyle("-fx-background-color: \n" +
                "        #090a0c,\n" +
                "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                "        linear-gradient(#20262b, #191d22),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 8,5,4,8;\n" +
                "    -fx-background-insets: 0,1,2,0;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-text-fill: red;\n" +
                "    -fx-padding: 5 50 5 50;");

        // Add button to vbox
        vbButton.getChildren().add(button);

        // Get each text and button VBox
        vb.getChildren().addAll(vbEscapeless,vbNightmare,vbButton);

        return vb;

    }

    public FlowPane descriptionText(){

        // Get fonts from resources
        Font customFont1 = Font.loadFont(getClass().getResourceAsStream("KleeOne-Regular.ttf"), 17);

        // Construct flow pane
        FlowPane flowPane = new FlowPane();

        // Set flow pane style
        flowPane.setVgap(20.0);
        flowPane.setHgap(300.0);
        flowPane.setPadding(new Insets(90,0,0,180));
        flowPane.getStyleClass().add("description");

        // Create VBOX for text
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        VBox vb3 = new VBox();
        VBox vb4 = new VBox();
        VBox vb5 = new VBox();
        VBox vb6 = new VBox();

        // Creating for-loop
        String vboxTextStyle = "description";

        // Create an array of VBox elements
        VBox[] vBoxes = {vb1, vb2, vb3, vb4, vb5, vb6};

        // Apply CSS to each VBox
        for (VBox vBox : vBoxes) {
            vBox.getStyleClass().add(vboxTextStyle);
        }

        // Create text
        Text text = new Text("\"You have stumbled into an unknown world of horror,");
        Text text1 = new Text("filled with the unknown...");
        Text text2 = new Text("Welcome to the realm of horror games.");
        Text text3 = new Text("Here, it appears boundless,");
        Text text4 = new Text("stretching far beyond sight's grasp,");
        Text text5 = new Text("An eternal abyss,");
        Text text6 = new Text("When will it come to an end,");
        Text text7 = new Text("When will it be over?");
        Text text8 = new Text("What lies ahead for us,");
        Text text9 = new Text("Is it hope that awaits,");
        Text text10 = new Text("Or is it despair that looms?");
        Text text11 = new Text("Survive... Escape...\"");

        // Styling text
        text.setWrappingWidth(250);
        text2.setWrappingWidth(250);
        text4.setWrappingWidth(250);

        Text[] textArray = {text, text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11};

        for (Text t : textArray) {
            t.setFont(customFont1);
        }

        // Get text to vbox
        vb1.getChildren().addAll(text,text1);
        vb2.getChildren().addAll(text2);
        vb3.getChildren().addAll(text3,text4);
        vb4.getChildren().addAll(text5,text6,text7);
        vb5.getChildren().addAll(text8,text9,text10);
        vb6.getChildren().addAll(text11);

        // Get VBox
        flowPane.getChildren().addAll(vb1,vb2,vb3,vb4,vb5,vb6);

        return flowPane;
    }

    public static void main(String[] args) {
        launch();
    }
}