package buoi11.designparttern.proxy;

public class RealImage implements Image{

    private String url;

    @Override
    public void showImage() {
        System.out.println("Hiển thị image tại real image: " + url);
    }

    public RealImage(String url) {
        System.out.println("Khởi tạo real image: " + url);
        this.url = url;
    }
}
