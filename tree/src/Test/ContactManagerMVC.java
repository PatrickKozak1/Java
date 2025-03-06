package Test;

import javax.swing.*;
import java.awt.*;

public class ContactManagerMVC {
    private ContactManager contactManager;
    private JFrame frame;
    private JTextArea textArea;
    private JTextField firstNameField, lastNameField, addressField, typeField;

    public ContactManagerMVC() {
        contactManager = new ContactManager();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Kontaktverwaltung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Vorname:"));
        firstNameField = new JTextField();
        panel.add(firstNameField);

        panel.add(new JLabel("Nachname:"));
        lastNameField = new JTextField();
        panel.add(lastNameField);

        panel.add(new JLabel("Adresse:"));
        addressField = new JTextField();
        panel.add(addressField);

        panel.add(new JLabel("Typ (freund/verwandt):"));
        typeField = new JTextField();
        panel.add(typeField);

        JButton addButton = new JButton("Hinzufügen");
        addButton.addActionListener(new AddContactAction());
        panel.add(addButton);

        JButton deleteButton = new JButton("Löschen");
        deleteButton.addActionListener(new DeleteContactAction());
        panel.add(deleteButton);

        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}