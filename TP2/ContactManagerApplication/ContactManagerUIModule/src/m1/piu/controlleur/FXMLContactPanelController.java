package m1.piu.controlleur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author adesv
 */
public class FXMLContactPanelController implements Initializable {
    
    private URL path;
    private Pane newPhoneNumber;
    
    @FXML
    private Label label;
    
    @FXML
    private Button newPhoneNumberButton;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        newPhoneNumberButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader();  
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                path = getClass().getResource("/m1/piu/view/addFrame/FXMLNewPhoneNumber.fxml");
                try {
                    loader.setLocation(path);            
                    newPhoneNumber = (Pane) loader.load();
                } catch (IOException e){
                    System.out.println("Not found: " + path);
                    e.printStackTrace();
                }        
                stage.getIcons().add(new Image("/m1/piu/images/icone.png"));
                stage.setTitle("Add Phone Number");
                Scene scene = new Scene(newPhoneNumber);
                stage.setScene(scene);
                stage.show();
            }
        });

    }    
    
}
