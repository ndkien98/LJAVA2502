package buoi8.interfacedemo.demo2;

public class ZooImplement implements IZoo{


    @Override
    public void addAnimal(Animal animal){
        System.out.println("addAnimal");
    }

    @Override
    public void makeAllSounds(){
        System.out.println("makeAllSounds");
    }

    @Override
    public void displayAllInfo(){
        System.out.println("displayAllInfo");
    }
}
