package buoi10;

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

 */

public class Main {


    public static void main(String[] args) {

        // 1 danh sách các số nguyen
        List<Integer> numbers = new ArrayList<Integer>();
        // thêm 1 phần tử vào collection
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        System.out.println("tim phan tu co value = 2");
        for(Integer data:numbers){
            if (data == 2){
                System.out.println(data);
            }
        }
        System.out.println("Tim phan tu co value = 2 voi stream");
        numbers.stream().filter(data -> data.equals(2)).forEach(data -> System.out.println(data));

        // lấy phần từ từ collection thông qua index
        System.out.println(numbers.get(0));
        System.out.println(numbers.get(1));
        System.out.println(numbers.get(2));

        // Khởi tạo 1 set các phần tử String
        Set<String> setString = new HashSet<String>();
        // thêm mới các phần tử vào set
        setString.add("a");
        setString.add("b");
        setString.add("c");
        // biến set thành Iterator để duyệt các phần tử của Set
        Iterator<String> setI = setString.iterator();
        // lấy ra 1 phần tử của set
        setI.next();
        // duyệt set
        while (setI.hasNext()){// nếu set vẫn còn phần tử
            // lấy ra phần tưr đó từ Set
            System.out.println(setI.next());
        }
        // khởi tạo 1 tập hợp queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //lấy ra các phần tử
        queue.stream().forEach(data -> System.out.println(data));

    }
}
