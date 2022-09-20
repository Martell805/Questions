package pro.sky.Questions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    protected JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @RequestMapping("/get")
    public List<Question> get(@RequestParam Integer amount){
        return javaQuestionService.get(amount);
    }

    @RequestMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer){
        return javaQuestionService.add(question, answer);
    }

    @RequestMapping("/remove")
    public Question remove(@RequestParam String question){
        return javaQuestionService.remove(question);
    }

    @RequestMapping("/find")
    public Question find(@RequestParam String question){
        return javaQuestionService.find(question);
    }
}
