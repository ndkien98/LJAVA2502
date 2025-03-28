package buoi10;

import java.util.Optional;

public class Main7 {

    /*
    optional:
        - là 1 kiểu dữ liệu đóng gói lại 1 object bên trong nó
        - thay vì thao tác với object chính thì sẽ thao tác với optinal vì
        optinal cung cấp nhiều method thác tác với object nó đóng gói, các method đó
        sẽ thay cho các logic kiếm tra null, empty... thông thường
        - vẫn có thể lấy ra được object nhân bên trong khi muốn thông qua method get
     */

    public static void main(String[] args) {
        // khai báo không dùng optional
        Student s1 = null;
        // check null
        if (s1 == null){
            System.out.println("s1 ddang null ");
        }
        // Sử dụng optional
        // Optional<Student> studentOptional = Optional.empty(); // tạo ra optinal empty có core = null
        Optional<Student> studentOptional = Optional.of(new Student());
        // kiểm tra xem object Student có null không
        if(studentOptional.isPresent()){
            Student studentCore =  studentOptional.get(); // get lấy ra object student trong optinal
            System.out.println("studentCore != null");
        }else {
            System.out.println("studentCore == null");
        }
        studentOptional.ifPresent( // kiểm tra nếu Student trong optinal khác null => thực thi khối lệnh này
                data -> System.out.println("studentCore != null " + data.toString())
        );
        Student studentCore2 = studentOptional.orElse(new Student()); // kiểm tra nếu student core != null => trả về, nếu == null => trả về value trong ()
        System.out.println("studentCore2 " + studentCore2.toString());


    }
}
