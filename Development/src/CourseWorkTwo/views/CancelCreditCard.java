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

public class CancelCreditCard extends JFrame {

    MyCustomLabel cancelCreditCardIdLabel;
    MyCustomTextField cancelCreditCardCardIdTextField;
    MyCustomBtn cancelCreditCardBtn , cancelCreditCardClearBtn;

    public CancelCreditCard(ArrayList<BankCard> bankCards){
        super("Cancel Credit Card");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        //Creating panel for cancel credit card
        JPanel cancelCreditCardPanel = new JPanel();
        cancelCreditCardPanel.setBounds(30,30,630,500);
        cancelCreditCardPanel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),10), "Cancel Credit Card", TitledBorder.LEFT, TitledBorder.TOP,null, new Color(0,0,0)));
        //(.setBorder) creating TitledBorder,LineBorder and Color object to add colorFull title with line border at Top and center
        cancelCreditCardPanel.setBackground(lightGray);
        cancelCreditCardPanel.setLayout(null);
        add(cancelCreditCardPanel);

        //Creating label and text field for card ID in set credit limit
        cancelCreditCardIdLabel =new MyCustomLabel("Card ID");
        cancelCreditCardIdLabel.setBounds(300,160,140,20);
        cancelCreditCardPanel.add(cancelCreditCardIdLabel);


        cancelCreditCardCardIdTextField = new MyCustomTextField("");
        cancelCreditCardPanel.add(cancelCreditCardCardIdTextField);
        cancelCreditCardCardIdTextField.setBounds(300,200,180,25);

        //Creating cancel Credit card button
        cancelCreditCardBtn = new MyCustomBtn("<html><With>Cancel Credit<br>Limit</body></html> ");
        cancelCreditCardPanel.add(cancelCreditCardBtn);
        cancelCreditCardBtn.setBounds(553,510,120,40);


        //Clear Button for cancel credit card
        cancelCreditCardClearBtn = new MyCustomBtn("Clear");
        cancelCreditCardPanel.add(cancelCreditCardClearBtn );
        cancelCreditCardClearBtn .setBounds(300,250,120,40);

        cancelCreditCardClearBtn.addActionListener(e -> {
            clearEntry();
        });

        cancelCreditCardBtn.addActionListener(e ->{
            String cardId = cancelCreditCardCardIdTextField.getText();
            if(cardId.equals("")){
                JOptionPane.showMessageDialog(null,"Card Id field is empty.Please Enter a Card Id");
            }else{
                try{
                    int newCardId = Integer.parseInt(cardId);
                    for (BankCard bankCard :bankCards){
                        if(bankCard instanceof CreditCard){
                            if(bankCard.getCardId() ==newCardId) {
                                CreditCard creditCard = (CreditCard) bankCard;
                                creditCard.cancelCreditCard();
                                JOptionPane.showMessageDialog(null, "Credit card is Successfully Cancelled:)");
                                clearEntry();
                                return;
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null,"No credit card found with the entered card id.");
                }catch(NumberFormatException err){
                    JOptionPane.showMessageDialog(null,"Invalid!!Card Id,Please kindly provide valid Card Id!");
                }
            }
            clearEntry();
        });






    }
    public void clearEntry () {
        cancelCreditCardCardIdTextField.setText("");
    }
}
