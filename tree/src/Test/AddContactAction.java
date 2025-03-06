package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddContactAction implements ActionListener {
    private Label typeField;
    private Label addressField;
    private Label lastNameField;
    private Label firstNameField;
    private Component frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String type = typeField.getText();

        Contact contact;
        if (type.equalsIgnoreCase("verwandt")) {
            ContactFactory relativeFactory = new RelativeFactory();
            contact = relativeFactory.createContact(firstName, lastName, address);
        } else if (type.equalsIgnoreCase("freund")) {
            ContactFactory friendFactory = new FriendFactory();
            contact = friendFactory.createContact(firstName, lastName, address);
        } else {
            JOptionPane.showMessageDialog(frame, "Unbekannter Typ. Kontakt nicht hinzugefügt.");
            return;
        }
        ContactManager.addContact(contact);
        new updateContactList();
    }
}