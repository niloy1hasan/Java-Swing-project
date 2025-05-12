package res.layout;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel container;
    private HomePanel homePanel;
    private RulesPanel rulesPanel;
    private QuizPanel quizPanel;
    private ResultPanel resultPanel;
    private LeaderboardPanel leaderboardPanel;

    public MainFrame(){
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Simple Quiz");
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/drawable/quiz.png"));
        setIconImage(icon.getImage());

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        homePanel = new HomePanel();
        rulesPanel = new RulesPanel();
        leaderboardPanel = new LeaderboardPanel();
        quizPanel = new QuizPanel();
        resultPanel = new ResultPanel();

        container.add(homePanel, "home");
        container.add(rulesPanel, "rules");
        container.add(quizPanel, "quiz");
        container.add(resultPanel, "result");
        container.add(leaderboardPanel, "leaderboard");


        add(container);

        cardLayout.show(container, "home");

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public HomePanel getHomePanel() {
        return homePanel;
    }

    public RulesPanel getRulesPanel(){
        return rulesPanel;
    }

    public QuizPanel getQuizPanel(){
        return quizPanel;
    }

    public void showPanel(String name) {
        cardLayout.show(container, name);
    }

    public LeaderboardPanel getLeaderboardPanel() {
        return leaderboardPanel;
    }

    public ResultPanel getResultPanel() {
        return resultPanel;
    }
}
