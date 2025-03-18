package buoi8.interfacedemo.demofuntional;

@FunctionalInterface
public interface IPhepToan {

    public int congHaiSo(int soA,int soB);

    default void demoDefault1(){
        System.out.println("demoDefault1");
    }
    default void demoDefault2(){
        System.out.println("demoDefault2");
    }
}
