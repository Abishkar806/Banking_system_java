package CourseWorkTwo.views;

import CourseWorkTwo.BankCard;
import CourseWorkTwo.Components. MyCustomBtn;
import CourseWorkTwo.Components.MyCustomLabel;
import CourseWorkTwo.Components.MyCustomTextField;
import CourseWorkTwo.DebitCard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Color.*;

public class AddDebitCard extends JFrame {

    MyCustomLabel balanceAmountLabelDebitCard,cardIdLabelDebitCard,bankAccountLabelDebitCard,issuerBankLabelDebitCard,clientNameLabelDebitCard,pinNumberLabelDebitCard;
    MyCustomTextField balanceAmountTextFieldDebitCard,cardIdTextFieldDebitCard,bankAccountTextFieldDebitCard,issuerBankTextFieldDebitCard,clientNameTextFieldDebitCard,pinNumberTextFieldDebitCard;
    MyCustomBtn addDebitCardButton , clearBtnDebitCard , displayBtnDebitCard;

    public AddDebitCard(ArrayList<BankCard>bankCards){
        super("Add Debit Card");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        //Creating panel for Debit card
        JPanel addDebitCardPanel = new JPanel();
        addDebitCardPanel.setBounds(80,30,100,50);
        addDebitCardPanel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0),10), "Add DebitCard", TitledBorder.LEFT, TitledBorder.TOP,null, new Color(0,0,0)));
//                ,TitledBorder.CENTER,TitledBorder.TOP,null,new Color(172,216,230)));
        //(.setBorder) creating TitledBorder,LineBorder and Color object to add colorFull title with line border at Top and center
        addDebitCardPanel.setBackground(lightGray);
        addDebitCardPanel.setLayout(null);
        add( addDebitCardPanel);

        //creating label and textField for CardID Debit Card
        cardIdLabelDebitCard =new MyCustomLabel("Card ID");
        cardIdLabelDebitCard.setBounds(50,90,160,20);
        addDebitCardPanel.add(cardIdLabelDebitCard);

        cardIdTextFieldDebitCard = new MyCustomTextField("");
        cardIdTextFieldDebitCard.setBounds(50,130,180,25);
        addDebitCardPanel.add(cardIdTextFieldDebitCard);

        //creating label and textField for PINNumber Debit Card
        pinNumberLabelDebitCard =new MyCustomLabel("PIN Number");
        pinNumberLabelDebitCard.setBounds(300,90,140,20);
        addDebitCardPanel.add( pinNumberLabelDebitCard);

        pinNumberTextFieldDebitCard = new MyCustomTextField("");
        pinNumberTextFieldDebitCard.setBounds(300,130,180,25);
        addDebitCardPanel.add(pinNumberTextFieldDebitCard);


        //creating label and textField for Client Name Debit Card
        clientNameLabelDebitCard =new MyCustomLabel("Client Name");
        clientNameLabelDebitCard.setBounds(50,170,140,20);
        addDebitCardPanel.add( clientNameLabelDebitCard);

        clientNameTextFieldDebitCard = new MyCustomTextField("");
        clientNameTextFieldDebitCard.setBounds(50,210,180,25);
        addDebitCardPanel.add(clientNameTextFieldDebitCard);

        //creating label and textField for Issuer Bank Debit Card
        issuerBankLabelDebitCard =new MyCustomLabel("Issuer Bank");
        issuerBankLabelDebitCard.setBounds(300,170,140,20);
        addDebitCardPanel.add( issuerBankLabelDebitCard);

        issuerBankTextFieldDebitCard = new MyCustomTextField("");
        issuerBankTextFieldDebitCard.setBounds(300,210,180,25);
        addDebitCardPanel.add(issuerBankTextFieldDebitCard);

        //creating label and textField for Bank Account Debit Card
        bankAccountLabelDebitCard =new MyCustomLabel("Bank Account");
        bankAccountLabelDebitCard.setBounds(50,250,140,20);
        addDebitCardPanel.add( bankAccountLabelDebitCard);

        bankAccountTextFieldDebitCard = new MyCustomTextField("");
        bankAccountTextFieldDebitCard.setBounds(50,290,180,25);
        addDebitCardPanel.add(bankAccountTextFieldDebitCard);


        //        creating label and textField for BalanceAmount Debit Card
        balanceAmountLabelDebitCard =new MyCustomLabel("Balance Amount");
        balanceAmountLabelDebitCard.setBounds(300,250,140,20);
        addDebitCardPanel.add(balanceAmountLabelDebitCard);

        balanceAmountTextFieldDebitCard = new MyCustomTextField("");
        addDebitCardPanel.add(balanceAmountTextFieldDebitCard);
        balanceAmountTextFieldDebitCard.setBounds(300,290,180,25);


