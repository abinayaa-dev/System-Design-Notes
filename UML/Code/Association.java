package UML;
//Association - A simple association -
// A teacher can exist independently without student and vice versa
class Teacher{
    private String name;

    Teacher(String name)
    {
        this.name = name;
    }
    public void print(Student student)
    {
        System.out.println(name +" teaches "+student.getName());
    }
}

class Student{
    private String name;
    Student(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

}

public class Association {
 public static void main(String[] args)
 {
     Teacher teacher = new Teacher("Shanthi");
     Student student = new Student("Abi");
     teacher.print(student);
 }

}


O/P :: Shanthi teaches Abi