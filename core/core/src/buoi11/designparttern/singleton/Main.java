package buoi11.designparttern.singleton;

/**

 Xây dựng chức năng phát nhạc mp3
 chuc nang: hiển thị tên bài hát
 chỉ được tạo ra một đối tượng mp3 duy nhất trong chuương trình
 => áp dụng Singleton

 */
public class Main {


    public static void main(String[] args) {
        Mp3Singleton mp3Singleton = Mp3Singleton.getInstance();
        Mp3Singleton mp3Singleton2 = Mp3Singleton.getInstance();
        Mp3Singleton mp3Singleton3 = Mp3Singleton.getInstance();

        mp3Singleton.setTenBaiHat("Một vòng trái đất");

        System.out.println(mp3Singleton2.getTenBaiHat());
        System.out.println(mp3Singleton3.getTenBaiHat());

        Main main1 = new Main();
        Main main2 = new Main();
        System.out.println("hashcode main1: " + main1.hashCode());
        System.out.println("hashcode main2: " + main2.hashCode());

        System.out.println("mp3Singleton hashcode: " + mp3Singleton.hashCode());
        System.out.println("mp3Singleton2 hashcode: " + mp3Singleton2.hashCode());
        System.out.println("mp3Singleton3 hashcode: " + mp3Singleton3.hashCode());

    }
}
