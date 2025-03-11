package buoi6.baitap;

public class PhanSo {

    // khai bao thuoc tinh
    private int tuSo;
    private int mauSo;

    // ham khoi tao
    public PhanSo(){
        tuSo = 1;
        mauSo = 1;
    }

    /*
    Công hai phân số:
    - Chỉ được cộng khi 2 phân số có cùng mẫu số

    1/2 * 2/3 = 1*3 / 2 * 3 + 2 * 2 / 2 * 3 =
     */
    public void congPhanSo(PhanSo phanSoDuocCongVao){
        if (this.mauSo == phanSoDuocCongVao.getMauSo()){
            this.tuSo = this.tuSo + phanSoDuocCongVao.getTuSo();
            this.mauSo = this.mauSo + phanSoDuocCongVao.getMauSo();
            return;
        }
        this.tuSo = (this.tuSo * phanSoDuocCongVao.getMauSo()) + (this.mauSo * phanSoDuocCongVao.getTuSo());
        this.mauSo = this.mauSo * phanSoDuocCongVao.getMauSo();
    }

    public void truPhanSo(PhanSo phanSoDuocTruVao){
        if (this.mauSo == phanSoDuocTruVao.getMauSo()){
            this.tuSo = this.tuSo - phanSoDuocTruVao.getTuSo();
            this.mauSo = this.mauSo + phanSoDuocTruVao.getMauSo();
            return;
        }
        this.tuSo = (this.tuSo * phanSoDuocTruVao.getMauSo()) - (this.mauSo * phanSoDuocTruVao.getTuSo());
        this.mauSo = this.mauSo * phanSoDuocTruVao.getMauSo();
    }

    public void nhanPhanSo(PhanSo phanSoNhan){
        this.tuSo = this.tuSo * phanSoNhan.getTuSo();
        this.mauSo = this.mauSo * phanSoNhan.getMauSo();
    }

    public void chiaHaiPhanSo(PhanSo phanSoChia){
        this.tuSo = this.tuSo * phanSoChia.getMauSo();
        this.mauSo = this.mauSo * phanSoChia.getTuSo();
    }

    public void hienThi(){
        System.out.println(String.format("Phân số: %d / %d",this.tuSo,this.mauSo));
    }

    // getter, setter
    public void setTuSo(int tuSoTruyenVao){
        this.tuSo = tuSoTruyenVao;
    }

    public int getTuSo(){
        return this.tuSo;
    }

    public void setMauSo(int mauSoTruyenVao){
        this.mauSo = mauSoTruyenVao;
    }
    public int getMauSo(){
        return this.mauSo;
    }

}
