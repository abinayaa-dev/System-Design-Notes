package OOPS;

import java.util.HashMap;

public class PaymentService {
    //goal - Store and Make payments
    //For Storing

    HashMap<String,PaymentMethod> paymentMethodHashMap;

    PaymentService()
    {
        paymentMethodHashMap = new HashMap<>();
    }
    //get key and value and store in hashmap => value { name,cardNo}
    public void addPayment(String name, PaymentMethod pm){
        paymentMethodHashMap.put(name,pm);
    }
    //getting the key from the user and making the payment =>print the pay() of the correct class
    void makePayment(String name){
        PaymentMethod pm = paymentMethodHashMap.get(name);
        pm.pay();
    }
}
