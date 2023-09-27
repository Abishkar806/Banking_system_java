package CourseWorkTwo.Components;

import javax.swing.*;
import java.awt.*;

public class CustomComboBox extends JComboBox {

    public CustomComboBox(String[] values){
        super(values);
        setFont(new Font("Tohama",Font.BOLD,15));
        setMaximumRowCount(5);

    }
}
