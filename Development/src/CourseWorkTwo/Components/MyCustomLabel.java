package CourseWorkTwo.Components;

import javax.swing.*;
import java.awt.*;

public class MyCustomLabel extends JLabel {
    public MyCustomLabel(String text){
            super(text);
            setFont(new Font("Tohama",Font.BOLD,15));
            setForeground(Color.white);

        }
    }


