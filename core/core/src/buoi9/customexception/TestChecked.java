package buoi9.customexception;

public class TestChecked {
    public static void main(String[] args) {
        try {
            // Ném exception tùy chỉnh
            throw new MyCheckedException("Đây là checked exception!");
        } catch (MyCheckedException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
