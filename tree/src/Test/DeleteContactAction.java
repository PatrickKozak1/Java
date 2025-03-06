package Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteContactAction implements ActionListener {
    private Object frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        String idString = JOptionPane.showInputDialog(frame, "Welche ID?");
        if (idString != null) {
            int id = Integer.parseInt(idString);
            ContactManager.deleteContact(id);
            new updateContactList();
        }
    }
}