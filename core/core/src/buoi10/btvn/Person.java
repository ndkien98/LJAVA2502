package buoi10.btvn;

import java.util.Objects;

/**
 - Tất cả các class trong Java mặc định đều kế thừa từ clas Object, cho dù khi
 tạo ra không được khai báo chính thức public: class Person extends Object
 - vì mặc định luôn kế thừa class Object =>
    tất cả các class đều có thể sử dụng và ghi đè lại các method
    + equal() : so sánh giá trị của hai đối tượng(object) được tạo ra từ class
        equal thường được sử dụng trong cấu trúc lưu trữ array để xác định
        đâu là 2 object trùng nhau
    + toString(): biến object thành String
    + hashCode(): Sử dụng thuật toán hashing để tạo ra 1 giá trị hash cho mỗi object
    + hashcode thường được sử dụng trong cấu trúc lưu trữ map, hashmap, hashtable
    + khi sử dụng các cấu trúc map, hashmap, hashtable để xác định đâu là 2 phần tử
    trùng nhau, java sẽ sử dụng cả 2 method hashCode và equal
        -> nếu hashcode != nhau => 2 object khác nhau
        -> nếu hashcode == nhau
            -> tiếp tục kiểm tra tới equal, khi cả equal == nhau
                => Map, HashMap, Set => xác định đó là 2 object bằng nhau

 */
public class Person {

    private Integer id;

    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Person) obj).id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
