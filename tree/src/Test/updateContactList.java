package Test;

import javax.swing.*;
import java.awt.*;

public class updateContactList {
    private Label textArea;

    private void updateContactList() {
        textArea.setText("");
        for (Contact contact : ContactManager.contactList) {
            textArea.setText(contact.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ContactManagerMVC::new);
    }
}