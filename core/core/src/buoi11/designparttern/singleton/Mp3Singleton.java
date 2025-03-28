package buoi11.designparttern.singleton;

/**
 các bước triển khai singleton
1) private constructor để hạn chế truy cập từ class bên ngoài.
2) Đặt private static final variable đảm bảo biến chỉ được khởi tạo trong class.
3) Có một method public static để return instance được khởi tạo ở trên.

 */
public class Mp3Singleton {
    private String tenBaiHat;
    // 2) Đặt private static final variable đảm bảo biến chỉ được khởi tạo trong class
    private static Mp3Singleton instance;
    // 1) private constructor để hạn chế truy cập từ class bên ngoài.
    private Mp3Singleton(){
    }
    public synchronized static Mp3Singleton getInstance(){
        if (instance == null){
            instance = new Mp3Singleton();
        }
        return instance;
    }




    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }
}
