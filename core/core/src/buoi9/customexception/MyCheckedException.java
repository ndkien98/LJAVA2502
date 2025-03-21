package buoi9.customexception;

// Tạo lớp exception tùy chỉnh
public class MyCheckedException extends Exception {
    // Constructor
    public MyCheckedException(String message) {
        super(message);
    }
}
