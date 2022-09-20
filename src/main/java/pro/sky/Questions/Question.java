package pro.sky.Questions;

import lombok.Data;

@Data
public class Question {
    protected String question;
    protected String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
