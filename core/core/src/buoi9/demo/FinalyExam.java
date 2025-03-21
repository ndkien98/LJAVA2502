package buoi9.demo;

public class FinalyExam {
    public static void main(String[] args) {
        try {
            int result = 10 / 2;
            System.out.println("Kết quả: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Lỗi toán học!");
        } finally {
            System.out.println("Khối finally luôn được thực thi.");
        }
    }
}
