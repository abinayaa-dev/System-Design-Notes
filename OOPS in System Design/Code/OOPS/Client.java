package OOPS;

public class Client {
    public static void main(String[] args)
    {
        PaymentService ps = new PaymentService();
        ps.addPayment("ReenaCC",new CreditCard("Abee123456","Reena"));
        ps.makePayment("ReenaCC");
    }
}
