package buoi9.demo;

public class ThrowExam {
    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Tuổi phải lớn hơn hoặc bằng 18");
        } else {
            System.out.println("Tuổi hợp lệ");
        }
    }
    public static void main(String[] args) {
        checkAge(16); // Sẽ ném ra IllegalArgumentException
    }
}
