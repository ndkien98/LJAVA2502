package buoi10.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Demo1 {

    public static void main(String[] args) {
        Person person = new Person();
        person.id = 10;

        Person person2 = new Person();
        person2.id = 10;

        List<Person> people = new ArrayList<>();
        people.add(person);
        people.remove(person2);
        System.out.println(people.size());
    }
}

class Person{
    int id;
    String name;

    @Override
    public boolean equals(Object obj) {
        return id == ((Person) obj).id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
