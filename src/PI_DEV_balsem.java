/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author MSI GF63
 */
public class PI_DEV_balsem extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
     
           
        Parent root;
        try {
             root=FXMLLoader.load(getClass().getResource("gestionplaninig.fxml"));
             Scene scene = new Scene(root);
        
        primaryStage.setTitle("home");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
