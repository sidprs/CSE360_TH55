package projectPhase3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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


// Main class for the application, extending JavaFX Application
public class projectPhase3 extends Application {

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
        
        Label Date = new Label("Birthday:");
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
            	showPatientScreen(firstname, lastname, bday);
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

        Label FirstName = new Label("First Name:");
        grid.add(FirstName, 0, 1);
        TextField firstName = new TextField();
        grid.add(firstName, 1, 1);

        Label LastName = new Label("Last Name:");
        grid.add(LastName, 0, 2);
        TextField lastName = new TextField();
        grid.add(lastName, 1, 2);
        
        Label Date = new Label("Birthday:");
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
                // Transition to the doctor screen upon successful login
                showDoctorScreen(firstname, filename);
            } else {
                showAlert("Error", "Doctor account not found");
            }            
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
        
        Label Date = new Label("Birthday:");
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
            	/*This is a temporary placeholder stage to verify that information was put in correctly
            	Stage stage = (Stage) loginButton.getScene().getWindow();
                VBox newRoot = new VBox();
                newRoot.getChildren().add(new Label("Welcome, Nurse " + firstname + "!"));
                Scene newScene = new Scene(newRoot, 400, 300);
                stage.setScene(newScene);
                stage.show();*/
            	showNurseScreen();
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
        
        Label Date = new Label("Birthday:");
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
    
    private void showPatientScreen(String fn, String ln, String bd) {
    	 GridPane grid = new GridPane();
    	 grid.setAlignment(Pos.CENTER);
    	 grid.setHgap(10);
    	 grid.setVgap(10);
    	 grid.setPadding(new Insets(25, 25, 25, 25));
    	 
    	 Button info = new Button("View/Change Info");
    	 grid.add(info, 0, 1);
    	 info.setOnAction(event ->{
    	 //***open the patients info screen***
    	 patientInfoScreen(fn,ln,bd);
    	 });
    	 
    	 Button summary = new Button("view summary of visits");
    	 grid.add(summary, 0, 2);
    	 summary.setOnAction(event -> {
    		 display(primaryStage, "P " + fn + " " + ln + " " + bd);
    	 });
    	 
    	 Button message = new Button("Message a Doctor or Nurse");
    	 grid.add(message, 0, 3);
    	 message.setOnAction(event -> {
    	 //***open the page to let the patient message doctors***
    	 patientMessageScreen(fn,ln,bd);
    	 });
    	 
    	 Scene patientScreen = new Scene(grid, 350, 200);
    	 primaryStage.setScene(patientScreen);
    	 
    	 Button logout = new Button("Logout");
    	 grid.add(logout, 0, 4);
    	 logout.setOnAction(event-> primaryStage.setScene(createMainScene()));
    	 }

    private void patientInfoScreen(String fn, String ln, String bd) {
    	GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        String PHONE ="";
        String EMAIL = "";
        String INSURANCE = "";
        String PHARMACY ="";
        
        String filename = "P" + " " + fn + " " + ln + " " + bd;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        	for (int i=0; i<3; i++) {
        		reader.readLine();
        	}
        	PHONE = reader.readLine();
    		EMAIL = reader.readLine();
    		INSURANCE = reader.readLine();
    		PHARMACY = reader.readLine();
        } catch (IOException e) {
        System.err.println("An error occurred");
        }
        
        Label PhoneNumber = new Label("Phone Number:");
        grid.add(PhoneNumber, 0, 1);
        TextField phoneNumber = new TextField();
        grid.add(phoneNumber, 1, 1);
        phoneNumber.setText(PHONE);
        
        Label Email = new Label("Email:");
        grid.add(Email, 0, 2);
        TextField email = new TextField();
        grid.add(email, 1, 2);
        email.setText(EMAIL);
        
        Label Insurance = new Label("Insurance ID:");
        grid.add(Insurance, 0, 3);
        TextField insurance = new TextField();
        grid.add(insurance, 1, 3);
        insurance.setText(INSURANCE);
        
        Label Pharmacy = new Label("Pharmacy:");
        grid.add(Pharmacy, 0, 4);
        TextField pharmacy = new TextField();
        grid.add(pharmacy, 1, 4);
        pharmacy.setText(PHARMACY);
        
        Button back = new Button("Back");
        grid.add(back, 0, 5);
        back.setOnAction(event->showPatientScreen(fn,ln,bd));
        
        Button save = new Button("Save");
        grid.add(save, 1, 5);
        save.setOnAction(event->{
        	
        	String pho = phoneNumber.getText();
            String ema = email.getText();
            String ins = insurance.getText();
            String pha = pharmacy.getText();
        	
        	savePatientInfoToFile(fn,ln,bd,pho,ema,ins,pha);
        	});
        
        
        Scene patientInfoScreen = new Scene(grid, 600, 400);
        primaryStage.setScene(patientInfoScreen);
        
    }
    private void patientMessageScreen(String fn, String ln, String bd) {
    	 GridPane grid = new GridPane();
    	 grid.setAlignment(Pos.CENTER);
    	 grid.setHgap(20);
    	 grid.setVgap(10);
    	 grid.setPadding(new Insets(25, 25, 25, 25));
    	 

    	 Label FirstName = new Label("Doctor First Name:");
    	 grid.add(FirstName, 0, 1);
    	 TextField FirstNameField = new TextField();
    	 grid.add(FirstNameField, 1, 1);
    	 
    	 Label LastName = new Label("Doctor Last Name:");
    	 grid.add(LastName, 0, 2);
    	 TextField LastNameField = new TextField();
    	 grid.add(LastNameField, 1, 2);
    	 
    	 Label bday = new Label("Doctor Birthday: ");
    	 grid.add(bday, 0, 3);
    	 DatePicker bDay = new DatePicker();
    	 grid.add(bDay, 1, 3);
    	 
    	 Button send = new Button("Send");
    	 grid.add(send, 2, 1);
    	 
    	 Label message = new Label("Message: ");
    	 grid.add(message, 0, 4);
    	 TextField messageField = new TextField();
    	 grid.add(messageField, 1, 4);
    	 
    	 Button back = new Button("Back");
    	 grid.add(back, 2, 6);
    	 back.setOnAction(event -> {
    		 showPatientScreen(fn, ln, bd);
    	 });
    	 
    	 Button recents = new Button("View Recent Messages");
    	 grid.add(recents, 1, 6);
    	 recents.setOnAction(event->{
    	 String docFN = FirstNameField.getText();
    	 String docLN = LastNameField.getText();
    	 LocalDate BDay = bDay.getValue();
    	 String BDAY = BDay.toString();
    	 String filename = "D" + " " + docFN + " " + docLN + " " + BDAY;
    	 display(primaryStage, filename);
    	 });
    	 send.setOnAction(event->{
    	 String MESSAGE = messageField.getText();
    	 String docFN = FirstNameField.getText();
    	 String docLN = LastNameField.getText();
    	 LocalDate BDay = bDay.getValue();
    	 String BDAY = BDay.toString();
    	 String filename = "D" + " " + docFN + " " + docLN + " " + BDAY;
    	 boolean found = search(filename);
    	 if(found) {
    	 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true))){
    	 writer.newLine();
    	 writer.write(fn + " " + ln +": " + MESSAGE);
    	 }
    	 catch (IOException ex) {
    	 ex.printStackTrace();
    	 }
    	 }
    	 });

    	 Scene patientScreen = new Scene(grid, 800, 600);
    	 primaryStage.setScene(patientScreen);
    	 }
    
    private void doctorMessageScreen(String fn, String ln, String bd, String filename) {
    	System.out.print(filename);
   	 GridPane grid = new GridPane();
   	 grid.setAlignment(Pos.CENTER);
   	 grid.setHgap(20);
   	 grid.setVgap(10);
   	 grid.setPadding(new Insets(25, 25, 25, 25));
   	 

   	 Label FirstName = new Label("Patient First Name:");
   	 grid.add(FirstName, 0, 1);
   	 TextField FirstNameField = new TextField();
   	 grid.add(FirstNameField, 1, 1);
   	 
   	 Label LastName = new Label("Patient Last Name:");
   	 grid.add(LastName, 0, 2);
   	 TextField LastNameField = new TextField();
   	 grid.add(LastNameField, 1, 2);
   	 
   	 Label bday = new Label("Patient Birthday: ");
   	 grid.add(bday, 0, 3);
   	 DatePicker bDay = new DatePicker();
   	 grid.add(bDay, 1, 3);
   	 
   	 Button send = new Button("Send");
   	 grid.add(send, 2, 1);
   	 
   	 Label message = new Label("Message: ");
   	 grid.add(message, 0, 4);
   	 TextField messageField = new TextField();
   	 grid.add(messageField, 1, 4);
   	 
   	 Button back = new Button("Back");
   	 grid.add(back, 2, 6);
   	 back.setOnAction(event -> {
   		 showDoctorScreen(fn, filename);
   	 });
   	 
   	 Button recents = new Button("View Recent Messages");
   	 grid.add(recents, 1, 6);
   	 recents.setOnAction(event->{
   	 String docFN = FirstNameField.getText();
   	 String docLN = LastNameField.getText();
   	 LocalDate BDay = bDay.getValue();
   	 String BDAY = BDay.toString();
   	 display(primaryStage, filename);
   	 });
   	 send.setOnAction(event->{
   	 String MESSAGE = messageField.getText();
   	 String docFN = FirstNameField.getText();
   	 String docLN = LastNameField.getText();
   	 LocalDate BDay = bDay.getValue();
   	 String BDAY = BDay.toString();
   	 boolean found = search(filename);
   	 if(found) {
   	 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true))){
   	 writer.newLine();
   	 writer.write(filename + ": " + MESSAGE);
   	 }
   	 catch (IOException ex) {
   	 ex.printStackTrace();
   	 }
   	 }
   	 });

   	 Scene patientScreen = new Scene(grid, 800, 600);
   	 primaryStage.setScene(patientScreen);
   	 }
    
    private void savePatientInfoToFile(String fn, String ln, String bd, String numb, String email, String insurance, String pharmacy) {
    	String filename = "P" + " " + fn + " " + ln + " " + bd;
    	boolean found = search(filename);
        if(found) {
        	try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))){
        		writer.write(numb);
        		writer.newLine();
        		writer.write(email);
        		writer.newLine();
        		writer.write(insurance);
        		writer.newLine();
        		writer.write(pharmacy);
        	}
        	catch (IOException ex) {
        		ex.printStackTrace();
        	}
        } else
        	showAlert("Error", "Account not found");
    	
    }
    //create 
    private void showDoctorScreen(String firstName, String filename) {
        // Create the layout for the doctor screen
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add labels and text fields for First Name, Last Name, Prescription, and Doctor Note
        Label firstNameLabel = new Label("First Name:");
        firstNameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        grid.add(firstNameLabel, 0, 0);
        TextField firstNameField = new TextField();
        grid.add(firstNameField, 1, 0);

        Label lastNameLabel = new Label("Last Name:");
        lastNameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        grid.add(lastNameLabel, 0, 1);
        TextField lastNameField = new TextField();
        grid.add(lastNameField, 1, 1);
        
        Label Date = new Label("Birthday:");
        Date.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        grid.add(Date, 0, 2);
        DatePicker date = new DatePicker();
        grid.add(date, 1, 2);

        	
        
        
        Label prescriptionLabel = new Label("Prescription:");
        prescriptionLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        grid.add(prescriptionLabel, 0, 3);
        TextField prescriptionField = new TextField();
        grid.add(prescriptionField, 1, 3);

        Label doctorNoteLabel = new Label("Doctor Note:");
        doctorNoteLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        grid.add(doctorNoteLabel, 0, 4);
        TextField doctorNoteField = new TextField();
        grid.add(doctorNoteField, 1, 4);

        // Read pharmacy name from the file
        createPharmacyFile();
        String pharmacyName = readPharmacyNameFromFile("pharmacy.txt");

        Label pharmacyNameLabel = new Label("Pharmacy Name:");
        pharmacyNameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        grid.add(pharmacyNameLabel, 0, 5);

        Label pharmacyValueLabel = new Label(pharmacyName);
        grid.add(pharmacyValueLabel, 1, 5);
        
        
        Button save = new Button("Save");
        grid.add(save, 1, 6);
        save.setOnAction(event -> {
            String fn = firstNameField.getText();
            String ln = lastNameField.getText();
            String pe = prescriptionField.getText();
            String pha = pharmacyValueLabel.getText();
            String note = doctorNoteField.getText();
            LocalDate birth = date.getValue();
            String bday = birth.toString();
            
            saveInfoToFile(fn, ln, pe, pha, note, bday);
        });
        
        Button messagePatientButton = new Button("Message Patient");
        grid.add(messagePatientButton, 0, 8, 2, 1); // Spanning two columns
        messagePatientButton.setOnAction(event -> {
        	String fn = firstNameField.getText();
            String ln = lastNameField.getText();
            LocalDate birth = date.getValue();
            String bday = birth.toString();
            doctorMessageScreen(fn, ln, bday, filename);
        });

        
        // Add a back button
        Button backButton = new Button("Back");
        grid.add(backButton, 0, 6, 2, 1); // Spanning two columns
        backButton.setOnAction(event -> showDoctorLoginWindow("Doctor")); // Action to go back to doctor login

        // Create the scene for the doctor screen
        Scene doctorScreen = new Scene(grid, 600, 400);

        // Set the scene to the primary stage
        primaryStage.setScene(doctorScreen);
    }
    private void createPharmacyFile() {
        File file = new File("pharmacy.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("pharmacy.txt file created successfully.");
            } else {
                System.out.println("pharmacy.txt file already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating pharmacy.txt file: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pharmacy.txt", true))) {
            writer.write("Pharmacy: Walgreens");
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveMessageToFile(String patientName, String messageContent) {
        try {
            // Extract the first name from the patient's full name
            String[] nameParts = patientName.split(" ");
            String firstName = nameParts[0];

            // Create a file with the patient's first name
            String fileName = firstName + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            // Write patient name, message content, and a separator to the file
            writer.write("Patient: " + patientName);
            writer.newLine();
            writer.write("Message: " + messageContent);
            writer.newLine();
            writer.write("----------------------------------------");
            writer.newLine();

            // Close the writer
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void saveInfoToFile(String first, String last, String prescription, String pharmacy, String notes, String bday) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("P " + first + " " + last + " " + bday, true))) {
            // Write phone, email, prescription, and pharmacy to the file
        	writer.write("----------------------------------------");
            writer.newLine();
            writer.write("Doctor Entry:");
            writer.newLine();
        	writer.write("First Name: " + first);
            writer.newLine();
            writer.write("Last Name: " + last);
            writer.newLine();
            writer.write("Prescription: " + prescription);
            writer.newLine();
            writer.write("Pharmacy: " + pharmacy);
            writer.newLine();
            writer.write("Doctor Notes: " + notes);
            writer.newLine();
            writer.write("----------------------------------------");
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private String readPharmacyNameFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Pharmacy:")) {
                    // Extract pharmacy name from the line
                    return line.substring("Pharmacy:".length()).trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Pharmacy Not Found"; // Return a default value if pharmacy name not found
    }
    
    
    
    private void saveAllInformationToFile(String firstName, String lastName, LocalDate initialDate, String messageContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("patient.txt", true))) {
            // Write all information to the file
            writer.write("Patient Name: " + firstName + " " + lastName);
            writer.newLine();
            writer.write("Initial Date Added: " + initialDate);
            writer.newLine();
            writer.write("Message:");
            writer.newLine();
            writer.write(messageContent);
            writer.newLine();
            writer.write("----------------------------------------");
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void showNurseScreen()  {
    	GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label pFName = new Label("Enter Patient's First Name:");
        grid.add(pFName, 0, 1);
        TextField pFNameText = new TextField();
        grid.add(pFNameText, 1, 1);
        
        Label pLName = new Label("Enter Patient's Last Name:");
        grid.add(pLName, 0, 2);
        TextField pLNameText = new TextField();
        grid.add(pLNameText, 1, 2);
        
        Label pBDay = new Label("Enter Patient's Birth Date:");
        grid.add(pBDay, 0, 3);
        DatePicker pBDayText = new DatePicker();
        grid.add(pBDayText, 1, 3);
        
        Button submit = new Button("Submit");
        grid.add(submit, 1, 4);
        submit.setOnAction(event -> {
            String first = pFNameText.getText();
            String last = pLNameText.getText();
            LocalDate date = pBDayText.getValue();
            String bday = date.toString();
        
            String filename = "P " + first + " " + last + " " + bday;
            //System.out.print(filename);
            boolean found = search(filename);
            if(found) {
            	showNurseCrossroad(filename);
            } else
            	showAlert("Error", "Patient not found");            
        });
        
        
        Scene nurseScreen = new Scene(grid, 400, 300);
        primaryStage.setScene(nurseScreen);
        
        Button logout = new Button("Logout");
        grid.add(logout, 0, 4);
        logout.setOnAction(event-> primaryStage.setScene(createMainScene()));
    	
    }
    
    public void showNurseCrossroad(String filename) {
    	GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Button current = new Button("Log Current Visit");
        grid.add(current, 1, 1);
        current.setOnAction(event -> {
        	showNurseDiagnosticForm(filename);
        });

        Button history = new Button("Patient History");
        grid.add(history, 1, 2);
        history.setOnAction(event -> {
        	display(primaryStage, filename);
        });
        
        Button back = new Button("Back");
        grid.add(back, 0, 2);
        back.setOnAction(event -> {
        	showNurseScreen();
        });
        
        Scene nurseScreen = new Scene(grid, 400, 300);
        primaryStage.setScene(nurseScreen);
    }
    
    public void display(Stage primaryStage, String filename) {
        try {
            String content = readFileContent(filename); 
            TextArea textArea = new TextArea(content);
            textArea.setEditable(false);

            StackPane root = new StackPane();
            root.getChildren().add(textArea);

            Scene scene = new Scene(root, 400, 600); 

            Stage newStage = new Stage();
            newStage.setTitle("File Content");
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String readFileContent(String filename) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("\n");
            }
        }
        return contentBuilder.toString();
    }

    public void showNurseDiagnosticForm(String filename) {
    	GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Label Height = new Label("Enter Patient's Height:");
        grid.add(Height, 0, 1);
        TextField HeightText = new TextField();
        grid.add(HeightText, 1, 1);
        
        Label Weight = new Label("Enter Patient's Weight:");
        grid.add(Weight, 0, 2);
        TextField WeightText = new TextField();
        grid.add(WeightText, 1, 2);
        
        Label BloodPressure = new Label("Enter Patient's Blood Pressure:");
        grid.add(BloodPressure, 0, 3);
        TextField BloodPressureText = new TextField();
        grid.add(BloodPressureText, 1, 3);
        
        Label BloodOxygen = new Label("Enter Patient's Blood Oxygen:");
        grid.add(BloodOxygen, 0, 4);
        TextField BloodOxygenText = new TextField();
        grid.add(BloodOxygenText, 1, 4);
        
        Label HeartRate = new Label("Enter Patient's Heart Rate:");
        grid.add(HeartRate, 0, 5);
        TextField HeartRateText = new TextField();
        grid.add(HeartRateText, 1, 5);
        
        Label DateVisit = new Label("Enter Date of Visit:");
        grid.add(DateVisit, 0, 6);
        DatePicker DateVisitText = new DatePicker();
        grid.add(DateVisitText, 1, 6);
        
        TextArea textArea = new TextArea();
        textArea.setPrefHeight(400);
        textArea.setPrefWidth(300);
        textArea.setPromptText("Enter reason for visit here...");
        grid.add(textArea, 0, 7);

        Button submit = new Button("Submit");
        grid.add(submit, 1, 7);
        submit.setOnAction(event->{
        	String height = HeightText.getText();
        	String weight = WeightText.getText();
        	String bloodPressure = BloodPressureText.getText();
        	String bloodOxygen = BloodOxygenText.getText();
        	String heartRate = HeartRateText.getText();
        	LocalDate dateVisit = DateVisitText.getValue();
        	String date = dateVisit.toString();
        	String notes = textArea.getText();
        	
        	saveNurseDiagnostic(filename, height, weight, bloodPressure, bloodOxygen, heartRate, notes, date);
        	
        	
        });
        Button back = new Button("Back");
        grid.add(back, 1, 8);
        back.setOnAction(event -> { showNurseCrossroad(filename);
        });
        
    	Scene patientInfoScreen = new Scene(grid, 600, 400);
        primaryStage.setScene(patientInfoScreen);
    }
    private void saveNurseDiagnostic(String filename, String height, String weight, String bloodPressure, String bloodOxygen, String heartRate, String notes, String date) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
    		writer.newLine();
    		writer.write("----------------------------------------");
            writer.newLine();
            writer.write("Nurse Entry:");
    		writer.newLine();
    		writer.write("Height: " + height);
	        writer.newLine();
	        writer.write("Weight: " + weight);
	        writer.newLine();
	        writer.write("Blood Pressure:  " + bloodPressure);
	        writer.newLine();
	        writer.write("Blood Oxygen:  " + bloodOxygen);
	        writer.newLine();
	        writer.write("Heart Rate:  " + heartRate);
	        writer.newLine();
	        writer.write("Visit Notes:  " + notes);
	        writer.newLine();
	        writer.write("Date Submitted:  " + date);
	        writer.newLine();
	        writer.write("----------------------------------------");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
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
