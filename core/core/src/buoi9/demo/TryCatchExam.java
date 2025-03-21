package buoi9.demo;

public class TryCatchExam {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // Lỗi chia cho 0
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: Không thể chia cho 0!");
        }
    }
}
