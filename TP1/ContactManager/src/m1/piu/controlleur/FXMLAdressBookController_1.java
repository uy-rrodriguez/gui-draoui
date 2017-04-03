package m1.piu.controlleur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author adesv
 */
public class FXMLAdressBookController_1 implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML 
    private ListView<String> adressBookListView;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> items = adressBookListView.getItems();
        items.add("Aurelien Desvillettes");
        items.add("Ricardo Rodriguez");
        items.add("Thomas Meunier");
        items.add("Edison Cavani");
        items.add("Zlatan Ibrahimovic");
    }    
    
}
