package Test;

import java.util.Scanner;

public class Relative extends Contact {
    String relation;
    Scanner sc=new Scanner(System.in);

    public Relative(String firstName, String lastName, String address) {
        super(firstName, lastName, address,"Relative");
    }

    @Override
    public String getDetails() {
        return null;
    }

    @Override
    public void create() {
        System.out.println("Which kind of relative?");
        relation=sc.nextLine();
    }
    public String toString(){
        return super.toString() + " Relation: " +relation;
    }
}
