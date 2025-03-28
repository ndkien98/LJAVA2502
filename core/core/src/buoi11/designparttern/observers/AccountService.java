package buoi11.designparttern.observers;



import buoi11.designparttern.observers.model.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountService implements Subject{

    public User user;
    public static final String MAIN="admin@gmail.com";
    public static final String PASS="admin";

    List<Observer> observers = new ArrayList<>();

    public AccountService() {
        this.user = new User();
    }

    // thêm mới một observer
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Xóa đi một observer
    @Override
    public void detach(Observer observer) {
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }
    // thông báo tới tất cả các observer khi user thay đổi
    @Override
    public void notifyAllObservers() {
        for(Observer observer : observers){
            observer.update(user);
        }
    }

    public void login(){
        System.out.println("Nhập vào mail: ");
        String mail = new Scanner(System.in).nextLine();
        System.out.println("Nhập vào password: ");
        String pass = new Scanner(System.in).nextLine();
        user.setEmail(mail);
        user.setPassword(pass);
        if (!user.getEmail().equals(MAIN)){
            user.setStatus(LoginStatus.INVALID);
        }else if (!user.getPassword().equals(PASS)){
            user.setStatus(LoginStatus.FAILURE);
        }else {
            user.setStatus(LoginStatus.SUCCESS);
        }
        System.out.println("hoàn tất login, thông báo tới các observer");
        notifyAllObservers();
    }

    public void changeStatus(){
        System.out.println("Nhập vào các status: ");
        System.out.println("1: EXPIRED");
        System.out.println("2: SUCCESS");
        int status = new Scanner(System.in).nextInt();
        switch (status){
            case 1:
                user.setStatus(LoginStatus.EXPIRED);
                break;
            case 2:
                user.setStatus(LoginStatus.SUCCESS);
                break;
        }
        notifyAllObservers();
    }

    // Chỉ nhập cho login khi nhập đúng mail = admin@gmail.com,pass=admin
}
