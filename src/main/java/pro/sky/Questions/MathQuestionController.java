package pro.sky.Questions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    protected MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @RequestMapping("/get")
    public List<Question> get(@RequestParam Integer amount){
        return mathQuestionService.get(amount);
    }

    @RequestMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer){
        return mathQuestionService.add(question, answer);
    }

    @RequestMapping("/remove")
    public Question remove(@RequestParam String question){
        return mathQuestionService.remove(question);
    }

    @RequestMapping("/find")
    public Question find(@RequestParam String question){
        return mathQuestionService.find(question);
    }
}
