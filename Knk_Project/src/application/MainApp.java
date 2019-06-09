package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MainApp extends Application {
	
	
	
	private TextField idTxt = new TextField();
	private TextField idStudentitTxt = new TextField();
	private TextField emriTxt = new TextField();
	private TextField mbiemriTxt = new TextField();
//	private TextField ditelindjaTxt = new TextField();
	private TextField mesatarjaTxt = new TextField();
	private TextField emailTxt = new TextField();
	private TextField numriTxt = new TextField();
	private TextField qytetiTxt = new TextField();
	private TextField adresaTxt = new TextField();
	private TextField vitiiStudimeveTxt = new TextField();
	private TextField niveliiStudimeveTxt = new TextField();
	private TextField fakultetiTxt = new TextField();
	private TextField drejtimiTxt = new TextField();
	private TextField bursaTxt = new TextField();
	
	private Button insertBtn = new Button("Insert");
//	private Button updateBtn = new Button("Update");
//	private Button deleteBtn = new Button("Delete");
	private Button clearBtn = new Button("Clear");
	
	
	
	private TableView applicantsTable = new TableView();
	
	@Override
	public void start (Stage primaryStage) {
		
		GridPane formPane = new GridPane();
		
		formPane.addRow(0, new Label("ID: "), idTxt);
		formPane.addRow(1, new Label("ID e studentit: "), idStudentitTxt);
		formPane.addRow(2, new Label("Emri: "), emriTxt);
		formPane.addRow(3, new Label("Mbiemri: "), mbiemriTxt);
//		formPane.addRow(4, new Label("Ditelindja: "), ditelindjaTxt);
		formPane.addRow(5, new Label("Mesatarja: "), mesatarjaTxt);
		formPane.addRow(6, new Label("Email: "), emailTxt);
		formPane.addRow(7, new Label("Numri: "),numriTxt );
		formPane.addRow(8, new Label("Qyteti: "),qytetiTxt );
		formPane.addRow(9, new Label("Adresa: "), adresaTxt);
		formPane.addRow(10, new Label("Viti i studimeve: "),vitiiStudimeveTxt );
		formPane.addRow(11, new Label("Niveli i studimeve: "),niveliiStudimeveTxt);
		formPane.addRow(12, new Label("Fakulteti: "), fakultetiTxt );
		formPane.addRow(13, new Label("Drejtimi: "), drejtimiTxt);
		formPane.addRow(14, new Label("Bursa: "), bursaTxt);
		
		formPane.setHgap(30);
		formPane.setVgap(17);
//		Button deleteBtn = new Button();
//		deleteBtn.setText("Fshij");
//		deleteBtn.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				getDheSet test = table.getSelectionModel().getSelectedItem();
//				int _id = test.getIdStudentit();
//				try {
//					Statement st = conn.createStatement();
//					st.execute("Delete from aplikuesit where idStudentit = " +_id+" ;");
//					
//				}
//				catch(SQLException e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
		
		
		
//		idTxt.setDisable(true);
		
		HBox buttonsPane = new HBox(20);
		buttonsPane.getChildren().addAll(insertBtn,  clearBtn);
		
		
		
		insertBtn.setOnAction(e -> {
			insertApplicants();
		});
		
		
		
		clearBtn.setOnAction(e -> {
			clearForm();
		});
		
		VBox leftPane = new VBox(40);
		leftPane.getChildren().addAll(formPane, buttonsPane);
		
		TableColumn<String, Applicants> column1 = new TableColumn<>("ID");
		column1.setCellValueFactory(new PropertyValueFactory("id"));
		column1.setPrefWidth(60);
		
		TableColumn<String, Applicants> column2 = new TableColumn<>("ID e Studentit");
		column2.setCellValueFactory(new PropertyValueFactory("idStudentit"));
		column2.setPrefWidth(60);
		
		TableColumn<String, Applicants> column3 = new TableColumn<>("Emri");
		column3.setCellValueFactory(new PropertyValueFactory("emri"));
		column3.setPrefWidth(70);
		
		TableColumn<String, Applicants> column4 = new TableColumn<>("Mbiemri");
		column4.setCellValueFactory(new PropertyValueFactory("mbiemri"));
		column4.setPrefWidth(70);
		
//		TableColumn<String, Applicants> column5 = new TableColumn<>("Ditelindja");
//		column5.setCellValueFactory(new PropertyValueFactory("ditelindja"));
//		column5.setPrefWidth(70);
		
		TableColumn<String, Applicants> column6 = new TableColumn<>("Mesatarja");
		column6.setCellValueFactory(new PropertyValueFactory("mesatarja"));
		column6.setPrefWidth(70);
		
		TableColumn<String, Applicants> column7 = new TableColumn<>("Email");
		column7.setCellValueFactory(new PropertyValueFactory("email"));
		column7.setPrefWidth(70);
		
		TableColumn<String, Applicants> column8 = new TableColumn<>("Numri");
		column8.setCellValueFactory(new PropertyValueFactory("numri"));
		column8.setPrefWidth(70);
		
		TableColumn<String, Applicants> column9 = new TableColumn<>("Qyteti");
		column9.setCellValueFactory(new PropertyValueFactory("qyteti"));
		column9.setPrefWidth(70);
		
		TableColumn<String, Applicants> column10 = new TableColumn<>("Adresa");
		column10.setCellValueFactory(new PropertyValueFactory("adresa"));
		column10.setPrefWidth(70);
		
		TableColumn<String, Applicants> column11 = new TableColumn<>("Viti i studimeve");
		column11.setCellValueFactory(new PropertyValueFactory("VitiiStudimeve"));
		column11.setPrefWidth(80);
		
		TableColumn<String, Applicants> column12 = new TableColumn<>("Niveli i Studimeve");
		column12.setCellValueFactory(new PropertyValueFactory("niveliiStudimeve"));
		column12.setPrefWidth(80);
		
		TableColumn<String, Applicants> column13 = new TableColumn<>("Fakulteti");
		column13.setCellValueFactory(new PropertyValueFactory("fakulteti"));
		column13.setPrefWidth(70);
		
		TableColumn<String, Applicants> column14 = new TableColumn<>("Drejtimi");
		column14.setCellValueFactory(new PropertyValueFactory("drejtimi"));
		column14.setPrefWidth(70);
		
		TableColumn<String, Applicants> column15 = new TableColumn<>("Bursa");
		column15.setCellValueFactory(new PropertyValueFactory("bursa"));
		column15.setPrefWidth(70);
		
		applicantsTable.getColumns().add(column1);
		applicantsTable.getColumns().add(column2);
		applicantsTable.getColumns().add(column3);
		applicantsTable.getColumns().add(column4);
//		applicantsTable.getColumns().add(column5);
		applicantsTable.getColumns().add(column6);
		applicantsTable.getColumns().add(column7);
		applicantsTable.getColumns().add(column8);
		applicantsTable.getColumns().add(column9);
		applicantsTable.getColumns().add(column10);
		applicantsTable.getColumns().add(column11);
		applicantsTable.getColumns().add(column12);
		applicantsTable.getColumns().add(column13);
		applicantsTable.getColumns().add(column14);
		applicantsTable.getColumns().add(column15);
		
		applicantsTable.setPrefWidth(1050);
		applicantsTable.setPrefHeight(500);
		
		HBox mainPane = new HBox(5);
		mainPane.getChildren().addAll(leftPane, applicantsTable);
		
		mainPane.setPadding(new Insets(30, 30, 30, 30));
		
		Scene scene = new Scene(mainPane, 1500, 700);
		primaryStage.setTitle("Applicants");
		primaryStage.setScene(scene);
		
		showApplicants();
		
		primaryStage.show();
		
		
	
		
	}
	

	public void insertApplicants() {
		
		if(Applicants.addApplicants(Integer.parseInt(idTxt.getText()), Integer.parseInt(idStudentitTxt.getText()),
				emriTxt.getText(), mbiemriTxt.getText(), 
//				Integer.parseInt(ditelindjaTxt.getText()), 
				mesatarjaTxt.getText(), emailTxt.getText(),
				Integer.parseInt(numriTxt.getText()),qytetiTxt.getText(), adresaTxt.getText(),Integer.parseInt(vitiiStudimeveTxt.getText()), niveliiStudimeveTxt.getText(), fakultetiTxt.getText(),
				drejtimiTxt.getText(), bursaTxt.getText())) {
			showApplicants();
			clearForm();
		}
	}	
	
//	private void setConnection() {
////		String dbName = "menaxhimi_bursave";
////		String userName="root";
////		String password="1234";
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/menaxhimi_bursave?verifyServerCertificate=false&useSSL=true","root","1234");
//		}  catch (Exception ex) {
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.setTitle("Database problem");
//			alert.setHeaderText(null);
//			alert.setContentText("Can not connect to database");
//			alert.showAndWait();
//			System.exit(0);
//		}
//	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void showApplicants() {
		List<Applicants> aplicants = Applicants.getApplicants();
		
		ObservableList<Applicants> applicantsList = FXCollections.observableArrayList();
		
		for(int i = 0; i < aplicants.size(); i++) {
			applicantsList.add(aplicants.get(i));
		}
		
		applicantsTable.setItems(applicantsList);
	}
	
	
	public void clearForm() {
		idTxt.setText("");
		idStudentitTxt.setText("");
		emriTxt.setText("");
		mbiemriTxt.setText("");
//		ditelindjaTxt.setText("");
		mesatarjaTxt.setText("");
		emailTxt.setText("");
		numriTxt.setText("");
		qytetiTxt.setText("");
		adresaTxt.setText("");
		vitiiStudimeveTxt.setText("");
		niveliiStudimeveTxt.setText("");
		fakultetiTxt.setText("");
		drejtimiTxt.setText("");
		bursaTxt.setText("");
	
}
	
	
}