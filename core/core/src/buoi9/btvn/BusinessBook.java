package buoi9.btvn;

import java.util.Scanner;

public class BusinessBook extends Book{

    private String businessField;

    public BusinessBook(){

    }
    public BusinessBook(int id,
                       String title,
                       int year,
                       String author,
                       String businessField) {
        super(id, title, year, author);
        this.businessField = businessField;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Business Field: " + businessField);
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Business Field: ");
        businessField = sc.nextLine();
    }
}
