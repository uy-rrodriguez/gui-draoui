package m1.piu.controlleur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author adesv
 */
public class FXMLGestionContactController implements Initializable {
    
    private URL path;
    private Pane contactPanel;
    
    @FXML
    private Label label;
    
    @FXML
    private Button newContactButton;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //System.out.print("herrree buttttonnnn");
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        newContactButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader();  
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                path = getClass().getResource("/m1/piu/view/addFrame/FXMLContactPanel.fxml");
                try {
                    loader.setLocation(path);            
                    contactPanel = (Pane) loader.load();
                } catch (IOException e){
                    System.out.println("FXML pas trouvé: " + path);
                    e.printStackTrace();
                }        
            
                Scene scene = new Scene(contactPanel);
                stage.getIcons().add(new Image("/m1/piu/images/icone.png"));
                stage.setTitle("Ajouter contact");
                stage.setScene(scene);
                stage.show();
            }
        });
    }    
    
}
