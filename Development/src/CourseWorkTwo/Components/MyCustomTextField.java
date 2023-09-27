package CourseWorkTwo.Components;

import javax.swing.*;
import java.awt.*;

public class MyCustomTextField extends JTextField {

    public MyCustomTextField(String text){
        super(text);
        setColumns(10);
        setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        setFont(new Font("Arial", Font.BOLD, 14));

    }
}
