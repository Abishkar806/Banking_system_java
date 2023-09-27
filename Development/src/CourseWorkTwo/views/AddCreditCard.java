package CourseWorkTwo.views;


import CourseWorkTwo.BankCard;
import CourseWorkTwo.Components.CustomComboBox;
import CourseWorkTwo.Components. MyCustomBtn;
import CourseWorkTwo.Components.MyCustomLabel;
import CourseWorkTwo.Components.MyCustomTextField;
import CourseWorkTwo.CreditCard;
import CourseWorkTwo.DebitCard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Color.*;

public class AddCreditCard extends JFrame {


    MyCustomLabel cardIdLabel, clientNameLabel, issuerBankLabel, bankAccountLabel, balanceAmountLabel, CVCNumberLabel, interestRateLabel, expirationDateLabel;
    MyCustomTextField cardIdTextField, clientNameTextField, issuerBankTextField, bankAccountTextField, balanceAmountTextField, CVCNumberTextField, interestRateTextField;
    CustomComboBox expirationDateComboBoxYear,expirationDateComboBoxMonth,expirationDateComboBoxDay;
    MyCustomBtn addCreditLimitBtn, clearButton ,displayCreditCardBtn;

    public AddCreditCard(ArrayList<BankCard> bankCards) {
        super("Add Credit Card");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

        //Creating panel for Credit card
        JPanel addCreditCardPanel = new JPanel();
        addCreditCardPanel.setBounds(30, 30, 630, 500);
        addCreditCardPanel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 10), "Add Credit Card", TitledBorder.LEFT, TitledBorder.TOP,null, new Color(0,0,0)));
        //(.setBorder) creating TitledBorder,LineBorder and Color object to add colorFull title with line border at Top and center
        addCreditCardPanel.setBackground(lightGray);
        addCreditCardPanel.setLayout(null);
        add(addCreditCardPanel);

        //creating label and textField for CardID Credit Card
        cardIdLabel =new MyCustomLabel("Card ID:");
        cardIdLabel.setBounds(50,70,140,20);
        addCreditCardPanel.add(cardIdLabel);

        cardIdTextField = new MyCustomTextField("");
        cardIdTextField.setBounds(50,110,180,25);
        addCreditCardPanel.add(cardIdTextField);

        //creating label and textField for CVC Number Credit Card
        CVCNumberLabel =new MyCustomLabel("CVC Number:");
        CVCNumberLabel.setBounds(350,70,140,20);
        addCreditCardPanel.add(CVCNumberLabel);

        CVCNumberTextField = new MyCustomTextField("");
        addCreditCardPanel.add(CVCNumberTextField);
        CVCNumberTextField.setBounds(350,110,180,25);



        //creating label and textField for issuerBank Credit Card
        issuerBankLabel =new MyCustomLabel("Issuer Bank");
        issuerBankLabel.setBounds(50,150,140,20);
        addCreditCardPanel.add(issuerBankLabel);

        issuerBankTextField = new MyCustomTextField("");
        addCreditCardPanel.add(issuerBankTextField);
        issuerBankTextField.setBounds(50,190,180,25);


        //creating label and textField for BankAccount Credit Card
        bankAccountLabel =new MyCustomLabel("Bank Account:");
        bankAccountLabel.setBounds(350,150,140,20);
        addCreditCardPanel.add(bankAccountLabel);

        bankAccountTextField = new MyCustomTextField("");
        addCreditCardPanel.add(bankAccountTextField);
        bankAccountTextField.setBounds(350,190,180,25);

        //creating label and textField for BalanceAmount CreditCard
        balanceAmountLabel =new MyCustomLabel("Balance Amount:");
        balanceAmountLabel.setBounds(50,230,140,20);
        addCreditCardPanel.add(balanceAmountLabel);

        balanceAmountTextField = new MyCustomTextField("");
        addCreditCardPanel.add(balanceAmountTextField);
        balanceAmountTextField.setBounds(50,270,180,25);

        //creating label and textField for clientName Credit Card
        clientNameLabel =new MyCustomLabel("Client Name");
        clientNameLabel.setBounds(350,230,140,20);
        addCreditCardPanel.add(clientNameLabel);

        clientNameTextField = new MyCustomTextField("");
        addCreditCardPanel.add(clientNameTextField);
        clientNameTextField.setBounds(350,270,180,25);

        //creating label and textField for Interest Rate Credit Card
        interestRateLabel =new MyCustomLabel("Interest Rate");
        interestRateLabel.setBounds(50,310,140,20);
        addCreditCardPanel.add(interestRateLabel);
        interestRateLabel.setForeground(white);
        interestRateLabel.setFont(new Font("Tohama",Font.BOLD,15));

        interestRateTextField = new MyCustomTextField("");
        addCreditCardPanel.add(interestRateTextField);
        interestRateTextField.setBounds(50,350,180,25);

        //creating label and JComboBox(dropdown) for Expiration Date
        expirationDateLabel =  new MyCustomLabel("Expiration Date");
        expirationDateLabel.setBounds(350,310,140,20);
        addCreditCardPanel.add(expirationDateLabel);

        //ComboBox for years
        expirationDateComboBoxYear = new CustomComboBox(new String[]{
                "Year", "2016", "2017", "2018", "2019",
                "2020", "2021", "2022", "2023", "2024", "2025,","2026","2027","2028","2029","2030","2031","2032","2033","2034","2 "

        });
        expirationDateComboBoxYear.setBounds(350,350,62,25);
        addCreditCardPanel.add(expirationDateComboBoxYear);

        //ComboBox for months
        expirationDateComboBoxMonth = new CustomComboBox(new String[]{
                "Month","01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12"
        });
        expirationDateComboBoxMonth.setBounds(415,350,72,25);
        addCreditCardPanel.add(expirationDateComboBoxMonth);

        //ComboBox for days
        expirationDateComboBoxDay = new CustomComboBox(new String[]{"Day",
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12","13","14","15","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30","31"

        });
        expirationDateComboBoxDay.setBounds(490,350,55,25);
        addCreditCardPanel.add(expirationDateComboBoxDay);








        //Creating Add Credit limit button and clear button Credit Card
        addCreditLimitBtn = new  MyCustomBtn("<html><With>Add To <br>Credit  Card</body></html>");
        addCreditCardPanel.add(addCreditLimitBtn);
        addCreditLimitBtn.setBounds(553,510,120,40);

        //Clear Button for credit card
        clearButton = new  MyCustomBtn("Clear");
        addCreditCardPanel.add(clearButton );
        clearButton .setBounds(50,410,120,40);

        //Display Button for Credit Card
        displayCreditCardBtn =new  MyCustomBtn("Display");
        addCreditCardPanel.add(displayCreditCardBtn);
        displayCreditCardBtn.setBounds(50,470,120,40);

        clearButton.addActionListener(e ->{
            clearEntry();
        });

        addCreditLimitBtn.addActionListener(e ->{
            String cardIdOfCreditCard = cardIdTextField.getText();
            String clientNameOfCreditCard = clientNameTextField.getText();
            String issuerBankCreditCard = issuerBankTextField.getText();
            String bankAccountCreditCard = bankAccountTextField.getText();
            String balanceAmountCreditCard = balanceAmountTextField.getText();
            String interestRateCreditCard = interestRateTextField.getText();
            String CVCNumberCreditCard =CVCNumberTextField.getText();

            if(issuerBankCreditCard.equals("") || clientNameOfCreditCard.equals("") || bankAccountCreditCard.equals("") ||cardIdOfCreditCard.equals("")  || balanceAmountCreditCard.equals("") || CVCNumberCreditCard.equals("") || interestRateCreditCard.equals("")){
                JOptionPane.showMessageDialog(null,"Before moving further, please make sure that all the mandatory fields are filled out.");
            } else if (expirationDateComboBoxYear.getSelectedIndex() == 0 || expirationDateComboBoxMonth.getSelectedIndex() == 0 || expirationDateComboBoxDay.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null,"Kindly choose the year, month, and day!");
            }else{
                try{
                    int cardId = Integer.parseInt(cardIdOfCreditCard);
                    int cvcNumber = Integer.parseInt(CVCNumberCreditCard);
                    double balanceAmount = Double.parseDouble(balanceAmountCreditCard);
                    double interestRate = Double.parseDouble(interestRateCreditCard);
                    boolean cardIdFound =false;
                    String expirationDate = expirationDateComboBoxYear.getSelectedItem() + "-" +expirationDateComboBoxMonth.getSelectedItem() + "-" + expirationDateComboBoxDay.getSelectedItem();
                    if (cardId <= 0) {
                        JOptionPane.showMessageDialog(null, "Card ID is invalid. Enter a positive number only.\n");
                        return;
                    } else if (balanceAmount <= 0) {
                        JOptionPane.showMessageDialog(null, "Balance Amount  not valid. Kindly input a positive number.\n");
                        return;
                    } else if (cvcNumber <= 0) {
                        JOptionPane.showMessageDialog(null, "CVC number is invalid. Kindly input a positive number.");
                        return;
                    } else if (interestRate <= 0) {
                        JOptionPane.showMessageDialog(null, "Interest rate is invalid. Enter a positive number only.");
                        return;
                    } else {
                        for (int i = 0; i < bankCards.size(); i++) {
                            if (bankCards.get(i) instanceof CreditCard && bankCards.get(i).getCardId() == cardId) {
                                cardIdFound = true;
                                break;
                            }
                        }
                    }
                    if (cardIdFound) {
                        JOptionPane.showMessageDialog(null, "The card's unique identifier has already been used or claimed by another person.!");
                    } else {
                        CreditCard creditCard = new CreditCard(cardId,clientNameOfCreditCard,issuerBankCreditCard,bankAccountCreditCard,balanceAmount,cvcNumber,interestRate,expirationDate);
                        bankCards.add(creditCard);
                        JOptionPane.showMessageDialog(null, "Adding a credit card was successful.");
                        clearEntry();
                    }



                }catch (NumberFormatException ne){
                    JOptionPane.showMessageDialog(null, "Invalid input format. Please enter a valid number for card ID, balance amount, CVC number, and interest rate.");
                }
            }
        });

        displayCreditCardBtn.addActionListener(e -> {
            new DisplayCreditCard(bankCards);
        });

    }
    public void clearEntry(){
        cardIdTextField.setText("");
        clientNameTextField.setText("");
        issuerBankTextField.setText("");
        bankAccountTextField.setText("");
        balanceAmountTextField.setText("");
        CVCNumberTextField.setText("");
        interestRateTextField.setText("");
        expirationDateComboBoxYear.setSelectedIndex(0);
        expirationDateComboBoxMonth.setSelectedIndex(0);
        expirationDateComboBoxDay.setSelectedIndex(0);

    }
}
























