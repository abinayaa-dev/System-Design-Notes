UML -> Unified Model Language

Used to model systems.

UML Diagram Importance : 

1. Visualisation
2. Documentation
3. Communication
4. Standardization

Basic Structure of a UML Class Diagram 📦

Class = Name + Data + Actions

---------------------
|   Class Name     |
---------------------
| attributes       |
---------------------
| methods          |
---------------------

Example: Student Class 🎓
-------------------------
|       Student        |
-------------------------
| - name : String      |
| - age  : int         |
| - rollNo : int       |
-------------------------
| + study() : void     |
| + attendClass() : void |
-------------------------

+	Public (anyone can access)
-	Private (only class can access)
:	Type of variable / return type


Relationships : 

1. Association : Represents a relationship between 2 or more classes.
One class uses or knows about another class.

📌 No ownership, no “part-of”, just connection.

-----------+          +-----------+
|  Teacher  |----------|  Student  |
+-----------+          +-----------+

1 Teacher → Many Students:

+-----------+      teaches     +-----------+
|  Teacher  |---------------->|  Student  |
+-----------+   1        *    +-----------+

1	One
*	Many
0..1	Zero or one
1..*	One or more

2. Aggregation : Weak form of Association  =>  “has-a” relationship (weak ownership)

***Aggregation is a weak has-a relationship where the child object can exist independently of the parent object.***

👉 One class has another class
👉 But the child can live independently

🧠 Memory line:
“We stay together, but we can live separately.”

Classroom has Students
Students can exist without classroom

✔️ That is Aggregation

+-------------+      ◇------      +-----------+
|  Classroom  |------------------|  Student  |
+-------------+                  +-----------+

Diamond is on the owner side (Classroom)

In Java : 

class Classroom {
    List<Student> students;  // aggregation
}

3. Composition : “has-a” relationship (STRONG ownership)

***Composition is a strong has-a relationship where the child object’s lifecycle depends on the parent object.***

👉 One class completely owns another
👉 The child cannot exist without the parent

🧠 Golden memory line:
“If the parent dies, the child dies too.”

Example : 

House has Rooms
Room ❌ cannot exist without House
Destroy the house → rooms are gone

✔️ This is Composition

+-------+      ◆------      +------+
| House |------------------| Room |
+-------+                  +------+
🔸 Filled diamond (◆)
👉 Diamond is on the owner side (House)

In java :

class House {
    private Room room = new Room();  // composition
}
👉 House creates the Room
👉 When House is destroyed, Room is too




Type	          Meaning	        Ownership	        Life Cycle

Association     	Knows	        ❌ No	           Independent
Aggregation	     Has-a (weak)	    ✅ Weak	           Independent
Composition	     Has-a (strong)	   ✅ Strong	           Dependent


4. Inheritance : 

Inheritance = “is-a” relationship

***Inheritance represents an is-a relationship where a subclass inherits attributes and behaviors from a superclass.***

👉 Child is a type of Parent
👉 Child inherits properties and methods

🧠 Memory line:

“A child is a parent, but with extra powers.”

Dog is an Animal ✔️

Animal is not a Dog ❌

     Animal
       ▲
       |
      Dog

+----------------+
|     Person     |
+----------------+
| name : String  |
| age : int      |
+----------------+
| walk()         |
+----------------+
        ▲
        |
+----------------+
|    Student     |
+----------------+
| rollNo : int   |
+----------------+
| study()        |
+----------------+

Student gets:
name
age
walk()

In Java : 

class Animal {
    void eat() {}
}

class Dog extends Animal {
    void bark() {}
}
👉 extends = Inheritance

When to use Inheritance : 

Use it ONLY when:
✔️ Relationship makes sense in real life
✔️ Child truly is a parent
✔️ You want polymorphism

❌ Don’t use it just to reuse code

5. Dependency : 

***Dependency is a relationship where one class temporarily uses another class without owning or storing its reference.***

👉 One class depends on another for a short time
👉 No ownership
👉 No stored reference

🧠 Memory line:
“I need you now, not forever.”

Example : 
+--------------+   - - - - - >   +----------------+
| OrderService |                 | PaymentGateway |
+--------------+                 +----------------+
👉 OrderService uses PaymentGateway
👉 Does NOT own it
👉 Passed as parameter / local variable

In java :

1. Method parameter

class OrderService {
    void placeOrder(PaymentGateway pg) {
        pg.pay();
    }

}✔️ PaymentGateway is used
✔️ Not stored → Dependency 

2. Local variable

void print() {
    Printer p = new Printer();
    p.print();
}
✔️ Temporary usage
✔️ Dependency


Feature	                      Dependency	                             Association

Usage	                      Temporary	                                  Long-term
Reference stored?	           ❌ No	                                      ✅ Yes
UML symbol	                 Dashed arrow (----->)	                     Solid line (---------)

Login System Example 🔐
AuthController  - - - - >  AuthService
AuthService     - - - - >  UserRepository
AuthService     - - - - >  TokenGenerator


👉 Controllers & services usually DEPEND, not own

Note : When you see a question:

Ask:

“Is it just helping me do a job?”

YES → Dependency

NO → Look at association / aggregation / composition

6 . Realization : “implements” relationship

***Realization is a relationship where a class implements an interface and provides concrete behavior for its methods.***

👉 A class promises to follow rules of an interface
👉 Interface says what to do
👉 Class says how to do
Interface makes rules. Class realizes (fulfills) them.

Example : 

<<interface>>
        Payment
           ▲
           - - - - - -
                 |
           CreditCardPayment

<<interface>>
+-------------------+
|     Payment       |
+-------------------+
| + pay()           |
+-------------------+
        ▲
        - - - - - -
                |
+-------------------------+
| CreditCardPayment      |
+-------------------------+
| + pay()                |
+-------------------------+

<<interface>>
AuthProvider
    ▲
    - - - - - -
          |
   JWTAuthProvider



Inheritance = IS-A
Realization = FOLLOWS-A-CONTRACT