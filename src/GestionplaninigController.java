

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Planing;
import entities.Rendezvous;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
 * @author Balcem
 */
public class GestionplaninigController implements Initializable {

    @FXML
    private TextField daterdvTF;
    @FXML
    private TextField heureTF;
    @FXML
    private TextField prixTF;
    @FXML
    private Button Ajouter;
    @FXML
    private TableView<Planing> TVPlaning;
    @FXML
    private TableColumn<?, ?> TVid;
    @FXML
    private TableColumn<?, ?> TVdaterdv;
    @FXML
    private TableColumn<?, ?> TVheure;
    @FXML
    private TableColumn<?, ?> TVprix;
    @FXML
    private Button Supprimer;
    @FXML
    private Button Modifier;
    @FXML
    private Button SearchBTN;
    @FXML
    private TextField SearchTF;
    @FXML
    private ComboBox<String> TFetatRDV;
    @FXML
    private ComboBox<Rendezvous> CBrdv;
    @FXML
    private Button toRDV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        RendezvousCRUD k=new RendezvousCRUD();
        CBrdv.getItems().addAll(k.Afficher());
        TFetatRDV.getItems().removeAll(TFetatRDV.getItems());
        TFetatRDV.getItems().add("Validé");
        TFetatRDV.getItems().add("Non Validé");
        PlaningCRUD service=new PlaningCRUD();
            ObservableList<Planing> list =service.AfficherPlaning();
            System.out.print(list);
            refreshtable(list);
            
    }    

    @FXML
    private void AjouterPlaning(ActionEvent event) {
        PlaningCRUD service=new PlaningCRUD();
        Planing p = new Planing();
        if((!"".equals(daterdvTF.getText()))&&(!"".equals(heureTF.getText()))&&((!"".equals(prixTF.getText()))))
                {   //p.setId_UserP(1);
                    //p.setId_service(1);
                    p.setHeurejoingabilites(heureTF.getText());
                    p.setDateRendezvous(""+CBrdv.getSelectionModel().getSelectedItem().getId());
                    p.setPrix(Integer.valueOf(prixTF.getText()));
                    service.ajouterPlaning(p);
                    ObservableList<Planing> list =service.AfficherPlaning();
            refreshtable(list);
                    
                }else
        {    
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Fill all fields !");
                alert.showAndWait();
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        Planing usr = TVPlaning.getSelectionModel().getSelectedItem();
        if(usr==null){Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setHeaderText(null);
                 alert.setContentText("You haven't selected any Planing to delete!");
                 alert.showAndWait();}
        else{
          PlaningCRUD service=new PlaningCRUD();
          if(service.supprimerPlaning(usr.getIdP()))
          {      Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setHeaderText(null);
                 alert.setContentText("You have deleted Planing :"+usr.getIdP()+ "!");
                 alert.showAndWait();
                 refreshtable(service.AfficherPlaning());
          }else
          {
              Alert alert = new Alert(AlertType.INFORMATION);
                 alert.setTitle("Error");
                 alert.setHeaderText(null);
                 alert.setContentText(" Oops ,Something went Wrong ! ");
                 alert.showAndWait();
          }
        }
    }

    @FXML
    private void Modifier(ActionEvent event) {
        PlaningCRUD service=new PlaningCRUD();
                Planing p = TVPlaning.getSelectionModel().getSelectedItem();

        if((!"".equals(daterdvTF.getText()))&&(!"".equals(heureTF.getText()))&&((!"".equals(prixTF.getText()))))
                {
                    p.setHeurejoingabilites(heureTF.getText());
                    p.setDateRendezvous(""+CBrdv.getSelectionModel().getSelectedItem().getId());
                    p.setPrix(Integer.valueOf(prixTF.getText()));
                    service.modifierPlaning(p);
                    ObservableList<Planing> list =service.AfficherPlaning();
            refreshtable(list);
                }else
              {    
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Fill all fields !");
                alert.showAndWait();
              }
    }

    @FXML
    private void Search(ActionEvent event) {
                PlaningCRUD service=new PlaningCRUD();
        refreshtable(service.search(SearchTF.getText()));
    }
    
    public void refreshtable(ObservableList<Planing> list){
           
          TVid.setCellValueFactory(new PropertyValueFactory<>("idP"));
          TVdaterdv.setCellValueFactory(new PropertyValueFactory<>("RDV"));
          TVheure.setCellValueFactory(new PropertyValueFactory<>("heurejoingabilites"));
          TVprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
          
          TVPlaning.setItems(list);
    
    }

    @FXML
    private void toRDV(ActionEvent event) {
         Parent root;
         Stage stage;
        try {
             root=FXMLLoader.load(getClass().getResource("FXMLrendezvous.fxml"));
             Scene scene = new Scene(root);
        stage = (Stage) Ajouter.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}