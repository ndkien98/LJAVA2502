package buoi9.btvn;

import java.util.Scanner;

public abstract class Book {

    private int id;
    private String title;
    private int year;
    private String author;

    public Book(){

    }

    public Book(int id, String title, int year, String author) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public void displayInfo(){
        System.out.println("+---------------------------+");
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("Author: " + author);
    }

    public void inputInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        title = sc.nextLine();
        System.out.print("Enter Year: ");
        year = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Author: ");
        author = sc.nextLine();
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }
}
