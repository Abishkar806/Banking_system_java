package CourseWorkTwo;
public class CreditCard extends BankCard
{
    //instance variable(attributes)
    private int cvcNumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;

    public CreditCard(int cardId,String clientName,String issuerBank,String bankAccount,double balanceAmount,int cvcNumber,double interestRate,String expirationDate){
        // super calls the method from the parent class BankCard.
        super(balanceAmount,cardId,bankAccount,issuerBank);
        super.setClientName(clientName);
        this.cvcNumber=cvcNumber;
        this.interestRate=interestRate;
        this.expirationDate=expirationDate;
        this.isGranted=false;

    }
    //accesor Method(getter method)-->This method is used to obtain or retrieve a particular variable value from a class.
    public int getCvcNumber(){
        return cvcNumber;
    }

    protected double getCreditLimit(){
        return creditLimit;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public String getExpirationDate(){
        return expirationDate;
    }

    protected int getGracePeriod(){
        return gracePeriod;
    }

    protected boolean isGranted(){
        return isGranted;
    }
    //mutator method(Setter Method)-This method takes a parameter and assigns it to the name variable
    public void setCreditLimit(double creditLimit,int gracePeriod){
        if(creditLimit<=2.5*getBalanceAmount()){    
            //if Credit Limit is less than or equal to 2.5 times BalanceAmount than only value will be assign. 
            this.creditLimit=creditLimit;
            this.gracePeriod=gracePeriod;
            this.isGranted=true;
        }
        else{
            System.out.println("Credit cannot be issued!!");

        }
    }
    //This method will remove the client's credit card.
    public void cancelCreditCard(){
        if(this.isGranted==true){
            //If this.isGranted is true than value will be assigned.
            this.cvcNumber=0;
            this.creditLimit=0;
            this.gracePeriod=0;
            this.isGranted=false;
        }
        else{
            System.out.println("Your Credit Card has been cancelled!!");
        }
    }
    //Method used to display the output.
    protected void display(){

        if(this.isGranted==true){
            super.display();//call display method of Parent class(Bank Card).
            System.out.println("CVC number: "+cvcNumber);
            System.out.println("Credit Limit: "+creditLimit);
            System.out.println("Interest Rate: "+interestRate);
            System.out.println("Expiration Date: "+expirationDate);
            System.out.println("Grace Period: "+gracePeriod);
        }else{
            System.out.println("Your Credit Card has not been granted!");
        } 

    }
}

