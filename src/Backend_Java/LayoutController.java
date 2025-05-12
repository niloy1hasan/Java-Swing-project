package Backend_Java;

import Backend_Java.DatabaseHelper.Leaderboard_DAO;
import Backend_Java.DatabaseHelper.Question_DAO;
import Backend_Java.Model.Quiz;
import Backend_Java.Model.Result;
import res.Components.ErrorDialog;
import res.Components.PrimaryBtn;
import res.Components.QuizTimer;
import res.Components.TablePanel;
import res.layout.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LayoutController implements ActionListener, KeyListener{
    MainFrame mainFrame = new MainFrame();
    HomePanel homePanel;
    RulesPanel rulesPanel;
    QuizPanel quizPanel;
    ResultPanel resultPanel;
    LeaderboardPanel leaderboardPanel;

    PrimaryBtn submitBtn;
    PrimaryBtn startBtn;
    JTextField nameInput;
    QuizTest quizTest;
    JProgressBar quizProgress;
    JButton leaderboardBtn;
    PrimaryBtn LBackBtn;
    PrimaryBtn LHomeBtn;
    PrimaryBtn LPlayBtn;
    QuizTimer quizTimer;
    QuizTimer questionTimer;
    JPanel shortTablePanel;
    JPanel fullTablePanel;
    List<Result> leaderboardData;

    int currentQuestion = 0;
    int questionAnswered = 0;

    public LayoutController(){
        homePanel = mainFrame.getHomePanel();
        rulesPanel = mainFrame.getRulesPanel();
        quizPanel = mainFrame.getQuizPanel();
        resultPanel = mainFrame.getResultPanel();
        leaderboardPanel = mainFrame.getLeaderboardPanel();

        submitBtn = homePanel.getSubmitBtn();
        startBtn = rulesPanel.getStartBtn();
        nameInput = homePanel.getNameInput();
        quizProgress = quizPanel.getQuizProgress();
        leaderboardBtn = resultPanel.getLeaderboardBtn();
        shortTablePanel = resultPanel.getBoardPanel();
        fullTablePanel = leaderboardPanel.getContentContainer();

        LBackBtn = leaderboardPanel.getBackBtn();
        LHomeBtn = leaderboardPanel.getHomeBtn();
        LPlayBtn = leaderboardPanel.getPlayBtn();

        quizTimer = new QuizTimer(" Time Left: ",quizPanel.getTimeLabel(), 100);
        questionTimer = new QuizTimer("",quizPanel.getQuestionTimeLabel(), 10);
        submitBtn.addActionListener(this);
        startBtn.addActionListener(this);
        LBackBtn.addActionListener(this);
        LPlayBtn.addActionListener(this);
        LHomeBtn.addActionListener(this);
        leaderboardBtn.addActionListener(this);

        nameInput.addKeyListener(this);
    }



    private List<Quiz> getQuestion() {
        List<Quiz> allQuestions = new Question_DAO().getQuizList();
        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, Math.min(10, allQuestions.size()));
    }

    void startQuiz(){
        mainFrame.showPanel("quiz");
        quizPanel.setQuestion(1, quizTest.getQuizList().get(0));
        showQuestion(currentQuestion);


        quizTimer.startTimer(new Runnable() {
            @Override
            public void run() {
                quizPanel.getTimeLabel().setText("Time's up!");
                mainFrame.showPanel("result");
            }
        });
        setOptionListeners();

        questionTimer.startTimer(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


    void showQuestion(int index) {
        quizPanel.setQuestion(index + 1, quizTest.getQuizList().get(index));
        quizPanel.getOptionGroup().clearSelection();
    }

    void setOptionListeners() {
        quizPanel.getOption1().addActionListener(e -> handleOptionSelected(0));
        quizPanel.getOption2().addActionListener(e -> handleOptionSelected(1));
        quizPanel.getOption3().addActionListener(e -> handleOptionSelected(2));
        quizPanel.getOption4().addActionListener(e -> handleOptionSelected(3));
    }

    void handleOptionSelected(int selectedIndex) {
        quizTest.addAnswer(currentQuestion, selectedIndex);
        ++questionAnswered;
        quizProgress.setValue(questionAnswered*10);

        currentQuestion++;
        if (currentQuestion < quizTest.getQuizList().size()) {
            showQuestion(currentQuestion);
        } else {
            quizTimer.stopTimer();
            double mark = quizTest.getMark();
            LocalDateTime currentTime = LocalDateTime.now();
            new Leaderboard_DAO().addOnLeaderboard(new Result(quizTest.getUserName(), currentTime, mark));
            showResult();
        }
    }

    private void showResult() {
        double mark = quizTest.getMark();
        mainFrame.showPanel("result");
        JLabel markLabel = resultPanel.getMarkLabel();
        JLabel correctAnswerLabel = resultPanel.getCorrectLabel();
        markLabel.setText(mark+"");
        correctAnswerLabel.setText(mark+"");

        insertShortLeaderBoard();
    }

    private void insertShortLeaderBoard() {
        leaderboardData = new Leaderboard_DAO().getLeaderboard();
        leaderboardData.sort(new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                if(o1.getMark()<o2.getMark()){
                    return 1;
                } else if(o1.getMark()>o2.getMark()){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        String[][] data = getStringLeaderboard();

        String[] column = {"Position", "Name", "score", "date"};
        TablePanel shortTable = new TablePanel(data, column);
        JScrollPane scrollPane = new JScrollPane(shortTable);
        shortTablePanel.add(scrollPane);
    }

    private void insertFullTableData() {
        String[][] data = getStringLeaderboard();

        String[] column = {"Position", "Name", "score", "date"};
        TablePanel tablePanel = new TablePanel(data, column);
        JScrollPane scrollPane = new JScrollPane(tablePanel);
        fullTablePanel.add(scrollPane);
    }


    String[][] getStringLeaderboard(){
        String[][] data = new String[leaderboardData.size()][4];
        for(int i=0; i<leaderboardData.size(); i++){
            data[i][0] = String.valueOf(i+1);
            data[i][1] = leaderboardData.get(i).getPersonName();
            data[i][2] = String.valueOf(leaderboardData.get(i).getMark());
            data[i][3] =leaderboardData.get(i).getTime().format(DateTimeFormatter.ofPattern("hh:mm a, dd MMM yyyy"));
        }

        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(submitBtn)){
            if(!nameInput.getText().isEmpty() && !nameInput.getText().isBlank()){
                quizTest = new QuizTest(getQuestion());
                quizTest.addUserName(nameInput.getText());
                mainFrame.showPanel("rules");
            } else {
                new ErrorDialog(mainFrame,"Error","Please enter your name!");
            }
        } else if(source.equals(startBtn)){
            startQuiz();
        } else if(source.equals(LBackBtn)){
            mainFrame.showPanel("result");
        } else if(source.equals(LHomeBtn)){
            quizTest.reset();
            mainFrame.showPanel("home");
            currentQuestion = 0;
            questionAnswered = 0;
            quizTimer.stopTimer();
            quizProgress.setValue(0);
        } else if(source.equals(LPlayBtn)){

        } else if(source.equals(leaderboardBtn)){
            mainFrame.showPanel("leaderboard");
            insertFullTableData();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        Object source = e.getSource();
        if(source.equals(nameInput)) {
            if (e.getKeyCode() != KeyEvent.VK_ENTER) {
                return;
            }
            submitBtn.doClick();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
