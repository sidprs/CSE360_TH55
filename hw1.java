package hw1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import hw1.hw5.GlobalData;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;


// Main class for the application, extending JavaFX Application
public class hw1 extends Application {

    // Stage for the primary window
    private Stage primaryStage;
    private LocalDate selectedDate;

    // Start method required by JavaFX Application
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Medical App");

        // Create the main scene
        Scene mainScene = createMainScene();

        // Set the main scene to the primary stage and display
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    // Method to create the main scene
    private Scene createMainScene() {
        // Buttons for different user logins
        Button doctorButton = new Button("Doctor Login");
        Button patientButton = new Button("Patient Login");
        Button nurseButton = new Button("Nurse Login");
        Button newUser = new Button("Create New Account");

        // VBox to hold the buttons vertically aligned
        VBox buttonsBox = new VBox(10, doctorButton, patientButton, nurseButton, newUser);
        buttonsBox.setAlignment(Pos.CENTER); // Center alignment

        // Action event handlers for each button
        doctorButton.setOnAction(event -> showDoctorLoginWindow("Doctor"));
        patientButton.setOnAction(event -> showPatientLoginWindow("Patient"));
        nurseButton.setOnAction(event -> showNurseLoginWindow("Nurse"));
        newUser.setOnAction(event->showNewUserWindow());

        // Create the main pane with the VBox
        StackPane mainPane = new StackPane(buttonsBox);
        mainPane.setPadding(new Insets(10));

        // Create and return the main scene
        return new Scene(mainPane, 400, 300);
    }

    // Method to display the login window for different user types
    private void showPatientLoginWindow(String userType) {
        // GridPane for arranging components
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // Center alignment
        grid.setHgap(10); // Horizontal gap between components
        grid.setVgap(10); // Vertical gap between components
        grid.setPadding(new Insets(25, 25, 25, 25)); // Padding around the grid

        Label FirstName = new Label("FirstName:");
        grid.add(FirstName, 0, 1);
        TextField firstName = new TextField();
        grid.add(firstName, 1, 1);

        Label LastName = new Label("LastName:");
        grid.add(LastName, 0, 2);
        TextField lastName = new TextField();
        grid.add(lastName, 1, 2);
        
        Label Date = new Label("Date:");
        grid.add(Date, 0, 3);
        DatePicker date = new DatePicker();
        grid.add(date, 1, 3);

        // Back button to return to the main UI
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> primaryStage.setScene(createMainScene()));
        grid.add(backButton, 0, 4);

