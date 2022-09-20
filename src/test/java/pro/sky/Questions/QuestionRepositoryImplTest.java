package pro.sky.Questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionRepositoryImplTest {
    QuestionRepositoryImpl questionRepository;

    @BeforeEach
    void setUp() {
        questionRepository = new QuestionRepositoryImpl();
        questionRepository.add(new Question("1", "1"));
        questionRepository.add(new Question("2", "2"));
        questionRepository.add(new Question("3", "3"));
        questionRepository.add(new Question("1", "3"));
    }

    @Test
    void add() {
        List<Question> expected = List.of(
                new Question("2", "2"),
                new Question("3", "3"),
                new Question("1", "3")
        );

        assertEquals(expected, questionRepository.getAll());
    }

    @Test
    void remove() {
        List<Question> expected = List.of(
                new Question("2", "2"),
                new Question("1", "3")
        );

        questionRepository.remove("3");

        assertEquals(expected, questionRepository.getAll());
    }

    @Test
    void find() {
        Question expected = new Question("1", "3");

        assertEquals(expected, questionRepository.find("1"));
    }

    @Test
    void get() {
        List<Question> result = questionRepository.get(2);

        assertSame(2, result.size());
        assertEquals(questionRepository.find(result.get(0).getQuestion()), result.get(0));
        assertEquals(questionRepository.find(result.get(1).getQuestion()), result.get(1));
    }
}