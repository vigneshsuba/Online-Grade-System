package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Grade Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setVgap(20);
        grid.setHgap(20);
        
        Label NameLabel1 = new Label("Enter Candidate name");
        GridPane.setConstraints(NameLabel1, 0, 0);

        TextField NameInput1 = new TextField();
        GridPane.setConstraints(NameInput1, 1, 0);

        Label cgpaLabel = new Label("Enter CGPA:");
        GridPane.setConstraints(cgpaLabel, 0, 1);

        TextField cgpaInput = new TextField();
        GridPane.setConstraints(cgpaInput, 1, 1);

        Button calculateButton = new Button("Calculate Grade");
        GridPane.setConstraints(calculateButton, 1, 2);

        Label resultLabel1 = new Label();
        GridPane.setConstraints(resultLabel1, 1, 3);
        Label resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 1, 4);

        calculateButton.setOnAction(e -> {
            try {
                double cgpa = Double.parseDouble(cgpaInput.getText());
                String Name = NameInput1.getText();
                String grade = calculateGrade(cgpa);
                resultLabel1.setText("Candidate Name: "+Name);
                resultLabel.setText("Your Grade    : " + grade);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid CGPA");
            }
        });

        grid.getChildren().addAll(cgpaLabel,NameLabel1, NameInput1,cgpaInput, calculateButton, resultLabel1,resultLabel);

        Scene scene = new Scene(grid, 500, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private String calculateGrade(double cgpa) {
        // Add your grading logic here
        // For simplicity, a basic example is provided
        if (cgpa >= 9.0) {
            return "O";
        } else if (cgpa >= 8.0) {
            return "A+";
        } else if (cgpa >= 7.0) {
            return "A";
        } else if(cgpa>=6.0) {
            return "B+";
        } else if (cgpa >= 5.0) {
            return "B+";
        } else {
            return "Fail Nil grade";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}