package pro.sky.Questions;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaQuestionService implements QuestionService{
    protected QuestionRepository questionRepository;

    public JavaQuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question new_question = new Question(question, answer);
        this.questionRepository.add(new_question);
        return new_question;
    }

    @Override
    public Question remove(String question) {
        Question old_question = this.questionRepository.find(question);
        if(old_question == null) return null;

        this.questionRepository.remove(question);
        return old_question;
    }

    @Override
    public Question find(String question) {
        return this.questionRepository.find(question);
    }

    @Override
    public List<Question> get(int amount) {
        return this.questionRepository.get(amount);
    }
}
