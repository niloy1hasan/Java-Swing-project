package res.layout;

import res.Components.PrimaryBtn;
import res.Components.TopBar;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    JPanel bottomBar;
    JPanel contentContainer;
    JTextField nameInput;
    PrimaryBtn submitBtn;
    JPanel formPanel;

    public HomePanel(){
        setLayout(new BorderLayout());
        setBackground(Color.white);


        //panel part
        contentContainer = new JPanel();
        bottomBar = new JPanel();



        //topBar
        TopBar topBar = new TopBar();

        //contentContainer
        contentContainer.setBackground(Color.WHITE);
        contentContainer.setLayout(new GridLayout(1, 2));

        formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        //imagePanel = new JPanel();

        JLabel headingLabel = new JLabel("Welcome to the Quiz!");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(headingLabel);
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        nameLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        formPanel.add(nameLabel);

        nameInput = new JTextField();
        nameInput.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        nameInput.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        nameInput.setBackground(new Color(245, 245, 245));
        nameInput.setCaretColor(Color.BLACK);



        submitBtn = new PrimaryBtn("Submit", true);
        submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        formPanel.add(nameInput);
        formPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        formPanel.add(submitBtn);

        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/res/Drawable/quiz.png"));
        Image quizImage = imageIcon.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);

        JLabel imageLabel = new JLabel(new ImageIcon(quizImage));
        imagePanel.add(imageLabel);

        JPanel formWrapper = new JPanel(new GridBagLayout());
        formWrapper.add(formPanel);

        JPanel imageWrapper = new JPanel(new GridBagLayout());
        imageWrapper.add(imageLabel);

        contentContainer.add(formWrapper);
        contentContainer.add(imageWrapper);
        //end of contentContainer


        //bottomBar
        JLabel bottomLine = new JLabel("Developed by: Niloy Hasan Nahid");
        bottomLine.setFont(new Font("Arial", Font.PLAIN, 10));
        bottomLine.setForeground(Color.gray);
        bottomBar.add(bottomLine);


        //component adding part
        add(topBar, BorderLayout.NORTH);
        add(contentContainer, BorderLayout.CENTER);
        add(bottomBar, BorderLayout.SOUTH);
        //end of bottomBar
    }

    public JTextField getNameInput() {
        return nameInput;
    }

    public PrimaryBtn getSubmitBtn() {
        return submitBtn;
    }
}
