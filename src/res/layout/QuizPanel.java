package res.layout;

import backend_java.Model.Quiz;
import res.Components.TopBar;

import javax.swing.*;
import java.awt.*;

public class QuizPanel extends JPanel {
    JPanel topBar;
    JPanel bottomBar;
    JPanel contentContainer;

    JLabel questionNumber;
    JLabel question;
    JLabel timeLabel;
    JLabel questionTimeLabel;
    JRadioButton option1;
    JRadioButton option2;
    JRadioButton option3;
    JRadioButton option4;
    ButtonGroup optionGroup;
    JButton previousBtn;
    JButton nextBtn;

    JProgressBar quizProgress;

    QuizPanel() {
        setLayout(new BorderLayout());


        //panel part
        topBar = new JPanel();
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.Y_AXIS));

        contentContainer = new JPanel();
        bottomBar = new JPanel();


        //topBar
        topBar.setBackground(Color.BLACK);

        JPanel topHeading = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topHeading.setBackground(Color.BLACK);

        TopBar heading = new TopBar();
        topHeading.add(heading);

        JPanel quizTopBar = new JPanel(new BorderLayout());
        quizTopBar.setPreferredSize(new Dimension(0, 40));
        quizTopBar.setBackground(Color.white);

        ImageIcon menuIcon = new ImageIcon(getClass().getResource("/res/Drawable/menu.png"));
        Image scaledMenuImg = menuIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JLabel menuLabel = new JLabel(new ImageIcon(scaledMenuImg));
        menuLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        quizTopBar.add(menuLabel, BorderLayout.WEST);

        quizProgress = new JProgressBar(0, 100);
        quizProgress.setValue(0);
        quizProgress.setForeground(Color.GREEN);
        quizProgress.setPreferredSize(new Dimension(0, 5));
        quizProgress.setBorderPainted(false);
        quizProgress.setBackground(Color.white);
        quizTopBar.add(quizProgress, BorderLayout.CENTER);


        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        timePanel.setOpaque(false);

        ImageIcon clockIcon = new ImageIcon(getClass().getResource("/res/Drawable/clock.png"));
        Image scaledClockImg = clockIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        JLabel clockLabel = new JLabel(new ImageIcon(scaledClockImg));

        quizTopBar.add(timePanel, BorderLayout.EAST);

        timeLabel = new JLabel("00:00");
        timeLabel.setForeground(Color.black);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 12));

        timePanel.add(clockLabel);
        timePanel.add(timeLabel);

        quizTopBar.add(timePanel, BorderLayout.EAST);


        topBar.add(topHeading);
        topBar.add(quizTopBar);

        // end of topBar


       /* //contentContainer
        contentContainer.setBackground(Color.white);
        contentContainer.setLayout(new GridBagLayout());

        JPanel questionBox = new JPanel();
        questionBox.setLayout(new BoxLayout(questionBox, BoxLayout.Y_AXIS));
//        questionBox.setPreferredSize(new Dimension(600, 500));
//        questionBox.setMinimumSize(new Dimension(400, 350));
        questionBox.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JPanel questionTopContainer = new JPanel(new BorderLayout());
        questionTopContainer.setPreferredSize(new Dimension(600, 40));

        questionNumber = new JLabel("Question No. __");
        questionTimeLabel = new JLabel("--:--");
        questionTopContainer.add(questionNumber, BorderLayout.WEST);
        questionTopContainer.add(questionTimeLabel, BorderLayout.EAST);
        //questionTopContainer.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        questionBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // was 30

        question = new JLabel("------------------------------------------------------------?");

        option1 = new JRadioButton("-----------");
        option2 = new JRadioButton("-----------");
        option3 = new JRadioButton("-----------");
        option4 = new JRadioButton("-----------");

        option1.setFocusPainted(false);
        option2.setFocusPainted(false);
        option3.setFocusPainted(false);
        option4.setFocusPainted(false);

        optionGroup = new ButtonGroup();

        optionGroup.add(option1);
        optionGroup.add(option2);
        optionGroup.add(option3);
        optionGroup.add(option4);


        questionBox.add(questionTopContainer);
        questionBox.add(question);
        //questionBox.add(Box.createVerticalStrut(10));
        questionBox.add(option1);
        questionBox.add(option2);
        questionBox.add(option3);
        questionBox.add(option4);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.NONE;
        contentContainer.add(questionBox, gbc);
        //end of contentContainer

        */

        contentContainer.setBackground(Color.white);
        contentContainer.setLayout(new GridBagLayout());

        JPanel questionBox = new JPanel();
        questionBox.setLayout(new BoxLayout(questionBox, BoxLayout.Y_AXIS));
        questionBox.setBackground(Color.GRAY);

        Dimension fixedSize = new Dimension(600, 500);
        questionBox.setPreferredSize(fixedSize);
        questionBox.setMaximumSize(fixedSize);
        questionBox.setMinimumSize(new Dimension(400, 350));

        questionBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel questionTopContainer = new JPanel(new BorderLayout());
        questionTopContainer.setPreferredSize(new Dimension(600, 40));
        questionTopContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        questionNumber = new JLabel("Question No. __");
        questionTimeLabel = new JLabel("--:--");
        questionTopContainer.add(questionNumber, BorderLayout.WEST);
        questionTopContainer.add(questionTimeLabel, BorderLayout.EAST);


        question = new JLabel("------------------------------------------------------------?");
        question.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setBackground(Color.WHITE);
        optionsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        option1 = new JRadioButton("-----------");
        option2 = new JRadioButton("-----------");
        option3 = new JRadioButton("-----------");
        option4 = new JRadioButton("-----------");

        JRadioButton[] options = {option1, option2, option3, option4};
        optionGroup = new ButtonGroup();

        for (JRadioButton option : options) {
            option.setFocusPainted(false);
            option.setBackground(Color.WHITE);
            option.setAlignmentX(Component.LEFT_ALIGNMENT);
            option.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 5));
            optionGroup.add(option);
            optionsPanel.add(option);
        }

        questionBox.add(questionTopContainer);
        questionBox.add(Box.createVerticalStrut(10));
        questionBox.add(question);
        questionBox.add(Box.createVerticalStrut(10));
        questionBox.add(optionsPanel);

        for (JRadioButton option : options) {
            questionBox.add(option);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.NONE;

        contentContainer.add(questionBox, gbc);


        //bottomBar
        bottomBar.setBackground(Color.BLUE);
        previousBtn = new JButton("Previous");
        nextBtn = new JButton("Next");

        //icon add
        ImageIcon previousIcon = new ImageIcon(getClass().getResource("/res/Drawable/left_arrow.png"));
        Image prevIconImage = previousIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        ImageIcon nextIcon = new ImageIcon(getClass().getResource("/res/Drawable/right_arrow.png"));
        Image nextIconImage = nextIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);


        previousBtn.setIcon(new ImageIcon(prevIconImage));
        nextBtn.setIcon(new ImageIcon(nextIconImage));
        previousBtn.setFocusPainted(false);
        nextBtn.setFocusPainted(false);
        bottomBar.add(previousBtn);
        bottomBar.add(nextBtn);


        //component adding part
        add(topBar, BorderLayout.NORTH);
        add(contentContainer, BorderLayout.CENTER);
        add(bottomBar, BorderLayout.SOUTH);

        //end of bottomBar
    }

    public void setQuestion(int questionNo, Quiz quizList) {
        questionNumber.setText("Question No. " + questionNo);
        question.setText(quizList.getQuestion());
        option1.setText(quizList.getOption(0));
        option2.setText(quizList.getOption(1));
        option3.setText(quizList.getOption(2));
        option4.setText(quizList.getOption(3));
    }


    public ButtonGroup getOptionGroup() {
        return optionGroup;
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public JProgressBar getQuizProgress() {
        return quizProgress;
    }

    public JRadioButton getOption1() {
        return option1;
    }

    public JRadioButton getOption2() {
        return option2;
    }

    public JRadioButton getOption3() {
        return option3;
    }

    public JRadioButton getOption4() {
        return option4;
    }

    public JButton getNextBtn() {
        return nextBtn;
    }

    public JButton getPreviousBtn() {
        return previousBtn;
    }

    public JLabel getQuestionTimeLabel() {
        return questionTimeLabel;
    }
}