        // Login button to initiate login action
        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 4);

        // Action event for login button
        loginButton.setOnAction(event -> {
            String firstname = firstName.getText();
            String lastname = lastName.getText();
            LocalDate theDate = date.getValue();
            String bday = theDate.toString();
            String filename = "P" + " " + firstname + " " + lastname + " " + bday;
            
            boolean found = search(filename);
            if(found) {
            	showPatientScreen();
            } else
            	showAlert("Error", "Account not found");            
       
            
        });
        
        

        // Create the scene with the grid and set it to the primary stage
        Scene loginScene = new Scene(grid, 400, 300);
        primaryStage.setScene(loginScene);
    }
    
    private void showDoctorLoginWindow(String userType) {
        // GridPane for arranging components
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // Center alignment
        grid.setHgap(10); // Horizontal gap between components
        grid.setVgap(10); // Vertical gap between components
        grid.setPadding(new Insets(25, 25, 25, 25)); // Padding around the grid

        Label FirstName = new Label("FirstName:");
        grid.add(FirstName, 0, 1);
        TextField firstName = new TextField();
        grid.add(firstName, 1, 1);

        Label LastName = new Label("LastName:");
        grid.add(LastName, 0, 2);
        TextField lastName = new TextField();
        grid.add(lastName, 1, 2);
        
        Label Date = new Label("Date:");
        grid.add(Date, 0, 3);
        DatePicker date = new DatePicker();
        grid.add(date, 1, 3);

        // Back button to return to the main UI
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> primaryStage.setScene(createMainScene()));
        grid.add(backButton, 0, 4);

        // Login button to initiate login action
        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 4);

        // Action event for login button
        loginButton.setOnAction(event -> {
            String firstname = firstName.getText();
            String lastname = lastName.getText();
            LocalDate theDate = date.getValue();
            String bday = theDate.toString();
            String filename = "D" + " " + firstname + " " + lastname + " " + bday;
            
            boolean found = search(filename);
            if(found) {
            	//This is a temporary placeholder stage to verify that information was put in correctly
            	Stage stage = (Stage) loginButton.getScene().getWindow();
                VBox newRoot = new VBox();
                newRoot.getChildren().add(new Label("Welcome, Doctor " + firstname + "!"));
                Scene newScene = new Scene(newRoot, 400, 300);
                stage.setScene(newScene);
                stage.show();
            } else
            	showAlert("Error", "Doctor account not found");            
        });
            
        
     // Create the scene with the grid and set it to the primary stage
        Scene loginScene = new Scene(grid, 400, 300);
        primaryStage.setScene(loginScene);
    }
    
    private void showNurseLoginWindow(String userType) {
        // GridPane for arranging components
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // Center alignment
        grid.setHgap(10); // Horizontal gap between components
        grid.setVgap(10); // Vertical gap between components
        grid.setPadding(new Insets(25, 25, 25, 25)); // Padding around the grid

        Label FirstName = new Label("FirstName:");
        grid.add(FirstName, 0, 1);
        TextField firstName = new TextField();
        grid.add(firstName, 1, 1);

        Label LastName = new Label("LastName:");
        grid.add(LastName, 0, 2);
        TextField lastName = new TextField();
        grid.add(lastName, 1, 2);
        
        Label Date = new Label("Date:");
        grid.add(Date, 0, 3);
        DatePicker date = new DatePicker();
        grid.add(date, 1, 3);

        // Back button to return to the main UI
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> primaryStage.setScene(createMainScene()));
        grid.add(backButton, 0, 4);

        // Login button to initiate login action
        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 4);

        

        loginButton.setOnAction(event -> {
        	String firstname = firstName.getText();
            String lastname = lastName.getText();
            LocalDate theDate = date.getValue();
            String bday = theDate.toString();
            String filename = "N" + " " + firstname + " " + lastname + " " + bday;
            
            boolean found = search(filename);
            if(found) {
            	//This is a temporary placeholder stage to verify that information was put in correctly
            	Stage stage = (Stage) loginButton.getScene().getWindow();
                VBox newRoot = new VBox();
                newRoot.getChildren().add(new Label("Welcome, Nurse " + firstname + "!"));
                Scene newScene = new Scene(newRoot, 400, 300);
                stage.setScene(newScene);
                stage.show();
                
            } else
            	showAlert("Error", "Nurse account not found");            
        });
        
     // Create the scene with the grid and set it to the primary stage
        Scene loginScene = new Scene(grid, 400, 300);
        primaryStage.setScene(loginScene);
    }
    
    private void showNewUserWindow(){
    	GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label FirstName = new Label("FirstName:");
        grid.add(FirstName, 0, 1);
        TextField firstName = new TextField();
        grid.add(firstName, 1, 1);
        
        Label LastName = new Label("LastName:");
        grid.add(LastName, 0, 2);
        TextField lastName = new TextField();
        grid.add(lastName, 1, 2);
        
        Label Date = new Label("Date:");
        grid.add(Date, 0, 3);
        DatePicker date = new DatePicker();
        grid.add(date, 1, 3);
        
        ToggleGroup toggle = new ToggleGroup();
        RadioButton patient = new RadioButton("Patient");
        RadioButton doctor = new RadioButton("Doctor");
        RadioButton nurse = new RadioButton("Nurse");
        patient.setToggleGroup(toggle);
        doctor.setToggleGroup(toggle);
        nurse.setToggleGroup(toggle);
        grid.add(patient, 0, 4);
        grid.add(nurse, 1, 4);
        grid.add(doctor, 2, 4);
        
        Button create = new Button("Create New User");
        grid.add(create, 1, 5);

        Button back = new Button("Back");
        grid.add(back, 0, 5);
        
        back.setOnAction(event -> primaryStage.setScene(createMainScene()));
        
        create.setOnAction(e -> {
        	if (firstName.getText().trim().isEmpty() || lastName.getText().trim().isEmpty() || date.getValue() == null) {
                showAlert("Error", "All fields must be filled out.");
            } else {
            String status = "";
            RadioButton radioButton = (RadioButton) toggle.getSelectedToggle();
            if(radioButton != null) {
            	if(radioButton.equals(nurse)) {
            		status = "N";
            	}
            	if(radioButton.equals(patient)) {
            		status = "P";
            	}
            	if(radioButton.equals(doctor)) {
            		status = "D";
            	}
            }
            
            
            String first = firstName.getText();
            String last = lastName.getText();
            selectedDate = date.getValue();

            saveInfoToFile(status, first, last, selectedDate);
            primaryStage.setScene(createMainScene());
            }});
        
        Scene newUserScene = new Scene(grid, 400, 300);
        primaryStage.setScene(newUserScene);
        
    }
    
    private void showConfPassError() {
    	GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label error = new Label("Error:");
        grid.add(error, 0, 1);
        Label desc = new Label("\"confirm password\" does not match \"password\"");
        grid.add(desc, 0, 2);
        Button back = new Button("Back");
        grid.add(back, 0, 3);
        
        back.setOnAction(event->showNewUserWindow());
        
        Scene confPassError = new Scene(grid, 350, 200);
        primaryStage.setScene(confPassError);
    }
    
    private void showPatientScreen()  {
    	GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Button info = new Button("View/Change Info");
        grid.add(info, 0, 1);
        info.setOnAction(event ->{
        	//***open the patients info screen***
        });
        
        Button summary = new Button("view summary of visits");
        grid.add(summary, 0, 2);
        summary.setOnAction(event -> {
        	//***open the file with all the info about the patients visits***
        });
        
        Button message = new Button("Message a Doctor or Nurse");
        grid.add(message, 0, 3);
        message.setOnAction(event -> {
        	//***open the page to let the patient message doctors***
        });
    	
        Scene patientScreen = new Scene(grid, 350, 200);
        primaryStage.setScene(patientScreen);
    }
    
    private void showDoctorScreen()  {
    	//Someone do 
    	
    }
    
    
    private void showNurseScreen()  {
    	
    	//Someone do
    	
    }
    
    public void saveInfoToFile(String status, String first, String last, LocalDate date) {
    	String bday = date.toString();
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(status + " " + first + " " + last + " " + bday))) {
	        writer.write("First Name: " + first);
	        writer.newLine();
	        writer.write("Last Name: " + last);
	        writer.newLine();
	        writer.write("Birthday:  " + date);
	        writer.newLine();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
    public boolean search(String fileName) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	        	return true;
	    } catch (IOException e) {
	        System.err.println("An error occurred");
	    }
	    return false;
	}
    public void showAlert(String title, String message) {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle(title);
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.showAndWait();
	}
    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}