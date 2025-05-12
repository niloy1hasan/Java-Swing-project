package res.layout;

import res.Components.TopBar;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {
    JPanel contentContainer;
    JPanel leaderboardPanel;
    JPanel scorePanel;
    JPanel boardPanel;

    JLabel markLabel;
    JLabel correctLabel;
    JButton playBtn;
    JButton leaderboardBtn;
    JButton homeBtn;

    public ResultPanel() {
        setLayout(new BorderLayout());


        //topBar
        TopBar topBar = new TopBar();


        //contentContainer
        contentContainer = new JPanel();
        contentContainer.setBackground(Color.white);
        contentContainer.setLayout(new GridLayout(1, 2));


//        JPanel scorePanel = new JPanel();
//        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.Y_AXIS));
//        scorePanel.setBackground(Color.lightGray);
//        scorePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
//


        scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(3, 1, 0, 10));
        scorePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        scorePanel.setPreferredSize(new Dimension(200, 150));
        scorePanel.setBackground(new Color(245, 245, 245));

        correctLabel = new JLabel("Correct: 7", SwingConstants.CENTER);
        correctLabel.setFont(new Font("Arial", Font.BOLD, 16));
        correctLabel.setForeground(new Color(0, 128, 0));

        JLabel totalLabel = new JLabel("Out of: 10", SwingConstants.CENTER);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setForeground(new Color(70, 70, 70));

        markLabel = new JLabel("Marks: 14", SwingConstants.CENTER);
        markLabel.setFont(new Font("Arial", Font.BOLD, 16));
        markLabel.setForeground(new Color(0, 102, 204));

        scorePanel.add(correctLabel);
        scorePanel.add(totalLabel);
        scorePanel.add(markLabel);

        contentContainer.add(scorePanel);



        leaderboardPanel = new JPanel();
        boardPanel = new JPanel();
        playBtn = new JButton("Play Again");
        leaderboardBtn = new JButton("Leaderboard");
        homeBtn = new JButton("Home");

        playBtn.setFocusPainted(false);
        leaderboardBtn.setFocusPainted(false);
        homeBtn.setFocusPainted(false);

        leaderboardPanel.add(boardPanel);
        leaderboardPanel.add(playBtn);
        leaderboardPanel.add(leaderboardBtn);
        leaderboardPanel.add(homeBtn);

        contentContainer.add(leaderboardPanel);

        //end of contentContainer


        //component adding part
        add(topBar, BorderLayout.NORTH);
        add(contentContainer, BorderLayout.CENTER);
    }

    public JLabel getCorrectLabel() {
        return correctLabel;
    }

    public JLabel getMarkLabel() {
        return markLabel;
    }

    public JButton getLeaderboardBtn() {
        return leaderboardBtn;
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }
}