//<html><With>Withdraw From <br>Debit Card</body></html>
        //Creating Add Debit Card button and clear button
        addDebitCardButton = new  MyCustomBtn("<html><With>Add To<br> Debit Card</body></html>");
        addDebitCardPanel.add(addDebitCardButton);
        addDebitCardButton.setBounds(553,510,120,40);


        //Clear Button for Debit Card
        clearBtnDebitCard = new  MyCustomBtn("Clear");
        addDebitCardPanel.add(clearBtnDebitCard );
        clearBtnDebitCard .setBounds(20,350,120,40);

        //Display Button For Debit Card
        displayBtnDebitCard = new  MyCustomBtn("Display");
        addDebitCardPanel.add(displayBtnDebitCard);
        displayBtnDebitCard.setBounds(20,400,120,40);

        addDebitCardButton.addActionListener(e ->{
            String balanceAmountOfDebitCard = balanceAmountTextFieldDebitCard.getText();
            String cardIDOfDebitCard = cardIdTextFieldDebitCard.getText();
            String bankAccountOfDebitCard = bankAccountTextFieldDebitCard.getText();
            String issuerBankOfDebitCard = issuerBankTextFieldDebitCard.getText();
            String clientNameOfDebitCard = clientNameTextFieldDebitCard.getText();
            String pinNumberOfDebitCard = pinNumberTextFieldDebitCard.getText();

            if (balanceAmountOfDebitCard.equals("") || cardIDOfDebitCard.equals("") || bankAccountOfDebitCard.equals("") || issuerBankOfDebitCard.equals("") || clientNameOfDebitCard.equals("") || pinNumberOfDebitCard.equals("")) {
                JOptionPane.showMessageDialog(null, "Please check that all the required fields are completed before proceeding");
            }else{
                try {
                    double balanceAmount = Double.parseDouble(balanceAmountOfDebitCard);
                    int cardId = Integer.parseInt(cardIDOfDebitCard);
                    int pinNumber = Integer.parseInt(pinNumberOfDebitCard);
                    boolean cardIdFound = false;
                    if (cardId <= 0) {
                        JOptionPane.showMessageDialog(null, "Invalid card ID. Please enter a positive integer.");
                    } else if (balanceAmount <= 0) {
                        JOptionPane.showMessageDialog(null, "Invalid balance amount. Please enter a positive number.");
                    } else if (pinNumber <= 0) {
                        JOptionPane.showMessageDialog(null, "Invalid PIN number. Please enter a positive integer.");
                    } else {
                        for (int i = 0; i < bankCards.size(); i++) {
                            if (bankCards.get(i) instanceof DebitCard && bankCards.get(i).getCardId() == cardId) {
                                cardIdFound = true;
                                break;
                            }
                        }
                    }
                        if (cardIdFound) {
                            JOptionPane.showMessageDialog(null, "Card identification number has already been used by someone else!!");
                        }else {
                        DebitCard debitCard = new DebitCard(balanceAmount, cardId, bankAccountOfDebitCard, issuerBankOfDebitCard, clientNameOfDebitCard, pinNumber);
                        bankCards.add(debitCard);
                        JOptionPane.showMessageDialog(null, "Debit Card added successfully");
                        clearEntry();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid . Please enter a valid number for balance amount, card ID, and PIN number.");
                }
            }

        });

        displayBtnDebitCard.addActionListener(e -> {
            new DisplayDebitCard(bankCards);
        });




    }
    public void clearEntry(){
        balanceAmountTextFieldDebitCard.setText("");
        cardIdTextFieldDebitCard.setText("");
        bankAccountTextFieldDebitCard.setText("");
        issuerBankTextFieldDebitCard.setText("");
        clientNameTextFieldDebitCard.setText("");
        pinNumberTextFieldDebitCard.setText("");


    }
}











