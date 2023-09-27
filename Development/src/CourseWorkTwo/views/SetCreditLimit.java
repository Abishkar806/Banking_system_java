package CourseWorkTwo.views;

import CourseWorkTwo.BankCard;
import CourseWorkTwo.Components.MyCustomBtn;
import CourseWorkTwo.Components.MyCustomLabel;
import CourseWorkTwo.Components.MyCustomTextField;
import CourseWorkTwo.CreditCard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Color.*;

public class SetCreditLimit extends JFrame {
    MyCustomLabel cardIdLabelSetCreditLimit,creditLimitLabel,gracePeriodSetCreditLimitLabel;
    MyCustomTextField cardIdTextFieldSetCreditLimit,creditLimitTextField,gracePeriodSetCreditLimitTextField;
    MyCustomBtn setCreditLimitBtn , setCreditLimitClearBtn;
    public SetCreditLimit(ArrayList<BankCard> bankCards){
        super("Withdraw from Debit Card");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        //Creating panel for set credit limit
        JPanel setCreditLimitPanel = new JPanel();
        setCreditLimitPanel.setBounds(30,30,630,500);
        setCreditLimitPanel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),10), "Set Credit Limit", TitledBorder.LEFT, TitledBorder.TOP,null, new Color(0,0,0)));
        //(.setBorder) creating TitledBorder,LineBorder and Color object to add colorFull title with line border at Top and center
        setCreditLimitPanel.setBackground(lightGray);
        setCreditLimitPanel.setLayout(null);
        add( setCreditLimitPanel);

        //Creating label and text field for card ID in set credit limit
        cardIdLabelSetCreditLimit = new MyCustomLabel("Card ID");
        cardIdLabelSetCreditLimit.setBounds(300,115,140,20);
        setCreditLimitPanel.add( cardIdLabelSetCreditLimit);


        cardIdTextFieldSetCreditLimit = new MyCustomTextField("");
        setCreditLimitPanel.add(cardIdTextFieldSetCreditLimit);
        cardIdTextFieldSetCreditLimit.setBounds(300,150,180,25);

        //Creating label and text field for credit limit in set credit limit
        creditLimitLabel =new MyCustomLabel("Credit Limit");
        creditLimitLabel.setBounds(300,180,170,40);
        setCreditLimitPanel.add( creditLimitLabel);


        creditLimitTextField = new MyCustomTextField("");
        setCreditLimitPanel.add(creditLimitTextField);
        creditLimitTextField.setBounds(300,225,180,25);

        //Creating label and text field for grace period in set credit limit
        gracePeriodSetCreditLimitLabel =new MyCustomLabel("Grace Period");
        gracePeriodSetCreditLimitLabel.setBounds(300,255,170,40);
        setCreditLimitPanel.add(gracePeriodSetCreditLimitLabel);


        gracePeriodSetCreditLimitTextField = new MyCustomTextField("");
        setCreditLimitPanel.add(gracePeriodSetCreditLimitTextField);
        gracePeriodSetCreditLimitTextField.setBounds(300,300,180,25);

        //Creating set Credit Limit button and clear button
        setCreditLimitBtn = new MyCustomBtn("Set Limit ");
        setCreditLimitPanel.add(setCreditLimitBtn);
        setCreditLimitBtn.setBounds(550,510,120,40);


        //Clear Button for set credit limit
        setCreditLimitClearBtn = new MyCustomBtn("Clear");
        setCreditLimitPanel.add(setCreditLimitClearBtn );
        setCreditLimitClearBtn .setBounds(300,350,120,40);

        setCreditLimitBtn.addActionListener(e ->{
            String cardId = cardIdTextFieldSetCreditLimit.getText();
            String creditLimit = creditLimitTextField.getText();
            String gracePeriod = gracePeriodSetCreditLimitTextField.getText();

            if(cardId.equals("") || creditLimit.equals("")) {
                JOptionPane.showMessageDialog(null, "Please ensure that all the required fields are completed before proceeding!!");
                return;
            }
            try {
                int newCardId = Integer.parseInt(cardId);
                double newCreditLimit = Double.parseDouble(creditLimit);
                int newGracePeriod = Integer.parseInt(gracePeriod);

                if (newCardId <= 0 ||newCreditLimit <= 0 ||newGracePeriod <= 0) {
                   JOptionPane.showMessageDialog(null,"Invalid input detected for the card ID, credit limit, and grace period fields!!");
                    return;
                }
                CreditCard creditCard = CreditCardFound(newCardId, bankCards);
                if (creditCard == null) {
                    JOptionPane.showMessageDialog(null, "The card you entered is not recognized as a credit card!!");
                    return;
                }

                double balanceAmount = creditCard.getBalanceAmount();
                if(newCreditLimit>2.5*balanceAmount){
                JOptionPane.showMessageDialog(null,"The credit card cannot be issued more credit than 2.5 times its current balance, and the requested amount exceeds this limit!!");
                return;
                }

                creditCard.setCreditLimit(newCreditLimit,newGracePeriod);
                JOptionPane.showMessageDialog(null,"The system has updated your credit limit successfully:) ");
                clearEntry();

            }catch (NumberFormatException err){
                JOptionPane.showMessageDialog(null,"Invalid input detected. Please input only valid numbers for the card ID, credit limit, and grace period fields.!!");
            }

        });

    }
    private CreditCard CreditCardFound(int cardId,ArrayList<BankCard>bankCards){
        for(BankCard bankCard : bankCards){
            if(bankCard.getCardId()==cardId && bankCard instanceof CreditCard){
                return(CreditCard) bankCard;
            }
        }
        return null;

    }
    public void clearEntry(){
        cardIdTextFieldSetCreditLimit.setText("");
        creditLimitTextField.setText("");
        gracePeriodSetCreditLimitTextField.setText("");
    }
}
