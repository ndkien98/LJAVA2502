package buoi8.interfacedemo;

// tao ra interface
public interface MyInterface {

    // khai bao cac method abstract
    public void myMethod();

    void myMethod2();

    /*
    Từ vesion java 8 trở đi
    interface cho phép khai báo các default method, tức là các method có thân hàm, không phair các method abstract
     */
    default void method3(){
        System.out.println("method3");
    }
}
