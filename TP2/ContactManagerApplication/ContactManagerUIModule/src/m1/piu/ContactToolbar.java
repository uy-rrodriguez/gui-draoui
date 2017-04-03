/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.AbstractAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

@ActionID(
        category = "Tools",
        id = "m1.piu.ContactToolbar"
)
@ActionRegistration(
        iconBase = "m1/piu/toolbar.png",
        displayName = "#CTL_ContactToolbar"
)
@ActionReference(path = "Toolbars/File", position = 300)
@Messages("CTL_ContactToolbar=ContactToolbar")
public final class ContactToolbar extends AbstractAction
        implements Presenter.Toolbar {

    Component component = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }

    @Override
    public Component getToolbarPresenter() {
        if (component == null) {
            component = new JFXPanel(); //WizPanelController(); //return new JFXPanel controller
            Platform.setImplicitExit(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    createScene();  //standard Swing Interop Pattern
                }
            });
        }
        return component;
        //return new JLabel("Toolbar de test");
    }
    
    private void createScene() {
        try {
            URL location = getClass().getResource("fxml/toolbar.fxml"); //same FXML copied from JavaFX app
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent root = (Parent) fxmlLoader.load(location.openStream());
            Scene scene = new Scene(root);
            
            JFXPanel jfxPanel = (JFXPanel) component;
            jfxPanel.setScene(scene);    

            //component = (WizPanelController) fxmlLoader.getController();
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
