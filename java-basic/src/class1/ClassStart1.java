package class1;

public class ClassStart1 {
    public static void main(String[] args) {
        Student[] student = {new Student("학생1", 15, 90), new Student("학생2", 16, 80)};

        for (Student value : student) {
            System.out.println("학생 : " + value.name + " 나이 : " + value.age + " 성적 : " + value.grade);
        }
    }

}

