package homework1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Main class for the application, extending JavaFX Application
public class main2 extends Application {

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
        Button parentButton = new Button("Parent Login");
        Button nurseButton = new Button("Nurse Login");

        // VBox to hold the buttons vertically aligned
        VBox buttonsBox = new VBox(10, doctorButton, parentButton, nurseButton);
        buttonsBox.setAlignment(Pos.CENTER); // Center alignment

        // Action event handlers for each button
        doctorButton.setOnAction(event -> showLoginWindow("Doctor"));
        parentButton.setOnAction(event -> showLoginWindow("Parent"));
        nurseButton.setOnAction(event -> showLoginWindow("Nurse"));

        // Create the main pane with the VBox
        StackPane mainPane = new StackPane(buttonsBox);
        mainPane.setPadding(new Insets(10));

        // Create and return the main scene
        return new Scene(mainPane, 300, 200);
    }

    // Method to display the login window for different user types
    private void showLoginWindow(String userType) {
        // GridPane for arranging components
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // Center alignment
        grid.setHgap(10); // Horizontal gap between components
        grid.setVgap(10); // Vertical gap between components
        grid.setPadding(new Insets(25, 25, 25, 25)); // Padding around the grid

        // Username field and label
        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 1);
        TextField usernameField = new TextField();
        grid.add(usernameField, 1, 1);

        // Password field and label
        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        // Checkbox to remember the user type
        CheckBox facultyCheckbox = new CheckBox("Remember as " + userType);
        grid.add(facultyCheckbox, 1, 3);

        // Back button to return to the main UI
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> primaryStage.setScene(createMainScene()));
        grid.add(backButton, 0, 4);

        // Login button to initiate login action
        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 4);

        // Action event for login button
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            // Perform login logic here
            System.out.println("User Type: " + userType);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            if (facultyCheckbox.isSelected()) {
                System.out.println("Remember checkbox selected");
            }
        });

        // Create the scene with the grid and set it to the primary stage
        Scene loginScene = new Scene(grid, 400, 300);
        primaryStage.setScene(loginScene);
    }
    
    private void showPatientScreen()  {
    	
    	//Someone do 
    	
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

