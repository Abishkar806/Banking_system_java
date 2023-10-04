package CourseWorkTwo;
public class BankCard
{   
    private int cardId;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private double balanceAmount;

    protected BankCard(double balanceAmount,int cardId, String bankAccount,String issuerBank){
        //value assign-->
        this.balanceAmount=balanceAmount;
        this.cardId=cardId;
        this.bankAccount=bankAccount;
        this.issuerBank=issuerBank;
        this.clientName="";

    }
    //accesor Method(getter method)-->This method is used to obtain or retrieve a particular variable value from a class.
    public double getBalanceAmount(){
        return balanceAmount;
    }

    public int getCardId(){
        return cardId;
    }

    public String getBankAccount(){
        return bankAccount;
    }

    public String getIssuerBank(){
        return issuerBank;
    }

    public String getClientName(){
        return clientName;
    }

    //mutator method(Setter Method)-This method takes a parameter and assigns it to the name variable.
    public void setClientName(String clientName){
        this.clientName=clientName;
    } 

    protected void setBalanceAmount(double balanceAmount){
        this.balanceAmount=balanceAmount;
    }


    protected void display(){
        //if client name is empty suitable message is display.
        if(this.clientName ==""){
            System.out.println("The clientName must required!!");
        }
        else{
            System.out.println("Card ID: "+cardId);
            System.out.println("Client Name: "+clientName);
            System.out.println("Issuer Bank: "+issuerBank);
            System.out.println("Bank Account: "+bankAccount);
            System.out.println("Balance Amount: "+balanceAmount);
        }
    }

}
