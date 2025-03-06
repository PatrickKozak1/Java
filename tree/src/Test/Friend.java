package Test;

import java.util.Scanner;

public class Friend extends Contact {

    String location;
    Scanner sc= new Scanner(System.in);

    public Friend(String firstName, String lastName, String address) {
        super(firstName, lastName, address,"Friend");
        this.location=" ";
    }

    @Override
    public String getDetails() {
        return null;
    }

    @Override
    void create() {
        System.out.println("Where have you met?");
        location=sc.nextLine();
    }
    public String toString(){
        return super.toString() + " Location: "+ location;
    }

}
