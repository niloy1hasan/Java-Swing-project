package Backend_Java;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String question;
    private List<String> option = new ArrayList<>();
    private int answerOption;

    public Quiz(String question, List<String> option, int answerOption) {
        this.question = question;
        this.option = option;
        this.answerOption = answerOption;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOption() {
        return option;
    }

    public String getOption(int position){
        return option.get(position);
    }

    public void setOption(List<String> option) {
        this.option = option;
    }

    public int getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(int answerOption) {
        this.answerOption = answerOption;
    }
}
