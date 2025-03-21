package buoi9.demo;

public class ThrowsExample {
    static void checkAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Tuổi phải lớn hơn hoặc bằng 18");
        } else {
            System.out.println("Tuổi hợp lệ");
        }
    }
    public static void main(String[] args) {
        try {
            checkAge(16); // Phương thức checkAge ném ra ngoại lệ
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}

