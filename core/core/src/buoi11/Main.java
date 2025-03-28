package buoi11;

/**
 DeadLock
    - tình trạng hai thread cùng chờ các tài nguyên
    của nhau và cứ chờ mãi không thể finish được
    chính thread đó

 ví dụ:
    process thread 1:
        + đang nắm giữ resource 1 để sử lý
        khóa không cho process nào sử dụng resource 2
        + và đang chờ đợi resource 2 được giải
        phóng để sử dụng xử lý và hoàn tất
        process
        + chỉ khi hoàn tất process
        -> process thread mới giải phóng resource 1
     process thread 2:
         + đang nắm giữ resource 2 để sử lý,
        khóa không cho process nào sử dụng resource 2
         + và đang chờ đợi resource 1 được giải
         phóng để sử dụng xử lý và hoàn tất
         process
         + chỉ khi hoàn tất process
         -> process thread 2 mới giải phóng resource 2
 => vậy 2 process đều đang nắm giữ tài nguyên
 của process khác và đều đang chờ tài nguyên để hoàn
 thành process chính nó
 => quá trình này sẽ cứ đứng im tại đó gọi là deadlock

 * deadlock xử lý thế nào
    + 1. bắt buộc phải kill 1 trong 2 process
    + 2. restart lại app để kill cả 2 process

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
}
