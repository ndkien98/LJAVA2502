package buoi9;

public class AgeException extends RuntimeException{

    public AgeException(){
        super("Nhap vao tuoi loi");
    }

    public AgeException(String msg){
        super(msg);
    }
}
