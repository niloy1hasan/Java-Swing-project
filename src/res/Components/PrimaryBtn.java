package res.Components;

import javax.swing.*;
import java.awt.*;

public class PrimaryBtn extends JButton {
    public PrimaryBtn(String txt){
        super(txt);
        setBackground(Color.BLUE);
        setFocusPainted(false);
        setForeground(Color.white);
    }


    public PrimaryBtn(String txt, boolean isBold){
        super(txt);
        setBackground(Color.BLUE);
        setFocusPainted(false);
        setForeground(Color.white);
        setFont(new Font("Arial", Font.BOLD, 15));
    }
}
