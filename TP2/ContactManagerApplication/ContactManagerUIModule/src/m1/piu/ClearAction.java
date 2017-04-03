/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "m1.piu.ClearAction"
)
@ActionRegistration(
        displayName = "#CTL_ClearAction"
)
@ActionReference(path = "Menu/File", position = 2150)
@Messages("CTL_ClearAction=Clear")
public final class ClearAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        NotifyDescriptor.Confirmation confirm = new NotifyDescriptor.Confirmation(
                "Êtes-vous sûr de vouloir supprimer tous les contacts ?",
                "Nettoyage de contacts");
        DialogDisplayer.getDefault().notify(confirm); 
        
        if (confirm.getValue() == NotifyDescriptor.YES_OPTION) {
            DialogDisplayer.getDefault().notify(new NotifyDescriptor.Message(
                    "Tous les contacts ont été supprimés")
            ); 
        }
    }
}
