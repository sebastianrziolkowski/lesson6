import models.Student;

public class Main {

    public static void main(String[] args){
        Student student = new Student();
        student.readData();
        System.out.println(student.writeData());
    }
}
