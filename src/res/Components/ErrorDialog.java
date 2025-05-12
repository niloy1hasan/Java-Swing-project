package res.Components;

import javax.swing.*;
import java.awt.*;

public class ErrorDialog extends JDialog {
    public ErrorDialog(JFrame mainFrame, String title, String dialogMessage){
        super(mainFrame, title, true);
        setLayout(new BorderLayout());
        setSize(300, 150);
        setLocationRelativeTo(mainFrame);

        JLabel message = new JLabel(dialogMessage, SwingConstants.CENTER);
        message.setFont(new Font("Arial", Font.PLAIN, 13));
        add(message, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.setFocusPainted(false);
        okButton.addActionListener(evt -> dispose());
        JPanel btnPanel = new JPanel();
        btnPanel.add(okButton);
        add(btnPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
