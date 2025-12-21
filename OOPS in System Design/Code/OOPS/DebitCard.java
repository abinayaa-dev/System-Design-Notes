package OOPS;

public class DebitCard extends Card{

    private String name = super.getName();

    DebitCard(String cardNo, String name) {
        super(cardNo, name);
    }
    @Override
    public void pay(){
        System.out.println("Debit card Payment done for " + name);
    }
}
