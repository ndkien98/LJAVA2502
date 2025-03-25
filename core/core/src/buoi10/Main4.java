package buoi10;

import buoi10.btvn.Person;

import java.util.HashSet;
import java.util.Set;

public class Main4 {

    public static void main(String[] args) {

        Set<String> strings = new HashSet<String>();
        strings.add("a");
        strings.add("b");
        strings.add("a");
        System.out.println(strings);

        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person(1,"a");
        Person p2 = new Person(2,"b");
        Person p3 = new Person(1,"a");

        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
    }
}
