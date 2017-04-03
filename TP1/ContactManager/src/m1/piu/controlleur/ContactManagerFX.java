package m1.piu.controlleur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;


/**
 *
 * @author adesv
 */
public class ContactManagerFX extends Application {
    
    private URL path;
    private AnchorPane mainFrame;
    private AnchorPane menuBar;
    private Pane selectedContact;
    private Pane gestionContact;
    private Pane mainPanel;
    private TitledPane adressBook;
    private TitledPane contactList;
    private TitledPane contactDetails;
    
    @Override
    public void start(Stage stage) throws Exception {

    
    /* Test multiple controller */
    
    FXMLLoader loader = new FXMLLoader();                

            /* Main Frame */
            path = getClass().getResource("/m1/piu/view/FXMLMainFrame.fxml");
            try {
                loader.setLocation(path);            
                mainFrame = (AnchorPane) loader.load();
            } catch (IOException e){
                System.out.println("Not found: " + path);
                e.printStackTrace();
            }        

            loader.setRoot(null);
            loader.setController(null);
            loader.setResources(null);
            loader.getNamespace().clear();  
            
            /* Menu Bar */
            path = getClass().getResource("/m1/piu/view/frameElement/FXMLMenuBar.fxml");  
            try {
                loader.setLocation(path);
                menuBar = (AnchorPane) loader.load();
            } catch (IOException e){
                System.out.println("Not found: " + path);
                e.printStackTrace();
            }

            loader.setRoot(null);
            loader.setController(null);
            loader.setResources(null);
            loader.getNamespace().clear();  
            
            /* Selected Contact */
            path = getClass().getResource("/m1/piu/view/frameElement/FXMLSelectedContact.fxml");  
            try {
                loader.setLocation(path);
                selectedContact = (Pane) loader.load();
            } catch (IOException e){
                System.out.println("Not found: " + path);
                e.printStackTrace();
            }
    
            loader.setRoot(null);
            loader.setController(null);
            loader.setResources(null);
            loader.getNamespace().clear(); 
            
            /* Gestion Contact */
            path = getClass().getResource("/m1/piu/view/frameElement/FXMLGestionContact.fxml");  
            try {
                loader.setLocation(path);
                gestionContact = (Pane) loader.load();
            } catch (IOException e){
                System.out.println("Not found: " + path);
                e.printStackTrace();
            }
    
            loader.setRoot(null);
            loader.setController(null);
            loader.setResources(null);
            loader.getNamespace().clear(); 
            
            /* Main Panel */
            path = getClass().getResource("/m1/piu/view/frameElement/FXMLMainPanel.fxml");  
            try {
                loader.setLocation(path);
                mainPanel = (Pane) loader.load();
            } catch (IOException e){
                System.out.println("Not found: " + path);
                e.printStackTrace();
            }
            
            loader.setRoot(null);
            loader.setController(null);
            loader.setResources(null);
            loader.getNamespace().clear();   
            
            /* Adress Book */
            path = getClass().getResource("/m1/piu/view/mainPanel/FXMLAdressBook.fxml");  
            try {
                loader.setLocation(path);
                adressBook = (TitledPane) loader.load();
            } catch (IOException e){
                System.out.println("Not found: " + path);
                e.printStackTrace();
            }

            loader.setRoot(null);
            loader.setController(null);
            loader.setResources(null);
            loader.getNamespace().clear();   
            
            /* Contact List */
            
            path = getClass().getResource("/m1/piu/view/mainPanel/FXMLContactList.fxml");  
            try {
                loader.setLocation(path);
                contactList = (TitledPane) loader.load();
            } catch (IOException e){
                System.out.println("Not found: " + path);
                e.printStackTrace();
            }
 
            loader.setRoot(null);
            loader.setController(null);
            loader.setResources(null);
            loader.getNamespace().clear();   
            
            /* Contact Details */
            
            path = getClass().getResource("/m1/piu/view/mainPanel/FXMLContactDetails.fxml");  
            try {
                loader.setLocation(path);
                contactDetails = (TitledPane) loader.load();
            } catch (IOException e){
                System.out.println("Not found: " + path);
                e.printStackTrace();
            }
            
            mainPanel.getChildren().add(adressBook);
            mainPanel.getChildren().add(contactList);
            mainPanel.getChildren().add(contactDetails);

            mainFrame.getChildren().add(selectedContact);
            mainFrame.getChildren().add(menuBar);
            mainFrame.getChildren().add(gestionContact);
            mainFrame.getChildren().add(mainPanel);

            Scene scene = new Scene(mainFrame);        
            
            stage.getIcons().add(new Image("/m1/piu/images/pictoPersonneGood.png"));
            stage.setTitle("Contact Manager");
            stage.setScene(scene);
            stage.show();
    }
    
    /* Fin test */
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
