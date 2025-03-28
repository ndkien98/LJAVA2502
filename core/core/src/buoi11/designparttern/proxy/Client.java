package buoi11.designparttern.proxy;

public class Client {
    public static void main(String[] args) {

        System.out.println("Khởi tạo proxy");
        Image image = new ProxyImage("https://t3h.edu.vn/sites/default/files/t3h-do-hoa-da-truyen-thon_1.jpg");
        System.out.println("---");
        System.out.println("Load hình ảnh lần 1: ");
        image.showImage();
        System.out.println("Load hình ảnh lần 2: ");
        image.showImage();

    }
}
