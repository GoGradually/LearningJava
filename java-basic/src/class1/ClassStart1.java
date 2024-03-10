package class1;

public class ClassStart1
{

    public static void main(String[] args){
        class Student{
        String name;
        int age;
        int grade;
        Student(String name, int age, int grade){
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }


        Student s1 = new Student("학생1", 15, 90);
        Student s2 = new Student("학생2", 16, 80);
        System.out.println("학생 :" + s1.name + " 나이 : "+ s1.age + " 성적 : "+ s1.grade);
        System.out.println("학생 :" + s2.name + " 나이 : "+ s2.age + " 성적 : "+ s2.grade);
    }

}

