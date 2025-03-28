package buoi11.bt1;

/**
 Bài tập 1
     Quản Lý Nhiều Thread
     Yêu cầu:
     Tạo một ứng dụng Java có 3 thread đồng thời thực hiện các tác vụ khác nhau.
     Các thread này sẽ thực hiện các nhiệm vụ sau:
     Thread 1: In ra dãy số từ 1 đến 10.
     Thread 2: In ra dãy số từ 11 đến 20.
     Thread 3: In ra dãy số từ 21 đến 30.
     - Sử dụng Runnable Interface để triển khai các thread.
     Đảm bảo rằng các thread này có thể chạy song song
     mà không làm gián đoạn quá trình thực thi của nhau.
     - Mỗi thread nên in ra một thông báo khi bắt đầu và kết thúc.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Main thread start=====");
        //  Thread 1: In ra dãy số từ 1 đến 10.
        Thread thread1 = new CustomThread(1,10,"t1");
        // Thread 2: In ra dãy số từ 11 đến 20.
        Thread thread2 = new CustomThread(2,20,"t2");
        // Thread 3: In ra dãy số từ 21 đến 30.
        Thread thread3 = new CustomThread(3,30,"t3");

        // run thread
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Main thread end====");
    }
}
