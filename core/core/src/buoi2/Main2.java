package buoi2;

/**
 - cấu trúc rẽ nhánh:
    dang 1:
        if(biểu_thức_điều_kiện) {
            khối lệnh được thực thi khi biểu_thức_điều_kiện = true
        }else {
            khối lệnh được thực thi khi biểu_thức_điều_kiện = false
        }

    dạng 2:
     if(biểu_thức_điều_kiện1) {
        khối lệnh được thực thi khi biểu_thức_điều_kiện1 = true
     }else if(biểu_thức_điều_kiện2){
        khối lệnh được thực thi khi biểu_thức_điều_kiện2 = true
     }else if(biểu_thức_điều_kiện3){
        khối lệnh được thực thi khi biểu_thức_điều_kiện3 = true
    }...else if(biểu_thức_điều_kiệnn){
        khối lệnh được thực thi khi biểu_thức_điều_kiệnn = true
     }else {
           khối lệnh được thực thi khi tất tất cả các điều khiện ở trên đều = false
     }

 Toán tử 3 ngôi:
    có dạng
        biểu_thức_điều_kiện ? statement A : statement B
 + biểu_thức_điều_kiện: biểu thức logic trả về true hoặc false
 + statement A: câu lệnh được thực thi khi biểu_thức_điều_kiện = true
 + statement B: câu lệnh được thực thi khi biểu_thức_điều_kiện = false
 */
public class Main2 {

    public static void main(String[] args) {
        int diem = 7;
        if (diem > 4){
            System.out.println("Qua môn");
        }else {
            System.out.println("Trượt môn");
        }

        // demo dạng 2
        if (diem > 8.5 ){
            System.out.println("điểm A");
        }else if(diem > 7.5){
            System.out.println("Điểm B");
        }else if(diem > 6.5){
            System.out.println("Điểm C");
        }else if(diem > 5.5){
            System.out.println("Điểm D");
        }else {
            System.out.println("Trượt môn");
        }

        // demo dạng 2
        if (diem > 8.5 ){
            System.out.println("điểm A");
        }
        if(diem > 7.5){
            System.out.println("Điểm B");
        }
        if(diem > 6.5){
            System.out.println("Điểm C");
        }
        if(diem > 5.5){
            System.out.println("Điểm D");
        }else {
            System.out.println("Trượt môn");
        }

        String ketQua = diem > 4 ? "Qua môn" : "Trượt môn";
        System.out.println("Kết quả môn học là : " + ketQua);

    }

}
