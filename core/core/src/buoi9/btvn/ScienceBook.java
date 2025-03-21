package buoi9.btvn;

import java.util.Scanner;

public class ScienceBook extends Book{

    private String researchSubject;

    public ScienceBook() {

    }
    public ScienceBook(int id,
                       String title,
                       int year,
                       String author,
                       String researchSubject) {
        super(id, title, year, author);
        this.researchSubject = researchSubject;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Research Subject: " + researchSubject);
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Research Subject: ");
        researchSubject = sc.nextLine();
    }
}

