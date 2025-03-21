package buoi9.customexception;

// Tạo lớp exception tùy chỉnh
public class MyUncheckedException extends RuntimeException {
    // Constructor
    public MyUncheckedException(String message) {
        super(message);
    }
}
