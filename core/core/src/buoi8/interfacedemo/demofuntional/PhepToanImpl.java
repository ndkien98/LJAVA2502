package buoi8.interfacedemo.demofuntional;

public class PhepToanImpl implements IPhepToan{
    @Override
    public int congHaiSo(int soA, int soB) {
        return soA + soB;
    }
}
