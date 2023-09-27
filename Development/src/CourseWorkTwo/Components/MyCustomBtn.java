package CourseWorkTwo.Components;

import javax.swing.*;
import java.awt.*;

public class MyCustomBtn extends JButton {

    public MyCustomBtn(String text){
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(true);
        setFont(new Font("Dialog",Font.BOLD,15));
        setForeground(new Color(255,255,255));
        setBackground(new Color(0,102,102));
        setMargin(new Insets(10,10,10,10));
    }
}
