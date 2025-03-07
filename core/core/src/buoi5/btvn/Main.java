package buoi5.btvn;

public class Main {

    public static void main(String[] args) {
        System.out.println("H1llo World".charAt(1));

        char data = "0ello".charAt(0);
        System.out.println(Integer.toHexString(data | 0x10000).substring(1));
    }
}
