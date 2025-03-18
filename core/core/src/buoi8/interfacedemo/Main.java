package buoi8.interfacedemo;

public class Main {

    public static void main(String[] args) {

        // sai vì không thể tạo đối tượng trực tiếp qua interface
//        MyInterface doiTuong1 = new MyInterface();
        /**
         khi muốn tạo đối tượng interface phải tạo thông qua
         1 class triển khai(implements) interface đó
          */
        MyInterface doiTuong1 = new MyInterfaceImpl();
        doiTuong1.myMethod();
        doiTuong1.myMethod2();
    }
}
