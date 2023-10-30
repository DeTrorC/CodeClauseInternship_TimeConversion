import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConversionGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Time Zone Conversion Tool");

        // Create a VBox to hold the UI components
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        
        // Create labels and dropdowns for time zone selection
        Label localTimeZoneLabel = new Label("Select your local time zone:");
        ComboBox<String> localTimeZoneComboBox = new ComboBox<>();
        
        Label targetTimeZoneLabel = new Label("Select the target time zone:");
        ComboBox<String> targetTimeZoneComboBox = new ComboBox<>();

        // List of time zones (you can extend this list)
        String[] allTimeZones = {
            "America/New_York",
            "America/Los_Angeles",
            "Europe/London",
            // Add more time zones here
        };

        localTimeZoneComboBox.getItems().addAll(allTimeZones);
        targetTimeZoneComboBox.getItems().addAll(allTimeZones);

        // Create labels to display results
        Label localTimeLabel = new Label("Your Local Time:");
        Label localTimeResult = new Label();

        Label targetTimeLabel = new Label("Time in Target Zone:");
        Label targetTimeResult = new Label();

        // Create a Convert button
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            String userLocalTimeZone = localTimeZoneComboBox.getValue();
            String targetTimeZone = targetTimeZoneComboBox.getValue();

            ZoneId userLocalZone = ZoneId.of(userLocalTimeZone);
            ZoneId targetZone = ZoneId.of(targetTimeZone);

            ZonedDateTime userLocalTime = ZonedDateTime.now(userLocalZone);
            ZonedDateTime targetTime = userLocalTime.withZoneSameInstant(targetZone);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

            localTimeResult.setText(userLocalTime.format(formatter));
            targetTimeResult.setText(targetTime.format(formatter));
        });

        // Add components to the VBox
        vbox.getChildren().addAll(localTimeZoneLabel, localTimeZoneComboBox, targetTimeZoneLabel, targetTimeZoneComboBox, convertButton, localTimeLabel, localTimeResult, targetTimeLabel, targetTimeResult);

        // Create a scene and set it on the stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }
}
