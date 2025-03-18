package buoi8.interfacedemo.demofuntional;

public class Main {

    public static void main(String[] args) {
        IPhepToan iPhepToan = new PhepToanImpl();
        System.out.println(iPhepToan.congHaiSo(1,2));

        // triển khai thông qua anonymous class
        IPhepToan iPhepToan2 = new IPhepToan() {
            @Override
            public int congHaiSo(int soA, int soB) {
                return soA + soB;
            }
        };
        System.out.println(iPhepToan2.congHaiSo(2,3));
        /*
        thay vì triển khai bằng 2 cách trên rất dài dòng
        => sử dụng Lambda expression
        cu phap: (parameter1, parameter2, ...) -> {expression}
        */
        IPhepToan iPhepToan3 = (a,b) -> a + b;
        System.out.println(iPhepToan3.congHaiSo(1,3));

        IPhepToan iPhepToan4 = (a,b) -> {
            return a + b;
        };
        System.out.println(iPhepToan3.congHaiSo(1,3));
        // c1: triển khai bằng anonymous class
        IRunnable iRunnable1 = new IRunnable() {
            @Override
            public void run() {
                System.out.println("chay");
            }
        };
        iRunnable1.run();
        // c1: triển khai bằng lamda express
        IRunnable iRunnable2 = () -> System.out.println("chay2");
        iRunnable2.run();
        /*
        Bai 1:
            Tạo 1 funtional interface có phương thức chia 2 số
            , cho người dùng nhập vào 2 số từ màn hình, triển khai interface đấy
            tính thương của 2 số
            triển khai bằng 2 cách:
            c1: sử dụng anonymous class
            c2: sử dụng Lambda expression
         */
    }
}
