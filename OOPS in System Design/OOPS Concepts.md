Assume a payment service that should be responsible for storing the details of payment methods 
(CC , DC , UPI.. etc) , that belong to a user and also have a makePayment() method.


- Class :  A blueprint or a template that defines the behavior and properties.
 classes -> Card, CreditCard , DebitCard etc are created.


- Encapsulation : Bundling the data and the methods into a class.

  Data Binding  : 
  -> By making the class variables -> private and accessing it using getters and setters.
  -> The internal state of the object is hidden.
  This ensures  
 -> Increased flexibility 
 -> Improved maintainability

  In class CreditCard -> cardNo and name are made private and are accessed through getters and setters.


- Inheritance :  (Keyword  =>  Extends )

    A mechanism where in a new class inherits the properties of an existing class. 
  -> This promotes code reusability.
  -> Method Overriding  
  -> Extensibility ( New Function can be added to existing classes without modifying them ).

In Payment Service Since CreditCard and DebitCard classes are similar , instead of creating and defining for both . Create a Superclass => Card and inherit for both CreditCard and DebitCard.

            Card  
              | 
             / \
 CreditCard      DebitCard


- Abstract : An abstract class cannot be intantiated on its own and must be subclasses .

If a method in a class is abstract -> then the class should also be given abstract keyword.
An abstract class can have both the abstract methods and concrete methods.

In both creditcard and debitcard we have a function pay() inherited from Card class. But the pay method cannot be implemented in Card because CC and DC have different function definitions for pay(). Hence we make it abstract in Card class and define the pay() in CreditCard and DebitCard classes. 

<!-- Code  -->

abstract public class Card{
     abstract void pay();
} 

public class CC extends Card {
    @Override
    public void pay(){
        System.out.println("Debit card Payment done for " + name);
    }
} 

<!-- Code end -->

- Interface : ( Keyword -> Implements )
  => interface is like a contract or rulebook => It tells what a class must do, but not how.
  =>It is a reference type similar to class that can contain only constants, method signatures, default methods, static methods and nested types.
  => It does not contain instance fields or constructors.
  => A class that implements an Interface must provide an implementation for all the methods declared in the interface.

  In Payment service -> There are other payment methods (UPI , Wallet) that also needs to support payment pay(). We need to ensure all the payment classes [CC,DC,UPI,Wallet] implements the same payment.

PaymentMethod(Interface)
             |                                
             |-----------------|
             /\               / \     
                             /   \      
       UPI    Wallet  pay()-CC   DC pay()       
       pay()   pay()         \   /
                               |
                              Card(SuperClass)


 Difference between Interface and Abstract Class (SUPER IMPORTANT)

 Feature	                             Interface	                         Abstract Class

Methods                 	Only abstract (Java 8+: default allowed)	      Abstract + normal
Variables	                public static final only	                      Any type
Keyword	                  implements	                                    extends
Multiple inheritance	    ✅ Yes	                                        ❌ No
Constructor	              ❌ No	                                        ✅ Yes
Use case	                Common behavior across classes	                Is-a relationship

Interface defines what a class should do, while abstract class defines what a class is and partially how it works.


- Polymorphism : 
  => Many Forms -> same method can perform different behaviours based on the object or parameters.
  => 2 types - 1. Compile Time ( Method overloading ) , 2. Run Time ( Method Overriding )

   - Method overloading : ( State Binding or Early Binding )
    => Multiple methods have the same name but different parameters 
    => Resolved during the compile time 
  
   - Method Overriding : ( Dynamic Binding or Late Binding )
    => Occurs when a subclass provides a specific implementation for a method that is already defined in the Base class.
    => Resolved at run time.
    
    
Concepts in Overriding :

1. super -> The super keyword can be used to invoke the parent class method inside an overrider method.
         -> super is used when the child wants to call the parent’s method inside its own method. 
<!-- Code -->
  class Parent {
    void show() {
        System.out.println("Parent show method");
    }
}

class Child extends Parent {
    void show() {
        super.show();   // calls Parent's method
        System.out.println("Child show method");
    }
}
<!-- Code ends -->

2. final ->If a method is marked final, the child cannot change it.
 
3. static -> static methods are not overriden. 
          -> Static methods belong to the class, not the object.So they cannot be overridden,only hidden.

<!-- Code -->
class Parent {
    static void greet() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    static void greet() {
        System.out.println("Hello from Child");
    }
}

Parent p = new Child();
p.greet();

O/p  : Hello from Parent

Why?
Because method call depends on reference type, not object type. (P -> ref and Child -> Obj)
<!-- Code ends -->
4. private methods -> cannot be overriden as they are bound to compile - time .


| Keyword   | Can it be overridden?  | Why                  |
| --------- | ---------------------  | -------------------- |
| `super`   | ✅ Yes (used)          | Calls parent method  |
| `final`   | ❌ No                  | Method is locked     |
| `static`  | ❌ No                  | Class-level method   |
| `private` | ❌ No                  | Not visible to child |


- Access modifiers : 

1. Default/package-private : accessible inside the package
2. private : Inside the class
3. protected : Class & Subclass
4. Public : Everywhere











