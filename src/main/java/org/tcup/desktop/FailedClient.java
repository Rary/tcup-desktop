package org.tcup.desktop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FailedClient extends Application {
    private static String title;

    private static String message;

    public static String getTitle() {
        return title;
    }

    public static String getMessage() {
        return message;
    }

    public static void prepare(String title, String message) {
        FailedClient.title = title == null ? "Error" : title;   // TODO i18n
        FailedClient.message = message == null ? "An unknown error has occurred. The application cannot be run at this time." : message;    // TODO i18n
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text messageText = new Text(message);
        grid.add(messageText, 0, 0);

        Scene scene = new Scene(grid);
        scene.getStylesheets().add(this.getClass().getResource("styles/main.css").toExternalForm());

        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
