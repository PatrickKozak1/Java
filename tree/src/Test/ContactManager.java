package Test;

import java.util.ArrayList;
import java.util.List;

class ContactManager {
    static List<Contact> contactList = new ArrayList<>();

    public static void addContact(Contact contact) {
        contactList.add(contact);
    }

    public static void deleteContact(int id) {
        contactList.removeIf(contact -> contact.id == id);
    }

    public void showContact() {
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }
}