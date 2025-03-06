package Test2;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

class PersonController {
    private List<Person2> personen;
    private DefaultTableModel tableModel;

    public PersonController(DefaultTableModel tableModel) {
        this.personen = new ArrayList<>();
        this.tableModel = tableModel;
    }

    public void addPerson(Person2 person2) {
        personen.add(person2);
        updateTable();
    }

    public void deletePersonById(int id) {
        personen.removeIf(person -> person.getId() == id);
        updateTable();
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Person2 person2 : personen) {
            tableModel.addRow(new Object[]{person2.getVorname(), person2.getNachname(), person2.getAdresse(), person2.getId(), person2.getTyp()});
        }
    }
}