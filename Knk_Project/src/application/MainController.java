package application;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController{

	private Connection dbConnection;
	
	private Stage mainStage;
	

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private Label lblStatus;
    
    
    }
	

