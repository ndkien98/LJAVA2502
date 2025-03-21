package buoi9.uncheckedexception;

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        // Cố gắng chia cho 0
        int result = a / b; // Sẽ gây ra ArithmeticException
        System.out.println("Kết quả: " + result);
    }
}
