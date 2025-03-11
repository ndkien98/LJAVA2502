package buoi6;

public class Main2 {

    public static void main(String[] args) {
        Car car = new Car();
        car.setTen("B");
        setTenCar(car);
        System.out.println(car.getTen());

        int tong = 20;
        congHaiSo(tong);
        System.out.println(20);
    }

    public static void setTenCar(Car car){
        car.setTen("A");
    }

    public static void congHaiSo(int tong){
        tong = 10;
    }
}
