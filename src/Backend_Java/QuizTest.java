package Backend_Java;

import Backend_Java.Model.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizTest {
    private String userName;
    private List<Quiz> quizList = new ArrayList<>();
    private ArrayList<Integer> givenAnswer = new ArrayList<>();
    private ArrayList<Integer> timeLeft = new ArrayList<>();
    private double mark;
    private double bonus;

    public void addAnswer(int questionNumber, int givenAnswer){
        this.givenAnswer.add(questionNumber, givenAnswer);

        if(quizList.get(questionNumber).getAnswerOption()==givenAnswer){
            mark++;
        } else {
            mark -= 0.25;
        }
    }

    public void addUserName(String name){
        this.userName = name;
    }

    public String getUserName(){
        return userName;
    }

    public QuizTest(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public ArrayList<Integer> getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(ArrayList<Integer> givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public double getMark() {
        return mark;
    }

    public void reset(){
        this.userName = null;
        quizList.clear();
        givenAnswer.clear();
        mark = 0;
    }

    public ArrayList<Integer> getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(ArrayList<Integer> timeLeft) {
        this.timeLeft = timeLeft;
    }
}
