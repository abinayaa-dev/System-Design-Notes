package UML;

import javax.print.Doc;

class Document{
    private String name;

    Document(String name)
    {
        this.name = name;
    }

    public String getName(){
        return name;
    }


}

class Printer{
    public void print(Document doc)
    {
        System.out.println("Printed "+doc.getName());
    }
}

public class Dependency {

  public static void main(String[] args)
  {
      Document doc = new Document("Document1");
      Printer printer = new Printer();

      printer.print(doc);
  }
}
