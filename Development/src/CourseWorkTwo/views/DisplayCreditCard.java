package CourseWorkTwo.views;

import CourseWorkTwo.BankCard;
import CourseWorkTwo.CreditCard;
import CourseWorkTwo.DebitCard;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayCreditCard extends JFrame {
    public DisplayCreditCard(ArrayList<BankCard> bankCards) {
        super("Display Credit Cards");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        String[] headersName = {"Card Id", "Client Name", "Issuer Bank", "Bank Account ","Card Type", "Balance Amount", "Interest Rate", "CVC Number", "Expiration Date"};
        ArrayList<CreditCard> creditCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof CreditCard) {
                creditCards.add((CreditCard) bankCard);
            }
        }
        String[][] detail = new String[creditCards.size()][9];
        for (int a = 0; a < creditCards.size(); a++) {
            detail[a][0] = String.valueOf(creditCards.get(a).getCardId());
            detail[a][1] = String.valueOf(creditCards.get(a).getClientName());
            detail[a][2] = String.valueOf(creditCards.get(a).getIssuerBank());
            detail[a][3] = String.valueOf(creditCards.get(a).getBankAccount());
            detail[a][4] =  "Credit Card";
            detail[a][5] = String.valueOf(creditCards.get(a).getBalanceAmount());
            detail[a][6] = String.valueOf(creditCards.get(a).getInterestRate());
            detail[a][7] = String.valueOf(creditCards.get(a).getCvcNumber());
            detail[a][8] = String.valueOf(creditCards.get(a).getExpirationDate());
        }
        JTable displayTable = new JTable(detail, headersName);
        JScrollPane scrollPane = new JScrollPane(displayTable);
        displayPanel.add(scrollPane);
        add(displayPanel);
    }
}
