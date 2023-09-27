package CourseWorkTwo;
public class DebitCard extends BankCard{
    //instance variable
    private int pinNumber;   
    private int withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;

    public DebitCard(double balanceAmount,int cardId,String bankAccount,String issuerBank,String clientName,int pinNumber){
        // super calls the method from the parent class BankCard.
        super(balanceAmount,cardId,bankAccount,issuerBank);
        super.setClientName(clientName);
        this.pinNumber=pinNumber;
        this.hasWithdrawn = false;

    }
    //accesor Method(getter method)-->This method is used to obtain or retrieve a particular variable value from a class.
    public int getPinNumber(){
        return pinNumber;   
    }

    protected int getWithdrawalAmount(){
        return withdrawalAmount;    
    }

    protected String getDateOfWithdrawal(){
        return dateOfWithdrawal;    
    }

    public boolean getHasWithdrawn(){
        return hasWithdrawn;    
    }
    //mutator method(Setter Method)-This method takes a parameter and assigns it to the name variable
    protected void setWithdrawalAmount(int withdrawalAmount){
        this.withdrawalAmount=withdrawalAmount;

    }

    public void Withdraw(int withdrawalAmount,String dateOfWithdrawal,int pinNumber){
        //checking whether pin number is valid or not
        if(this.pinNumber==pinNumber){
            //also checking whether there is sufficent balance or not.
            if(withdrawalAmount<=this.getBalanceAmount()){
                setBalanceAmount(this.getBalanceAmount()-withdrawalAmount); //To reduct withdrawal amount from actual balance amount
                this.withdrawalAmount=withdrawalAmount;
                this.dateOfWithdrawal=dateOfWithdrawal;
                this.hasWithdrawn=true;

            }
            else{
                System.out.println("There is no Sufficent balance in your bank account!!");
            }

        }
        else{
            System.out.println("Pin number is incorrect!!Please try again");
        }

    }

    protected void display(){
        super.display();//call display method of Parent class(Bank Card).
        //if hasWithdrawn is true then pin number,withdrawal Amount and Date of withdrawal will display.
        if(hasWithdrawn==true){
            System.out.println("Pin Number: "+pinNumber);
            System.out.println("Withdrawal Amount: "+withdrawalAmount);
            System.out.println("Date of Withdrawal: "+ dateOfWithdrawal);

        }
        else{
            System.out.println("Your balance is: "+getBalanceAmount());
            System.out.println("Withdrawal has not been made!!");

        }

    }
}
