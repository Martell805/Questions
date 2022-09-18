package pro.sky.Questions;

import java.util.List;

public interface QuestionRepository {
    void add(Question question);
    void remove(String question_text);
    Question find(String question_text);
    List<Question> get(int amount);
    List<Question> getAll();
}
