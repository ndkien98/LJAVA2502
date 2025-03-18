package buoi8.interfacedemo;

/*
Khai báo class triển khai interface MyInterface
- khi có 1 class triển khai (implements) interface
=> class đó phải ghi đè (@Override) tất cả các method của interface đó
 */
public class MyInterfaceImpl implements MyInterface{

    @Override
    public void myMethod(){
        System.out.println("myMethod implement");
    }

    public void myMethod2(){
        System.out.println("myMethod2 implement");
    }
}
