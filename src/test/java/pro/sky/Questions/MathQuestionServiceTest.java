package pro.sky.Questions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @InjectMocks
    MathQuestionService mathQuestionService;

    @Mock
    QuestionRepository questionRepository;

    @Test
    void add() {
        assertEquals(new Question("1", "1"), mathQuestionService.add("1", "1"));
        Mockito.verify(questionRepository, Mockito.only()).add(new Question("1", "1"));
    }

    @Test
    void remove() {
        Mockito.when(questionRepository.find("1")).thenReturn(new Question("1", "1"));

        assertEquals(new Question("1", "1"), mathQuestionService.remove("1"));
        Mockito.verify(questionRepository, Mockito.times(1)).remove("1");
    }

    @Test
    void find() {
        Mockito.when(questionRepository.find("1")).thenReturn(new Question("1", "1"));

        assertEquals(new Question("1", "1"), mathQuestionService.find("1"));
    }

    @Test
    void get() {
        List<Question> expected = List.of(
                new Question("2", "2"),
                new Question("3", "3"),
                new Question("1", "3")
        );

        Mockito.when(questionRepository.get(3)).thenReturn(expected);

        assertEquals(expected, mathQuestionService.get(3));
    }
}
