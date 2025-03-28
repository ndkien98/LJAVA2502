package buoi10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main6 {

    public static void main(String[] args) {

        List<Student> students = Main5.initStudent();

        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Lecture lecture = new Lecture();
            lecture.setName("Lecture " + i);
            lecture.setStudents(students);
            lectures.add(lecture);
        }

        // timd kiếm điểm của 1 học sinh tên  String name = "Student 1"; trong mỗi lớp của danh sách các lớp học
        String nameTarget = "Student 1";
        // c1 sử dụng for
        for (Lecture lecture : lectures) {
            for (Student student : lecture.getStudents()) {
                if (student.getName().equals(nameTarget)){
                    System.out.println(String.format("Array Điểm học sinh %s là %d trong lớp %s",student.getName(),student.getPoint(),lecture.getName()));
                }
            }
        }
        System.out.println("----------------------------------------------------------");
        // c2 sử dụng map với name = tên học sinh, value = điểm học sinh đó
        Map<String,Integer> mapTen = students.stream().collect(Collectors.toMap(Student::getName // sử dụng method reference
                                                                            , Student::getPoint)); // sử dụng method reference

        for (Lecture lecture : lectures) {
            Integer point = mapTen.get(nameTarget);
            System.out.println(String.format("Map Điểm học sinh %s là %d trong lớp %s",nameTarget,point,lecture.getName()));
        }
    }
}
