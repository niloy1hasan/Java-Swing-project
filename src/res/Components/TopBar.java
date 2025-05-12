package res.Components;

import javax.swing.*;
import java.awt.*;

public class TopBar extends JPanel {
    JLabel appName;

    public TopBar(){
        setBackground(Color.BLACK);
        appName = new JLabel(" SimpQuiz");
        appName.setForeground(Color.WHITE);
        appName.setFont(new Font("Arial", Font.BOLD, 24));
        add(appName);
    }
}
