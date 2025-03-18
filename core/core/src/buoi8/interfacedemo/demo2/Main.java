package buoi8.interfacedemo.demo2;

public class Main {

    public static void main(String[] args) {
        IZoo zoo = new ZooImplement(3);
        zoo.addAnimal(null);
        zoo.displayAllInfo();
        zoo.makeAllSounds();
    }
}
