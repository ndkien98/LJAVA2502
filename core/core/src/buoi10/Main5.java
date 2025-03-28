package buoi10;

import java.util.*;
import java.util.stream.Collectors;

/*
Map:
    + cấu trúc lưu trữ dạng 1 danh sách Key Value
    + ứng với mỗi key sẽ lấy ra được 1 value duy nhất
    + thường được sử dụng để lưu trữ danh sách các phần tử theo dạng key value, giúp tăng
    tốc độ tìm kiếm phần tử
vd: có 1 danh sách student với 2 thuộc tính tên, điểm
mục tiêu nhập vào tên và lấy ra điểm của student theo tên

 */
public class Main5 {
    public static void main(String[] args) {
        List<Student> students = initStudent();
        // lấy ra điểm của học sinh đó theo tên
        String name = "Student 1";
        // c1 sử dụng for
        for (Student student : students) {
            if (student.name.equals(name)){
                System.out.println(String.format("Array Điểm học sinh %s là %d ",name,student.getPoint()));
                break;
            }
        }
        // c2 sử dụng map
        // Biến students thành 1 map với Key là tên học sinh, value là điểm của học sinh đó
        // c1 tạo map thông qua for
        Map<String,Integer> mapTenDiem = new HashMap<>();
        for (Student student : students) {
            // thêm 1 cặp key value vào map, key = name, value = point
            mapTenDiem.put(student.getName(),student.getPoint()) ;
        }
        // c2 tạo map thông qua Stream, biến data dạng Array List -> map
        Map<String,Integer> mapTenDiem2 = students.stream() // biến array thành Steam
                                                    .collect( // sử dụng method collect để biến dữ liệu stream thành 1 cấu trúc dữ liệu mong muốn
                                                            Collectors.toMap(student -> student.getName(),student -> student.getPoint())// định nghĩa cách map được tạo ra thông qua key, value là gì
                                                    );
        // tìm kiếm điểm của học sinh theo tên => lấy ra điểm học sinh dựa vào key
        Integer point = mapTenDiem.get(name);
        System.out.println(String.format("Map Điểm học sinh %s là: %d", name, point));

        Integer point2 = mapTenDiem2.get(name);
        System.out.println(String.format("Map2 Điểm học sinh %s là: %d", name, point2));

    }

    private static List<Student> initStudent() {
        List<Student> danhSachHocSinh = new ArrayList<Student>();
        // khởi tạo danh sách học sinh
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.name = "Student " + i;
            student.point = (int) (Math.random()*(10-1))+1;
            danhSachHocSinh.add(student);
            System.out.println(student.toString());
        }
        return danhSachHocSinh;
    }

}
class Student {
    String name;
    Integer point;

    public String getName() {
        return name;
    }

    public Integer getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
