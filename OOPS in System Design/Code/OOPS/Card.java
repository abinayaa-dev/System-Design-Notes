package OOPS;
//parent class
abstract public class Card implements PaymentMethod{
    private String cardNo;
    private String name;

    Card(String cardNo,String name)
    {
        this.cardNo = cardNo;
        this.name = name;
    }

    protected String getCardNo()
    {
        return cardNo;
    }

    protected String getName(){
        return name;
    }

    //when we dont know how to implement a method - make it abstract
   // abstract void pay();
}
