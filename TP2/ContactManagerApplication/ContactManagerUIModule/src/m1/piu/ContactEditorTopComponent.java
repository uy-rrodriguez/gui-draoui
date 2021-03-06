/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javax.swing.Icon;
import m1.piu.controlleur.FXMLContactDetailsController;
import m1.piu.controlleur.FXMLContactListController;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.spi.actions.AbstractSavable;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.RequestProcessor;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//m1.piu//ContactEditor//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "ContactEditorTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "m1.piu.ContactEditorTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ContactEditorAction",
        preferredID = "ContactEditorTopComponent"
)
@Messages({
    "CTL_ContactEditorAction=ContactEditor",
    "CTL_ContactEditorTopComponent=ContactEditor Window",
    "HINT_ContactEditorTopComponent=This is a ContactEditor window"
})
public final class ContactEditorTopComponent extends TopComponent {

    private TextField textField;
    
    
    private static JFXPanel jfxPanel;
    private FXMLContactListController controllerContactsList;
    private FXMLContactDetailsController controllerContactDetails;
    
    // Save
    InstanceContent ic = new InstanceContent();
    
    
    public ContactEditorTopComponent() {
        initComponents();
        setName(Bundle.CTL_ContactEditorTopComponent());
        setToolTipText(Bundle.HINT_ContactEditorTopComponent());
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);

        setLayout(new BorderLayout());
        init();
        
        
        // Enregistrement d'un élément à sauvegarder pour faire des tests
        associateLookup(new AbstractLookup(ic));
        if (getLookup().lookup(MySavable.class) == null) {
            ic.add(new MySavable());
        }
    }
    
    private void init() {
        jfxPanel = new JFXPanel(); //WizPanelController(); //return new JFXPanel controller
        
        Platform.setImplicitExit(false);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                createScene();  //standard Swing Interop Pattern
            }
        });
        
        add(jfxPanel);
    }
    
    private void createScene() {
        try {
            GridPane grid = new GridPane();
            
            URL location = getClass().getResource("view/mainPanel/FXMLContactList.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent contactsList = (Parent) fxmlLoader.load(location.openStream());
            
            controllerContactsList = (FXMLContactListController) fxmlLoader.getController();
            grid.add(contactsList, 0, 0);
            
            
            location = getClass().getResource("view/mainPanel/FXMLContactDetails.fxml");
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent contactDetails = (Parent) fxmlLoader.load(location.openStream());
            
            controllerContactDetails = (FXMLContactDetailsController) fxmlLoader.getController();
            grid.add(contactDetails, 0, 1);
            
            /*
            textField = new TextField();
            grid.add(textField, 1, 0);
            */
            
            Scene scene = new Scene(grid);
            
            jfxPanel.setScene(scene);
        }
        catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
    
    
    
 
    /**
     * Classe MySavable pour implémenter la fonction de Sauvegarde 
     */
    
    //private static final Icon ICON = ImageUtilities.loadImageIcon("../fxml/toolbar.png", true);
 
    private class MySavable extends AbstractSavable /*implements Icon*/ {
        MySavable() {
            register();
        }
 
        @Override
        protected String findDisplayName() {
            return "Test Savable";
        }

        /**
         * Méthode appelée quand on clicke sur File->Save
         * On va afficher une belle barre de progression et on va stocker les données.
         * 
         * @throws IOException 
         */
        @Override
        protected void handleSave() throws IOException {
            
            final MySavable mySavableInstance = this;
            
            // Progress bar
            Runnable myRunnable = new Runnable() {
                @Override
                public void run() {
                    ProgressHandle myProgressHandle = 
                            ProgressHandle.createHandle("Sauvegarde en cours...");
                    myProgressHandle.start(100);
                    
                    //DO TASK HERE
                    
                    // Petite sieste :)
                    try {
                        for (int i = 0; i < 100; i++) {
                            myProgressHandle.progress("Sauvegarde en cours...", i);
                            Thread.sleep((long) 50);
                        }
                    } catch (InterruptedException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                    
                    myProgressHandle.progress("Fichier sauvegardé", 100);
                    myProgressHandle.finish();
                    
                    
                    // On supprime l'objet Savable, ce qui dit à Netbeans
                    // que l'objet à été stocké
                    tc().ic.remove(mySavableInstance);
                    mySavableInstance.unregister();
                    
                    // On le crée à nouveau pour faire des tests
                    ic.add(new MySavable());
                }
            };
            RequestProcessor.Task myTask = RequestProcessor.getDefault().post(myRunnable); 
        }
 
        ContactEditorTopComponent tc() {
            return ContactEditorTopComponent.this;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MySavable) {
                MySavable m = (MySavable)obj;
                return tc() == m.tc();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return tc().hashCode();
        }

        /*
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            ICON.paintIcon(c, g, x, y);
        }

        @Override
        public int getIconWidth() {
            return ICON.getIconWidth();
        }

        @Override
        public int getIconHeight() {
            return ICON.getIconHeight();
        }
        */
    } 
}
