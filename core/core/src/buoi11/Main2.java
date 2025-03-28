package buoi11;

public class Main2 {


    public static void main(String[] args) {

        Utils object1 = Utils.getInstance();

        Utils object2 = Utils.getInstance();

        System.out.println(object1 == object2);

        Main2 main21 = new Main2();
        Main2 main22 = new Main2();
        System.out.println(main21 == main22);


    }
}
