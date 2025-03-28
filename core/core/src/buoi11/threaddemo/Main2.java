package buoi11.threaddemo;

public class Main2 {

    public static void main(String[] args) {
        System.out.println("Main thread start");
        String threadName = "runnable thread -1";
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("Start Runnable Thread Name: %s bắt đầu chạy",threadName));
                try {
                    Thread.sleep(1000); // dừng 1s giả lập quá trình xử lý 1 hành động nào đó
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(String.format("End Runnable Thread Name: %s bắt đầu chạy", threadName));
            }
        };
        Thread thread = new Thread(runnable);
        System.out.println("status: " + thread.getState());

        thread.start();

        System.out.println("Main thread End");
    }
}
