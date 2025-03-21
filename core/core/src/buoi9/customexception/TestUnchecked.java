package buoi9.customexception;

public class TestUnchecked {
    public static void main(String[] args) {
        // Ném exception tùy chỉnh
        throw new MyUncheckedException("Đây là unchecked exception!");
    }
}
