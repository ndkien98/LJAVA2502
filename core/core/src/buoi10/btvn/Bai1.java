package buoi10.btvn;

import java.util.*;
import java.util.stream.Collectors;

/*

Bài tập:
tạo ra 1 class Person với các thôgn tin
id: Integer
name: String
yêu cầu:
    1) tạo ra mặc định 5 person với data data mặc định
    2) tạo ra List<Person> và thêm person vào danh sách
    3) Hiển thị thông tin các person
    4) Cho phép user nhập vào tên, tìm kiếm person
    5) Nhập vào tên và xóa đi person sử dụng method remove
    6) Sắp xếp danh sách person với id từ cao đến thấp sử dụng method sort
 */
public class Bai1 {
    public static void main(String[] args) {

        List<Person> personList = initPerson();
        showAll(personList);
        findByName("name 4",personList);
//        deletedByName("name 4",personList);
//        showAll(personList);

        // c1 triển khai anonymous class Comparator
        System.out.println("c1 triển khai anonymous class Comparator id từ cao đến thấp sử dụng method sort");
        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getId() - o1.getId();
            }
        });
        showAll(personList);
        // c2 triển khai bằng lamda expression sắp xếp lại từ thấp đến cao
        System.out.println("c2 triển khai bằng lamda expression sắp xếp lại từ thấp đến cao");
        personList.sort((o1,o2) -> o1.getId() - o2.getId());
        showAll(personList);
        deletedByName2("name 4",personList);
        showAll(personList);

    }


    public static void deletedByName2(String name, List<Person> personList){
        System.out.println(String.format("Xóa bằng iterator"));
        Iterator<Person> iterator = personList.iterator();
        while(iterator.hasNext()){
            Person person = iterator.next();
            if(person.getName().equals(name)){
                iterator.remove();
            }
        }
        showAll(personList);
    }

    public static void deletedByName(String name, List<Person> personList){
        // tim kiếm xem tồn tại person với tên không
        Person personSearch = findByName2(name,personList);
        if (personSearch == null){
            System.out.println("Không tồn tại person với tên: " + name);
            return;
        }
        personList.remove(personSearch);
    }

    public static Person findByName2(String name,List<Person> personList) {
        // c1, sử dụng for ech hoặc for i
    /*
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        */
        // c2: sử dụng stream, biến list thành stream -> sử dụng hàm filter -> tập hợp lại thành list
        Person personResult = personList.stream()
                .filter(data -> { // sử dụng hàm filter của stream, để so sánh tất cả các phần tử
                    if (data.getName().equals(name)){
                        return true; // nếu trả về true => lấy phần tưr đó
                    }
                    return false; // không lấy phần tử đó
                }).findFirst()// lấy ra phần tử đầu tiên trong danh sách stream tìm đươc
                .orElse(null); // nếu trường hợp không có phần tử nào thõa mãn với tên truyền vào => trả về null

        return personResult;
    }

    public static void findByName(String name,List<Person> personList) {
        // c1, sử dụng for ech hoặc for i
    /*
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                System.out.println(person.toString());
            }
        }
        */
        // c2: sử dụng stream, biến list thành stream -> sử dụng hàm filter -> tập hợp lại thành list
        List<Person> personResult = personList.stream()
                .filter(data -> { // sử dụng hàm filter của stream, để so sánh tất cả các phần tử
                    if (data.getName().equals(name)){
                        return true; // nếu trả về true => lấy phần tưr đó
                    }
                    return false; // không lấy phần tử đó
                }).collect(Collectors.toList());
        if (personResult.isEmpty()){
            System.out.println("Không tìm thấy person với tên: " + name);
            return;
        }
        System.out.println("Danh sách person là tìm kiếm được với tên là: " + name);
        showAll(personResult);
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
