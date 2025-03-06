package Test;

import Test.Singleton;

public abstract class Contact {

    int id;
    String firstName;
    String lastName;
    String address;

    public Contact(String name, String firstName, String lastName, String address) {
        this.id = Singleton.getInstance().getNextId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public abstract String getDetails();

    abstract void create();

    @Override
    public String toString() {
        return "ID: " + id +
                ", Vorname: " + firstName +
                ", Nachname: " + lastName +
                ", Adresse: " + address +
                ", Details: " + getDetails();
    }
}
