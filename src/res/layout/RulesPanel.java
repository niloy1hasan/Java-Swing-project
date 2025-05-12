package res.layout;

import res.Components.PrimaryBtn;
import res.Components.TopBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class RulesPanel extends JPanel {
    JPanel bottomBar;
    JPanel contentContainer;
    PrimaryBtn startBtn;

    JPanel RPanel;
    JPanel IPanel;
    JTextPane rules;
    RulesPanel() {
        setLayout(new BorderLayout());

        contentContainer = new JPanel(new GridBagLayout());
        bottomBar = new JPanel();

        TopBar topBar = new TopBar();

        // Rule panel
        RPanel = new JPanel(new BorderLayout());
        RPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 10));
        RPanel.setOpaque(false);

        rules = new JTextPane();
        rules.setContentType("text/html");
        rules.setEditable(false);
        rules.setOpaque(false);
        rules.setBorder(null);
        rules.setFocusable(false);

        rulesText(14);

        RPanel.add(rules, BorderLayout.CENTER);

        // Image panel
        IPanel = new JPanel(new GridBagLayout());
        IPanel.setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/res/Drawable/quiz.png"));
        Image quizImage = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(quizImage));
        IPanel.add(imageLabel);

        // Add to content container
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.gridy = 0;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.weightx = 0.65;
        contentContainer.add(RPanel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.35;
        contentContainer.add(IPanel, gbc);

        // Bottom bar
        bottomBar.setBackground(Color.BLUE);
        startBtn = new PrimaryBtn("Start");
        bottomBar.add(startBtn);

        add(topBar, BorderLayout.NORTH);
        add(contentContainer, BorderLayout.CENTER);
        add(bottomBar, BorderLayout.SOUTH);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = RPanel.getWidth();
                int calculatedFontSize = Math.max(12, Math.min(20, width / 40));
                rulesText(calculatedFontSize);
            }
        });
    }

    private void rulesText(int fontSize) {
        rules.setText("<html>" +
                "<body style='font-family:sans-serif; font-size:" + (fontSize-3) + "px; text-align:left;'>" +
                "<h2 style='color:#2E86C1;'>📝 Quiz Rules</h2>" +
                "<p>• There are <b>10 questions</b> in total.</p>" +
                "<p>• Each question has <b>4 options</b>, and only <b>1 correct answer</b>.</p>" +
                "<p>• You get <b>10 seconds</b> to answer each question.</p>" +
                "<p>• The total quiz time is <b>1 minute 40 seconds</b>.</p>" +
                "<p>• Scoring:</p>" +
                "<ul>" +
                "<li><b>+1 point</b> for a correct answer</li>" +
                "<li><b>-0.25 point</b> for a wrong answer</li>" +
                "<li><b>+0.05 point</b> for each second left if your answer is correct</li>" +
                "</ul>" +
                "<p>• If you don’t answer in time, it will move to the next question.</p>" +
                "<p>• Your final score is the total of all 10 questions and bonus marks.</p>" +
                "</body></html>");
    }

    public PrimaryBtn getStartBtn() {
        return startBtn;
    }
}
