package CourseWorkTwo.views;

import CourseWorkTwo.BankCard;
import CourseWorkTwo.Components.MyCustomBtn;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Color.*;

public class Main extends JFrame {

    ArrayList<BankCard> bankCards = new ArrayList<>();

   MyCustomBtn addDebitCardButton,addCreditCardButton,withdrawalBtn,setCreditLimitBtn,cancelCreditCardBtn;

    public Main(){
        getContentPane().setBackground(white);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);      //setting layout null to use our own layout(.setBounds)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(30, 30, 630, 500);
        mainPanel.setBorder(new TitledBorder(new LineBorder(new Color(112,128,144), 10), "Hamro Bank Ltd", TitledBorder.LEFT, TitledBorder.TOP,null, new Color(0,0,0)));
//                , TitledBorder.CENTER, TitledBorder.TOP, null, new Color(172, 216, 230)));
        //(.setBorder) creating TitledBorder,LineBorder and Color object to add colorFull title with line border at Top and center
        mainPanel.setBackground(lightGray);
        mainPanel.setSize(700,600);
        mainPanel.setLayout(null);

        addDebitCardButton = new  MyCustomBtn("Add DebitCard");
        addDebitCardButton.setBounds(150,100,150,50);
        addCreditCardButton = new  MyCustomBtn("Add CreditCard");
        addCreditCardButton.setBounds(350,100,150,50);
        withdrawalBtn = new  MyCustomBtn("<html><With>Withdraw From <br>Debit Card</body></html>");
        withdrawalBtn.setBounds(150,230,150,50);
        setCreditLimitBtn = new  MyCustomBtn("Set Credit Limit");
        setCreditLimitBtn.setBounds(350,230,150,50);
        cancelCreditCardBtn = new  MyCustomBtn("<html><With>Cancel<br>Credit Card</body></html>");
        cancelCreditCardBtn.setBounds(245,360,150,50);




        addDebitCardButton.addActionListener(e ->{
            new AddDebitCard(bankCards);
        });

        addCreditCardButton.addActionListener(e ->{
            new AddCreditCard(bankCards);
        });

        withdrawalBtn.addActionListener(e ->{
            new WithdrawFromDebitCard(bankCards);
        });

        setCreditLimitBtn.addActionListener(e ->{
            new SetCreditLimit(bankCards);
        });

        cancelCreditCardBtn.addActionListener(e ->{
           new CancelCreditCard(bankCards);
        });




        mainPanel.add(addCreditCardButton);
        mainPanel.add(addDebitCardButton);
        mainPanel.add(withdrawalBtn);
        mainPanel.add(setCreditLimitBtn);
        mainPanel.add(cancelCreditCardBtn);

        add(mainPanel);


    }


}
