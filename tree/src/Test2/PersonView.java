package Test2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonView extends JFrame {
    private JTextField vornameField;
    private JTextField nachnameField;
    private JTextField adresseField;
    private JTextField idField;
    private JComboBox<String> typComboBox;
    private JButton addButton;
    private JButton deleteButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private PersonController controller;

    public PersonView() {
        setTitle("Personenverwaltung");
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"Vorname", "Nachname", "Adresse", "ID", "Typ"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        vornameField = new JTextField(10);
        nachnameField = new JTextField(10);
        adresseField = new JTextField(10);
        idField = new JTextField(10);
        typComboBox = new JComboBox<>(new String[]{"friend", "relative"});
        addButton = new JButton("Hinzufügen");
        deleteButton = new JButton("Löschen");

        inputPanel.add(new JLabel("Vorname:"));
        inputPanel.add(vornameField);
        inputPanel.add(new JLabel("Nachname:"));
        inputPanel.add(nachnameField);
        inputPanel.add(new JLabel("Adresse:"));
        inputPanel.add(adresseField);
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Typ:"));
        inputPanel.add(typComboBox);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.SOUTH);

        controller = new PersonController(tableModel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vorname = vornameField.getText();
                String nachname = nachnameField.getText();
                String adresse = adresseField.getText();
                String typ = (String) typComboBox.getSelectedItem();
                controller.addPerson(new Person2(vorname, nachname, adresse, typ));
                clearFields();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                controller.deletePersonById(id);
                clearFields();
            }
        });
    }

    private void clearFields() {
        vornameField.setText("");
        nachnameField.setText("");
        adresseField.setText("");
        idField.setText("");
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PersonView view = new PersonView();
            view.setVisible(true);
        });
    }
}