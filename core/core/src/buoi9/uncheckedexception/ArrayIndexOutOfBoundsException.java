package buoi9.uncheckedexception;

public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        // Truy cập chỉ mục ngoài phạm vi mảng
        System.out.println(arr[5]); // Sẽ gây ra ArrayIndexOutOfBoundsException
    }
}
