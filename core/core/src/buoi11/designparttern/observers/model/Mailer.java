package buoi11.designparttern.observers.model;


import buoi11.designparttern.observers.User;

public class Mailer implements Observer{
    @Override
    public void update(User user) {
        System.out.println("Gửi email tới user thông báo đã đăng nhập: " + user.getEmail());
    }
}
