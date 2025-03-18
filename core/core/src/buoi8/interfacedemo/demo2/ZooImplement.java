package buoi8.interfacedemo.demo2;

public class ZooImplement implements IZoo{
    private Animal[] danhSachDongVat;
    private int soLuongDongVatHienTaiTrongDanhSach;
    public ZooImplement(int soLuongDongVatKhoiTao) {
        this.danhSachDongVat = new Animal[soLuongDongVatKhoiTao];
        this.soLuongDongVatHienTaiTrongDanhSach = 0;
    }
    /*
    interface IZoo: đã quy định trước
    đầu vào, đầu ra của các method
    => class ZooImplement khi triển khai (implements)
    thì phải ghi đè (@Override) hoàn chỉnh lại
    tất cả các method của interface
     */
    @Override
    public void addAnimal(Animal animal){
        if (this.soLuongDongVatHienTaiTrongDanhSach == this.danhSachDongVat.length - 1){
            // can phai mo rong danh sach dong vat
        }
        this.soLuongDongVatHienTaiTrongDanhSach++;
        this.danhSachDongVat[this.soLuongDongVatHienTaiTrongDanhSach] = animal;
        System.out.println("Da them dong vat thanh cong");
    }

    @Override
    public void makeAllSounds(){
        // duyet danh sach dong vat
        for (int i = 0; i < this.soLuongDongVatHienTaiTrongDanhSach; i++) {
            Animal animal = this.danhSachDongVat[i];
            animal.makeSound();
        }
    }

    @Override
    public void displayAllInfo(){
        for (int i = 0; i < this.soLuongDongVatHienTaiTrongDanhSach; i++) {
            Animal animal = this.danhSachDongVat[i];
            animal.displayInfo();
        }
    }
}
