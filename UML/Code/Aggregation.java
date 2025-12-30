package UML;

import java.util.Arrays;
import java.util.List;

//Aggregation -> Department has Professors.


class Professor{
    private String name;
    Professor(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}

class Department{
    private String name;

    private List<Professor> professors;

    Department(String name,List<Professor> professors)
    {
        this.name = name;
        this.professors = professors;
    }

    public void showProfessors()
    {
        System.out.println("Department : " + name);
        for(int i=0;i<professors.size();i++)
            System.out.println(professors.get(i).getName());
    }
}

public class Aggregation {
   public static void main(String[] args)
   {
       Professor professor = new Professor("Abi");
       Professor professor1 = new Professor("Mathan");

       List<Professor> professors = Arrays.asList(professor,professor1);
//    professors
       Department department = new Department("CSE",professors);

       department.showProfessors();
   }
}
