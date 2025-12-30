package UML;

// 'is-a' relationship
//Dog is an animal
class Animal{
    public void eat()
    {
        System.out.println("This animal is eating");
    }
}

class Dog extends Animal{
    @Override
    public void eat(){
        super.eat();
        System.out.println("This animal eats chicken");
    }
    public void bark(){
        System.out.println("This animal barks");
    }
}
public class Inheritance {
 public static void main(String[] args)
 {
     Dog dg = new Dog();
     dg.bark();
     dg.eat();
 }

}
