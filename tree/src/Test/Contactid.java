package Test;

import java.util.Scanner;


public class Contactid {
    public static void main(String[] args) {
        ContactManager contactDataManagement=new ContactManager();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Select a command: (add,delete,show,exit)");
            String command=sc.nextLine();
            switch (command) {
                case "add" -> {
                    System.out.println("First Name: ");
                    String firstName = sc.nextLine();
                    System.out.println("Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.println("Address: ");
                    String address = sc.nextLine();
                    System.out.println("Type: (friend/relative)");
                    String type=sc.nextLine();
                    Contact contact;
                    if(type.equalsIgnoreCase("relative")){
                        ContactFactory relativeFactory= new RelativeFactory();
                        contact= relativeFactory.createContact(firstName,lastName,address);
                    }
                    else if(type.equalsIgnoreCase("friend")){
                        ContactFactory friendFactory= new FriendFactory();
                        contact= friendFactory.createContact(firstName,lastName,address);
                    }
                    else{
                        System.out.println("Type not known. Contact not added");
                        break;
                    }
                    contactDataManagement.addContact(contact);
                }
                case "delete" -> {
                    System.out.println("Which ID?");
                    int id = sc.nextInt();
                    sc.nextLine();
                    contactDataManagement.deleteContact(id);
                }
                case "show" -> contactDataManagement.showContact();
                case "exit" -> {
                    sc.close();
                    return;
                }
                default -> System.out.println("Command not defined");
            }
        }
    }
}