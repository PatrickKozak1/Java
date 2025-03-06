package Test;

public class RelativeFactory implements ContactFactory {
    public Contact createContact(String firstName, String lastName, String address){
        Relative relative= new Relative(firstName,lastName,address);
        relative.create();
        return relative;
    }
}
