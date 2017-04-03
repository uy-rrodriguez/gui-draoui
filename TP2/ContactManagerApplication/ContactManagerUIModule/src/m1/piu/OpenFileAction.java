package m1.piu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.api.progress.ProgressHandle;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.util.RequestProcessor;

@ActionID(category = "File", id = "m1.piu.OpenFileAction")
@ActionRegistration(displayName = "#CTL_OpenFileAction")
@ActionReference(path = "Menu/File", position=10)
@Messages("CTL_OpenFileAction=Open File...")
public final class OpenFileAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // Message
        DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message(
                    "Chargement du fichier en cours.")
            ); 
        
        // Progress bar pour ouvrir un fichier
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                ProgressHandle myProgressHandle = 
                        ProgressHandle.createHandle("Chargement du fichier...");
                myProgressHandle.start(100);

                // Petite sieste :)
                try {
                    for (int i = 0; i < 100; i++) {
                        myProgressHandle.progress("Chargement du fichier...", i);
                        Thread.sleep((long) 50);
                    }
                } catch (InterruptedException ex) {
                    Exceptions.printStackTrace(ex);
                }

                myProgressHandle.progress("Chargement complet", 100);
                myProgressHandle.finish();
            }
        };
        RequestProcessor.Task myTask = RequestProcessor.getDefault().post(myRunnable);
    }
    
}