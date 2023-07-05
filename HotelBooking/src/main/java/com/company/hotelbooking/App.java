package com.company.hotelbooking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import static javafx.application.Application.launch;

public class App extends Application {

    double x,y = 0;

    @Override
    public void start(Stage primstage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));

        primstage.initStyle(StageStyle.UNDECORATED);

        scene.setOnMousePressed(event ->{
            x = event.getSceneX();
            y = event.getSceneY();
        });

        scene.setOnMouseDragged(event ->{
            primstage.setX(event.getScreenX() - x);
            primstage.setY(event.getScreenY() - y);
        });

        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());


        primstage.setScene(scene);
        primstage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}