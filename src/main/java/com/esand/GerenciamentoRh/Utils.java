package com.esand.GerenciamentoRh;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Utils {

    public static void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERRO");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void loadChildrenFXML( Pane contentPane, String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Utils.class.getResource("/" + fxml));
            Pane pane = fxmlLoader.load();
            contentPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFXML(Object classe, String fxml, TextField textField) {
        try {
            FXMLLoader loader = new FXMLLoader(classe.getClass().getResource("/" + fxml));
            Parent root = loader.load();

            Stage stage = (Stage) textField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            centerStage(stage);
            stage.show();

        } catch (RuntimeException e) {
            showErrorMessage("Erro ao carregar a interface.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void centerStage(Stage stage) {
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();

        double windowWidth = stage.getWidth();
        double windowHeight = stage.getHeight();

        double x = (screenWidth - windowWidth) / 2;
        double y = (screenHeight - windowHeight) / 2;

        stage.setX(x);
        stage.setY(y);
    }
}
