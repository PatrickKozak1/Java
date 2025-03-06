package Test;

import java.util.HashMap;

public class Person {
    
    public String getName;
    public int age;
    boolean name;

    public Person(String name,int alter) {
    }

    public static void main(String[] args) {
        HashMap<Person2,Integer > personMap = new HashMap<>();
        int i = 0;

        while (true) {
            personMap.put( new Person2("Person",23),i);
            System.out.println(personMap.size());
            i++;
        }
    }

    public boolean getName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }
}
