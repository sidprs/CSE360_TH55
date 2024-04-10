package projectPhase3;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
<<<<<<< HEAD
=======


>>>>>>> pranav

// Main class for the application, extending JavaFX Application
public class projectPhase3 extends Application {

    // Stage for the primary window
    private Stage primaryStage;

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
<<<<<<< HEAD
        doctorButton.setOnAction(event -> showLoginWindow("Doctor"));
        parentButton.setOnAction(event -> showLoginWindow("Parent"));
        nurseButton.setOnAction(event -> showLoginWindow("Nurse"));
=======
        doctorButton.setOnAction(event -> showDoctorLoginWindow("Doctor"));
        patientButton.setOnAction(event -> showPatientLoginWindow("Patient"));
        nurseButton.setOnAction(event -> showNurseLoginWindow("Nurse"));
>>>>>>> pranav
        newUser.setOnAction(event->showNewUserWindow());

        // Create the main pane with the VBox
        StackPane mainPane = new StackPane(buttonsBox);
        mainPane.setPadding(new Insets(10));

        // Create and return the main scene
        return new Scene(mainPane, 300, 200);
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
            
            
            // ***ADD HERE***
            showPatientScreen();
            
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
            
            
            // ***ADD HERE***
            
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

        // Action event for login button
        loginButton.setOnAction(event -> {
            String firstname = firstName.getText();
            String lastname = lastName.getText();
            LocalDate theDate = date.getValue();
            
            
            // ***ADD HERE***
            
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
        
<<<<<<< HEAD
        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 1);
        TextField usernameField = new TextField();
        grid.add(usernameField, 1, 1);
        
        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);
        
        Label passwordConfirm = new Label("Confirm Password:");
        grid.add(passwordConfirm, 0, 3);
        PasswordField passConf = new PasswordField();
        grid.add(passConf, 1, 3);
        
        ToggleGroup toggle = new ToggleGroup();
        RadioButton parent = new RadioButton("Parent");
        RadioButton doctor = new RadioButton("Doctor");
        RadioButton nurse = new RadioButton("Nurse");
        parent.setToggleGroup(toggle);
        doctor.setToggleGroup(toggle);
        nurse.setToggleGroup(toggle);
        grid.add(parent, 0, 4);
=======
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
>>>>>>> pranav
        grid.add(nurse, 1, 4);
        grid.add(doctor, 2, 4);
        
        Button create = new Button("Create New User");
        grid.add(create, 1, 5);
<<<<<<< HEAD
        
        create.setOnAction(event -> {
        	if (passwordField != passConf) {
        		showConfPassError();
        	}
        });
=======
        Button back = new Button("Back");
        grid.add(back, 0, 5);
        
        back.setOnAction(event -> primaryStage.setScene(createMainScene()));
>>>>>>> pranav
        
        
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

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}