package buoi9.btvn;

import buoi7.kethua.Utils;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Nhập vào số lượng sách của thư viện");
        int n = new Scanner(System.in).nextInt();
        // 1.	Khởi tạo đối tượng thư viện
        ILibrary library = new LibraryImpl(n);
        Book bussinessBook = new BusinessBook(1,"Dạy con làm giàu",2001,"Robert","Tiền bạc");
        library.addBook(bussinessBook);
        Book scienceBook = new BusinessBook(2,"Hố đen",2001,"Akira","Vũ trụ");
        library.addBook(scienceBook);

        // 2.	Xây dựng menu với các chức năng
        int choice = 0;
        do {
            System.out.println("1. Thêm sách");
            System.out.println("2. Cập nhập sách bằng id");
            System.out.println("3. Xóa sách bằng id");
            System.out.println("4. Tìm kiếm theo tác giả");
            System.out.println("5. Hiển thị toàn bộ sách");
            System.out.println("6. Thoát");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    Book book = getBook();
                    if (book == null){
                        System.out.println("Loại sách không hợp lệ");
                        choice = -1;
                        break;
                    }
                    book.inputInfo();
                    library.addBook(book);
                    break;
                case 2:
                    int id = Utils.nhap("Nhập vào id");
                    System.out.println("Nhập thông tin sách cần update");
                    Book bookUpdate = getBook();
                    if (bookUpdate == null){
                        System.out.println("Loại sách không hợp lệ");
                        choice = -1;
                        break;
                    }
                    bookUpdate.inputInfo();
                    library.updateBook(id,bookUpdate);
                    break;
                case 3:
                    int idDeleted = Utils.nhap("Nhập vào id");
                    library.deleteBook(idDeleted);
                    break;
                case 4:
                    System.out.println("Nhập tên tác giả:");
                    String author = sc.nextLine();
                    library.searchByAuthor(author);
                    break;
                case 5:
                    library.displayAllBooks();
                    break;
                default:
                    System.out.println("Chức năng không tồn tại");
                    choice = -1;
            }
        }while (choice != 6);

    }

    public static Book getBook(){
        System.out.println("Chọn loại sách");
        System.out.println("1. Sách khoa học");
        System.out.println("2. Sách kinh doanh");
        int typeBook = sc.nextInt();
        Book book = null;
        switch (typeBook){
            case 1:
                book = new ScienceBook();
                break;
            case 2:
                book = new BusinessBook();
                break;
            default:
                System.out.println("Số bạn nhập không hợp lệ");
        }
        return book;
    }
}
