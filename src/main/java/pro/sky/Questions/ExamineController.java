package pro.sky.Questions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamineController {
    ExamineService examineService;

    public ExamineController(ExamineService examineService) {
        this.examineService = examineService;
    }

    @RequestMapping("/get")
    public List<Question> get(@RequestParam Integer amount, @RequestParam(required=false) Integer category){
        if(category == null)
            return examineService.getQuestions(amount);
        return examineService.getQuestions(amount, category);
    }
}
