package pro.sky.Questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ExamineServiceTest {
    @InjectMocks
    ExamineService examineService;
    @Mock
    JavaQuestionService javaQuestionService;
    @Mock
    MathQuestionService mathQuestionService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getQuestionsByCategory() {
        List<Question> expected = List.of(
                new Question("j1", "1"),
                new Question("j2", "2"),
                new Question("j3", "3")
        );

        Mockito.when(javaQuestionService.get(3)).thenReturn(expected);

        assertEquals(expected, examineService.getQuestions(3, 0));
    }

    @Test
    void getQuestions() {
        Mockito.when(javaQuestionService.get(0)).thenReturn(new ArrayList<>());
        Mockito.when(javaQuestionService.get(1)).thenReturn(List.of(
                new Question("j1", "1")
        ));
        Mockito.when(javaQuestionService.get(2)).thenReturn(List.of(
                new Question("j1", "1"),
                new Question("j2", "2")
        ));
        Mockito.when(javaQuestionService.get(3)).thenReturn(List.of(
                new Question("j1", "1"),
                new Question("j2", "2"),
                new Question("j3", "3")
        ));

        Mockito.when(mathQuestionService.get(0)).thenReturn(new ArrayList<>());
        Mockito.when(mathQuestionService.get(1)).thenReturn(List.of(
                new Question("m1", "1")
        ));
        Mockito.when(mathQuestionService.get(2)).thenReturn(List.of(
                new Question("m1", "1"),
                new Question("m2", "2")
        ));
        Mockito.when(mathQuestionService.get(3)).thenReturn(List.of(
                new Question("m1", "1"),
                new Question("m2", "2"),
                new Question("m3", "3")
        ));

        List<Question> result = examineService.getQuestions(3);
        result.sort(Comparator.comparing(Question::getQuestion));

        List<List<Question>> expectations = List.of(
                List.of(
                        new Question("j1", "1"),
                        new Question("j2", "2"),
                        new Question("j3", "3")
                ),
                List.of(
                        new Question("j1", "1"),
                        new Question("j2", "2"),
                        new Question("m1", "1")
                ),
                List.of(
                        new Question("j1", "1"),
                        new Question("m1", "1"),
                        new Question("m2", "2")
                ),
                List.of(
                        new Question("m1", "1"),
                        new Question("m2", "2"),
                        new Question("m3", "3")
                )
        );

        assertTrue(expectations.contains(result));
    }
}
