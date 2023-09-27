package CourseWorkTwo.views;

import CourseWorkTwo.BankCard;
import CourseWorkTwo.DebitCard;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayDebitCard extends JFrame {
    public DisplayDebitCard(ArrayList<BankCard> bankCards) {
        super("Display Debit Card");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel displaypanel = new JPanel();
        displaypanel.setLayout(new BoxLayout(displaypanel, BoxLayout.Y_AXIS));

        String[] headerNames = {"Card Id", "Bank Account", "Balance", "Client Name", "Card Type", "Pin", "Has Withdrawn"};
        ArrayList<DebitCard> debitCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof DebitCard) {
                debitCards.add((DebitCard) bankCard);
            }
        }
        String[][] detail = new String[debitCards.size()][7];
        for (int i = 0; i < debitCards.size(); i++) {
            detail[i][0] = String.valueOf(debitCards.get(i).getCardId());
            detail[i][1] = String.valueOf(debitCards.get(i).getBankAccount());
            detail[i][2] = String.valueOf(debitCards.get(i).getBalanceAmount());
            detail[i][3] = String.valueOf(debitCards.get(i).getClientName());
            detail[i][4] =  "Debit Card";
            detail[i][5] = String.valueOf(debitCards.get(i).getPinNumber());
            detail[i][6] = String.valueOf(debitCards.get(i).getHasWithdrawn());
        }
        JTable displayTable = new JTable(detail, headerNames);
        JScrollPane scrollPane = new JScrollPane(displayTable);
        displaypanel.add(scrollPane);
        add(displaypanel);

    }
}
