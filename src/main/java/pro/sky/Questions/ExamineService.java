package pro.sky.Questions;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ExamineService {
    protected List<QuestionService> questionServices = new ArrayList<>();

    public ExamineService(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.questionServices.add(javaQuestionService);
        this.questionServices.add(mathQuestionService);
    }

    public List<Question> getQuestions(int amount){
        List<Question> questions = new ArrayList<>();
        Random random = new Random();

        for(QuestionService questionService: this.questionServices){
            questions.addAll(questionService.get(random.nextInt() % amount - questions.size()));
        }
        questions.addAll(questionServices.get(0).get(amount - questions.size()));
        Collections.shuffle(questions);

        return questions;
    }

    public List<Question> getQuestions(int amount, int category){
        return this.questionServices.get(category).get(amount);
    }
}
