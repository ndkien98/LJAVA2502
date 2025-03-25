package buoi10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        // 1 danh sách các số nguyen
        List<Integer> numbers = new ArrayList<Integer>();
        // thêm 1 phần tử vào collection
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);

        // sắp xếp các phần từ tăng dần
        /*
        compare:
            + return về số âm <0  => phần tử o1 < o2
                => nếu sắp xếp từ bé -> lớn => giữ nguyên không đổi chỗ 2 phần từ
                => nếu sắp xếp từ lớn -> bé => đổi chỗ o1 với o2
            + return về số dương > 0 => phần tử o1 > o2
                => nếu sắp xếp từ bé -> lớn => đổi chỗ o1 với o2
                => nếu sắp xếp từ lớn -> bé =>  không đổi chỗ 2 số
         */
        // c1 sắp xếp các phần tử từ bé đến lớn
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println("Danh sách từ bé đến lớn: " + numbers);
        // c2  sắp xếp các phần từ từ lớn đến bé
        numbers.sort((o1,o2) -> o2 - o1);
        System.out.println("Danh sách từ lớn đến bé: " + numbers);
    }
}
