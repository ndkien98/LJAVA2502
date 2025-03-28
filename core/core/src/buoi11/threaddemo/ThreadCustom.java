package buoi11.threaddemo;

public class ThreadCustom extends Thread{

    private String threadName;

    public ThreadCustom(String threadName){
        super(threadName);
        this.threadName = threadName;
    }
    /*
    hàm sẽ được chạy khi tạo ra 1 thread mới
    => các hành động khi thực hiện của thread sẽ được viết trong method run này
     */
    @Override
    public void run() {
        System.out.println(String.format("Start Thread Name: %s bắt đầu chạy", threadName));
        try {
            Thread.sleep(1000); // dừng 1s giả lập quá trình xử lý 1 hành động nào đó
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("End Thread Name: %s bắt đầu chạy", threadName));
    }
    public static void main(String[] args) {

        // tạo ra 1 thread
        ThreadCustom tc = new ThreadCustom("Thread-1");
        tc.start(); // chạy thread bằng method start()

        // tạo ra nhiều thread và chạy
        for (int i = 0; i < 3; i++) {
            // Tạo ra thread
            tc = new ThreadCustom("Thread" + i);
            // chạy thread
            tc.start();
        }


    }
}
