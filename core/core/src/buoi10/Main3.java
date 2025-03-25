package buoi10;

import buoi10.btvn.Person;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {

        System.out.println("Khởi tạo");
        List<Person> personList = initPerson();
        showAll(personList);
        System.out.println("Data xoa");
        Person personDeleted = new Person(0,"name 0");
        System.out.println(personDeleted.toString());
        personList.remove(personDeleted);
        showAll(personList);

    }

    public static void showAll(List<Person> personList) {
//        // sử dụng for ech
//        for (Person person : personList) {
//            System.out.println(person.toString());
//        }
//
//        // sử dụng while
//        Iterator<Person> personIterator = personList.iterator();
//        while (personIterator.hasNext()){
//            Person person = personIterator.next();
//            System.out.println(person.toString());
//        }
        // sử dụng stream, biến list thanh Stream
        System.out.println("Danh sách person");
        personList.stream().forEach(data -> System.out.println(data.toString()));
    }

    public static List<Person> initPerson(){
        // 1) tạo ra mặc định 5 person với data data mặc
        List<Person> personList = new ArrayList<Person>();
        for (int i=0;i< 5;i++){
            // tạo ra person
            Person person = new Person(i,"name "+ i);
            // thêm person vào list
            personList.add(person);
        }
        return personList;
    }
}
