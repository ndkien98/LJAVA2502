package buoi9.btvn;

import java.util.Scanner;

public class LibraryImpl implements ILibrary{

    private Book[] danhSachSach;
    private int soLuongSachHienTai;

    public LibraryImpl(int n) {
        this.danhSachSach = new Book[n];
        this.soLuongSachHienTai = 0;
    }


    @Override
    public void addBook(Book book) {
        checkDuplicateId(book);
        reSize();
        this.danhSachSach[this.soLuongSachHienTai] = book;
        this.soLuongSachHienTai++;
    }

    private void checkDuplicateId(Book book) {
        Book bookDuplicateId = findById(book.getId());
        while (bookDuplicateId != null) {
            findById(book.getId());
            System.out.println("Đề nghị nhập lại id: ");
            int id =  new Scanner(System.in).nextInt();
            book.setId(id);
            bookDuplicateId = findById(book.getId());
        }
    }

    private void reSize() {
        if (this.soLuongSachHienTai != this.danhSachSach.length - 1){
            return;
        }
        Book[] danhSachSachMoi = new Book[this.danhSachSach.length * 2];
        for (int i = 0; i < this.danhSachSach.length; i++) {
            danhSachSachMoi[i] = this.danhSachSach[i];
        }
        this.danhSachSach = danhSachSachMoi;
    }

    @Override
    public void updateBook(int id, Book book) {
        for (int i = 0; i < this.soLuongSachHienTai; i++) {
            if (this.danhSachSach[i].getId() != id) {
                continue;
            }
            this.danhSachSach[i] = book;
            break;
        }
    }

    @Override
    public void deleteBook(int id) {
        for (int i = 0; i < this.soLuongSachHienTai; i++) {
            if (this.danhSachSach[i].getId() != id) {
                continue;
            }
            System.out.println("Bắt đầu xóa book theo id: " + id);
            for (int j = i; j < this.soLuongSachHienTai - 1; j++) {
                this.danhSachSach[j] = this.danhSachSach[j + 1];
            }
            this.soLuongSachHienTai--;
            break;
        }
    }

    @Override
    public void searchByAuthor(String author) {
        for (int i = 0; i < this.soLuongSachHienTai; i++) {
            Book book = this.danhSachSach[i];
            if (!author.equals(book.getAuthor())){
                continue;
            }
            book.displayInfo();
        }
    }

    @Override
    public void displayAllBooks() {
        for (int i = 0; i < this.soLuongSachHienTai; i++) {
            Book book = this.danhSachSach[i];
            book.displayInfo();
        }
    }

    @Override
    public Book findById(int id) {
        for (int i = 0; i < this.soLuongSachHienTai; i++) {
            if (this.danhSachSach[i].getId() == id) {
                return this.danhSachSach[i];
            }
        }
        return null;
    }
}
