package buoi9.uncheckedexception;

public class NullPointerExample {
    public static void main(String[] args) {
        String str = null;

        // Cố gắng gọi phương thức trên đối tượng null
        System.out.println(str.length()); // Sẽ gây ra NullPointerException
    }
}
