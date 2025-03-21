package buoi9.error;

public class StackOverflowErrorExample {
    public static void recursiveMethod() {
        recursiveMethod(); // Gọi đệ quy vô hạn
    }
    public static void main(String[] args) {
        try {
            recursiveMethod(); // Gây ra StackOverflowError
        }catch (Exception e){
            System.out.println("Lỗi");
        }
    }
}

