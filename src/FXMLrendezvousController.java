/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Planing;
import entities.Rendezvous;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.PlaningCRUD;
import service.RendezvousCRUD;

/**
 * FXML Controller class
 *
 * @author MSI GF63
 */
public class FXMLrendezvousController implements Initializable {

    @FXML
    private DatePicker TFdate;
    @FXML
    private TextField TFcontrat;
    @FXML
    private Button btnadd;
    @FXML
    private TableView<Rendezvous> TVrdv;
    @FXML
    private TableColumn<?, ?> TVid;
    @FXML
    private TableColumn<?, ?> TVdate;
    @FXML
    private TableColumn<?, ?> TVcontrat;
    @FXML
    private Button btndel;
    @FXML
    private Button btnupdate;
    @FXML
    private Button tfconsult;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           RendezvousCRUD service=new RendezvousCRUD();
            ObservableList<Rendezvous> list =service.Afficher();
            refreshtable(list);
    }    

    @FXML
    private void add(ActionEvent event) {
                   RendezvousCRUD service=new RendezvousCRUD();
               Rendezvous k = new Rendezvous();
               if(TFdate.getValue().toString().equals("")||(TFcontrat.getText().equals(""))){
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setHeaderText(null);
                 alert.setContentText("you have to fill fields");
                 alert.showAndWait();
                   
               }else
               {
                 k.setDate(TFdate.getValue().toString());
                 k.setContrat(TFcontrat.getText());
                 service.ajouter(k);
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Success");
                 alert.setHeaderText(null);
                 alert.setContentText("Success !");
                 alert.showAndWait();
                 refreshtable(service.Afficher());
               }
    }

    @FXML
    private void del(ActionEvent event) {
        Rendezvous usr = TVrdv.getSelectionModel().getSelectedItem();
        if(usr==null){Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setHeaderText(null);
                 alert.setContentText("You haven't selected any Appointment to delete!");
                 alert.showAndWait();}
        else{
          RendezvousCRUD service=new RendezvousCRUD();
          if(service.supprimer(usr.getId()))
          {      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setHeaderText(null);
                 alert.setContentText("You have deleted Planing :"+usr.getId()+ "!");
                 alert.showAndWait();
                 refreshtable(service.Afficher());
          }else
          {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setHeaderText(null);
                 alert.setContentText(" Oops ,Something went Wrong ! ");
                 alert.showAndWait();
          }
        }
    }

    @FXML
    private void update(ActionEvent event) {
              RendezvousCRUD service=new RendezvousCRUD();
               Rendezvous k = TVrdv.getSelectionModel().getSelectedItem();
               if(k==null){Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setHeaderText(null);
                 alert.setContentText("You haven't selected any Appointment to delete!");
                 alert.showAndWait();}
        else{
               if(TFdate.getValue().toString().equals("")||(TFcontrat.getText().equals(""))){
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setHeaderText(null);
                 alert.setContentText("you have to fill fields");
                 alert.showAndWait();
                   
               }else
               {
                 k.setDate(TFdate.getValue().toString());
                 k.setContrat(TFcontrat.getText());
                 service.modifier(k);
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
                 alert.setTitle("Success");
                 alert.setHeaderText(null);
                 alert.setContentText("Success !");
                 alert.showAndWait();
                                  refreshtable(service.Afficher());

               }
        
    }}
    
    public void refreshtable(ObservableList<Rendezvous> list){
           
          TVid.setCellValueFactory(new PropertyValueFactory<>("id"));
          TVdate.setCellValueFactory(new PropertyValueFactory<>("date"));
          TVcontrat.setCellValueFactory(new PropertyValueFactory<>("contrat"));
          
          TVrdv.setItems(list);
    
    }

    @FXML
    private void toPlaning(ActionEvent event) {
        Parent root;
         Stage stage;
        try {
             root=FXMLLoader.load(getClass().getResource("gestionplaninig.fxml"));
             Scene scene = new Scene(root);
        stage = (Stage) tfconsult.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
