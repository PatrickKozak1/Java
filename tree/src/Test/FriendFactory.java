package Test;

public class FriendFactory implements ContactFactory {
    public Contact createContact(String firstName, String lastName, String address){
        Friend friend= new Friend(firstName,lastName,address);
        friend.create();
        return friend;
    }
}
