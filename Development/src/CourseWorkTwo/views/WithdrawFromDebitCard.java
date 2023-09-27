package CourseWorkTwo.views;

import CourseWorkTwo.BankCard;
import CourseWorkTwo.Components.CustomComboBox;
import CourseWorkTwo.Components.MyCustomBtn;
import CourseWorkTwo.Components.MyCustomLabel;
import CourseWorkTwo.Components.MyCustomTextField;
import CourseWorkTwo.DebitCard;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;

import static java.awt.Color.*;

public class WithdrawFromDebitCard extends JFrame {
    MyCustomLabel cardIdLabelWithdrawal, withdrawalAmountLabel, dateOfWithdrawalLabel, pinNumberWithdrawalLabel;

    MyCustomTextField cardIdTextFieldWithdrawal, withdrawalAmountTextField, pinNumberWithdrawalTextField;

    CustomComboBox withdrawalComboBoxYear, withdrawalComboBoxMonth, withdrawalComboBoxDay;

    MyCustomBtn withdrawalBtn, clearBtnWithdrawal, displaybtn;

    public WithdrawFromDebitCard(ArrayList<BankCard> bankCards) {
        super("Withdraw from Debit Card");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        //Creating panel for withdrawal from debit card
        JPanel withdrawalPanel = new JPanel();
        withdrawalPanel.setBounds(30, 30, 630, 500);
        withdrawalPanel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 10), "Withdrawal From Debit Card", TitledBorder.LEFT, TitledBorder.TOP,null, new Color(0,0,0)));
        //(.setBorder) creating TitledBorder,LineBorder and Color object to add colorFull title with line border at Top and center
        withdrawalPanel.setBackground(lightGray);
        withdrawalPanel.setLayout(null);
        add(withdrawalPanel);

        //creating label and textField for CardId Withdrawal
        cardIdLabelWithdrawal = new MyCustomLabel("Card ID:");
        cardIdLabelWithdrawal.setBounds(50, 115, 140, 20);
        withdrawalPanel.add(cardIdLabelWithdrawal);


        cardIdTextFieldWithdrawal = new MyCustomTextField("");
        withdrawalPanel.add(cardIdTextFieldWithdrawal);
        cardIdTextFieldWithdrawal.setBounds(50, 165, 180, 25);

        //creating label and textField for PinNumber(Withdrawal from Debit Card)
        pinNumberWithdrawalLabel = new MyCustomLabel("PIN Number:");
        pinNumberWithdrawalLabel.setBounds(350, 115, 140, 20);
        withdrawalPanel.add(pinNumberWithdrawalLabel);
        pinNumberWithdrawalLabel.setForeground(white);
        pinNumberWithdrawalLabel.setFont(new Font("Tohama", Font.BOLD, 15));

        pinNumberWithdrawalTextField = new MyCustomTextField("");
        withdrawalPanel.add(pinNumberWithdrawalTextField);
        pinNumberWithdrawalTextField.setBounds(350, 165, 180, 25);


        //creating label and textField for withdrawal Amount
        withdrawalAmountLabel = new MyCustomLabel("Withdrawal Amount:");
        withdrawalAmountLabel.setBounds(50, 210, 170, 40);
        withdrawalPanel.add(withdrawalAmountLabel);


        withdrawalAmountTextField = new MyCustomTextField("");
        withdrawalPanel.add(withdrawalAmountTextField);
        withdrawalAmountTextField.setBounds(50, 270, 180, 25);

        //creating label and textField for date of withdrawal
        dateOfWithdrawalLabel = new MyCustomLabel("Date Of Withdrawal:"); //using these tags for line break
        dateOfWithdrawalLabel.setBounds(350, 210, 170, 40);
        withdrawalPanel.add(dateOfWithdrawalLabel);

        //creating ComboBox(dropdown) for Expiration Date
        //ComboBox for years
        withdrawalComboBoxYear = new CustomComboBox(new String[]{
                "Year", "2016", "2017", "2018", "2019",
                "2020", "2021", "2022", "2023", "2024", "2025,", "2026", "2027", "2028", "2029", "2030"

        });
        withdrawalComboBoxYear.setBounds(350, 270, 62, 25);
        withdrawalPanel.add(withdrawalComboBoxYear);

        //ComboBox for months
        withdrawalComboBoxMonth = new CustomComboBox(new String[]{
                "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"
        });
        withdrawalComboBoxMonth.setBounds(415, 270, 72, 25);
        withdrawalPanel.add(withdrawalComboBoxMonth);

        //ComboBox for days
        withdrawalComboBoxDay = new CustomComboBox(new String[]{"Day",
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"

        });
        withdrawalComboBoxDay.setBounds(490, 270, 55, 25);
        withdrawalPanel.add(withdrawalComboBoxDay);





        //Creating Withdrawal button and clear button for withdrawal from debit card
        withdrawalBtn = new MyCustomBtn("Withdrawal");
        withdrawalPanel.add(withdrawalBtn);
        withdrawalBtn.setBounds(550,510,120,40);


        //Clear Button for withdrawal form debit card
        clearBtnWithdrawal = new MyCustomBtn("Clear");
        withdrawalPanel.add(clearBtnWithdrawal);
        clearBtnWithdrawal.setBounds(50, 340, 120, 40);

        //Display button for withdraw from debitCard
        displaybtn = new MyCustomBtn("Display");
        withdrawalPanel.add(displaybtn);
        displaybtn.setBounds(50,390,120,40);

        displaybtn.addActionListener(e ->{
            new DisplayDebitCard(bankCards);
        });

        clearBtnWithdrawal.addActionListener(e ->{
            clearEntry();;
        });




        withdrawalBtn.addActionListener(e -> {
            String cardId = cardIdTextFieldWithdrawal.getText();
            String withdrawalAmount = withdrawalAmountTextField.getText();
            String dateOfWithdrawal = withdrawalComboBoxYear.getSelectedItem() + " " + withdrawalComboBoxMonth.getSelectedItem() + " " + withdrawalComboBoxDay.getSelectedItem();
            String pinNumber = pinNumberWithdrawalTextField.getText();
            if (cardId.equals(" ") || withdrawalAmount.equals(" ") || dateOfWithdrawal.equals(" ") || pinNumber.equals(" ") || withdrawalComboBoxYear.getSelectedIndex() == 0 || withdrawalComboBoxMonth.getSelectedIndex() == 0 || withdrawalComboBoxDay.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please ensure that all the required fields are completed before proceeding!!");

            } else {
                try {
                    int withdrawalCardId = Integer.parseInt(cardId);
                    int withdrawal = Integer.parseInt(withdrawalAmount);
                    int withdrawalPin = Integer.parseInt(pinNumber);
                    boolean cardFound = false;
                    DebitCard debitCard = null;

                    if (withdrawalCardId <= 0) {
                        JOptionPane.showMessageDialog(null, "Invalid card ID. Please enter a positive integer.");
                    } else {
                        for (BankCard bankCard : bankCards) {
                            if (bankCard instanceof DebitCard) {
                                debitCard = (DebitCard) bankCard;
                                if (debitCard.getCardId() == withdrawalCardId) {
                                    cardFound = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (!cardFound) {
                        JOptionPane.showMessageDialog(null, "The card you entered cannot be found in the system.");
                    } else if (withdrawal <= 0) {
                        JOptionPane.showMessageDialog(null, "Invalid withdrawal amount. Please enter a positive number.");
                    } else {
                        Withdraw(debitCard, withdrawalPin, withdrawal, dateOfWithdrawal);
                    }
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Invalid input format. Please enter a valid number for card ID, withdrawal balance amount, and PIN number!");
                }
            }
        });



    }
    public void Withdraw(DebitCard debitCard, int pin, int withdrawal, String dateOfWithdrawal) {
        if (debitCard.getPinNumber() == pin) {
            if (debitCard.getBalanceAmount() < (double)withdrawal) {
                JOptionPane.showMessageDialog((Component)null, "The account does not have sufficient funds to process the requested transaction!!");
                return;
            }

            debitCard.Withdraw(withdrawal, dateOfWithdrawal, pin);
            JOptionPane.showMessageDialog((Component)null, "Your account has been successfully debited with the withdrawn amount :)");
            this.clearEntry();
        } else {
            JOptionPane.showMessageDialog((Component)null, "The PIN you entered is incorrect!!");
        }

    }
    public void clearEntry () {
        cardIdTextFieldWithdrawal.setText("");
        withdrawalAmountTextField.setText("");
        pinNumberWithdrawalTextField.setText("");
        withdrawalComboBoxYear.setSelectedIndex(0);
        withdrawalComboBoxMonth.setSelectedIndex(0);
        withdrawalComboBoxDay.setSelectedIndex(0);


    }


}