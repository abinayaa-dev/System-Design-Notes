package OOPS;

public class UPIPayment implements PaymentMethod{
    private String upiId;
    UPIPayment(String upiId)
    {
        this.upiId = upiId;
    }
    public String getId()
    {
        return upiId;
    }

    public void pay()
    {
        System.out.println("Payment done using UPI "+upiId);
    }
}
