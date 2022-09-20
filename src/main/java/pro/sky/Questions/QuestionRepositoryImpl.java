package pro.sky.Questions;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class QuestionRepositoryImpl implements QuestionRepository{
    protected List<Question> questions;

    public QuestionRepositoryImpl(){
        questions = new ArrayList<>();
    }

    @Override
    public void add(Question question) {
        Question existingQuestion = this.find(question.getQuestion());
        if(existingQuestion != null)
            this.questions.remove(existingQuestion);

        this.questions.add(question);
    }

    @Override
    public void remove(String question_text) {
        this.questions.remove(this.find(question_text));
    }

    @Override
    public Question find(String question_text) {
        return questions.stream()
                .filter(
                        question -> question.getQuestion().equals(question_text)
                )
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Question> get(int amount) {
        List<Question> shuffled_questions = this.getAll();
        Collections.shuffle(shuffled_questions);

        return shuffled_questions.stream()
                .limit(amount)
                .collect(Collectors.toList());
    }

    @Override
    public List<Question> getAll() {
        return new ArrayList<>(questions);
    }
}
