package pro.sky.Questions;

import java.util.List;

public interface QuestionService {
    Question add(String question, String answer);
    Question remove(String question);
    Question find(String question);
    List<Question> get(int amount);
}
