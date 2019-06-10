package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class addAdmin {
	 	private Connection dbConnection;
	 	private static TextField usernameTxt = new TextField();
	 	private static PasswordField passwordTxt = new PasswordField();
		private static Button submitButton = new Button("Regjistro");
	public static void createMainStage() {
    	Stage primaryStage = new Stage();
        primaryStage.setTitle("Regjistroni nje administrues te ri");
       

        GridPane gridPane = createRegistrationFormPane();
       
        addUIControls(gridPane);
       
        Scene scene = new Scene(gridPane, 800, 500);
       
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:///C:/Users/HP/git/knkProjekt/Knk_Project/graphic-scholarship_800x600.png"));

        primaryStage.show();
    }


    private static GridPane createRegistrationFormPane() {
       
        GridPane gridPane = new GridPane();

       
        gridPane.setAlignment(Pos.CENTER);

        
        gridPane.setPadding(new Insets(40, 40, 40, 40));

   
        gridPane.setHgap(10);

        
        gridPane.setVgap(10);

        

        
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private static void addUIControls(GridPane gridPane) {
     
        Label headerLabel = new Label("Regjistrohuni");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

      
        Label nameLabel = new Label("Emri i perdoruesit: ");
        gridPane.add(nameLabel, 0,1);

       
        usernameTxt.setPrefHeight(40);
        gridPane.add(usernameTxt, 1,1);



        // Add Password Label
        Label passwordLabel = new Label("Fjalekalimi : ");
        gridPane.add(passwordLabel, 0, 3);


        passwordTxt.setPrefHeight(40);
        gridPane.add(passwordTxt, 1, 3);



        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));


        submitButton.setOnAction(e ->{
        	insertAdmin();
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
   
    
    private void setConnection() {
//		String dbName = "menaxhimi_bursave";
//		String userName="root";
//		String password="1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/menaxhimi_bursave?verifyServerCertificate=false&useSSL=true","root","1234");
		}  catch (Exception ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem");
			alert.setHeaderText(null);
			alert.setContentText("Can not connect to database");
			alert.showAndWait();
			System.exit(0);
		}
	}
    
    public static void showAdmin() {
		List<LoginForm> admin = LoginForm.getAdmin();
		
		ObservableList<LoginForm> adminList = FXCollections.observableArrayList();
		
		for(int i = 0; i < admin.size(); i++) {
			adminList.add(admin.get(i));
		}
		
		//adminTable.setItems(adminList);
	}
	
public static void insertAdmin() {
	
		
		if(LoginForm.addAdmin(usernameTxt.getText(), passwordTxt.getText())) {
			showAdmin();

		}
		
		
	}

 
}