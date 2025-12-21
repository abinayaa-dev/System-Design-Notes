package OOPS;

// Inheritance - extends
// when calling methods from the parent class - super keyword

public class CreditCard extends Card{
     CreditCard(String cardNo, String name){
         super(cardNo,name);
     }

     @Override
     public void pay(){
         System.out.printf("Credit Card Payment done for %s through %s%n", getName(),getCardNo() );
     }
}
