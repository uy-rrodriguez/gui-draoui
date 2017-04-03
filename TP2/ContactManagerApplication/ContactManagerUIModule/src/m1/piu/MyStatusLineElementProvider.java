/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.awt.Component;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.openide.awt.StatusLineElementProvider;
import org.openide.util.Exceptions;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Ricci
 */

@ServiceProvider(service = org.openide.awt.StatusLineElementProvider.class)
public class MyStatusLineElementProvider implements StatusLineElementProvider {
    
    MyStatusBar bar = null;
    
    @Override
    public Component getStatusLineElement() {
        if (bar == null) {
            bar = new MyStatusBar();
            bar.setText("Selected contact : Toto");
        }
        
        return bar;
    }
    
    /*
    @Override
    public Component getStatusLineElement() {
        if (bar == null) {
            bar = new MyStatusBar();

            Platform.setImplicitExit(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    createScene();  //standard Swing Interop Pattern
                }
            });
        }
        
        return bar;
    }
    
    private void createScene() {
        try {
            URL location = getClass().getResource("etat.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent root = (Parent) fxmlLoader.load(location.openStream());
            Scene scene = new Scene(root);
            
            JFXPanel jfxPanel = (JFXPanel) bar;
            jfxPanel.setScene(scene);
        }
        catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    */
}
