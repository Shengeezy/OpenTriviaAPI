package com.example.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import com.example.demo.controller.AnswerController;
import com.example.demo.model.Question;
import com.example.demo.model.Result;
import com.example.demo.model.UserAnswer;
import com.example.demo.service.TriviaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnswerControllerTest {

    @Mock
    private TriviaService triviaService;

    private AnswerController answerController;

    @BeforeEach
    public void setUp() {
        answerController = new AnswerController(triviaService);
    }

    @Test
    public void testCheckAnswers() {
        // Given
        List<Question> questions = Arrays.asList(
                new Question("What is 2+2?", Arrays.asList("3", "4", "5", "6"), "4"),
                new Question("What is the capital of France?", Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), "Paris")
        );

        when(triviaService.getCurrentQuestions()).thenReturn(questions);

        List<UserAnswer> userAnswers = Arrays.asList(
                new UserAnswer("What is 2+2?", "4", "4"),
                new UserAnswer("What is the capital of France?", "Madrid", "Paris")
        );

        // When
        Result result = answerController.checkAnswers(userAnswers);

        // Then
        assertEquals(1, result.getScore()); // Verify score
        assertEquals(2, result.getTotalQuestions()); // Verify total questions

        List<Result.AnswerInfo> incorrectAnswers = result.getAnswerInfo();
        assertEquals(1, incorrectAnswers.size()); // There should be one incorrect answer

        Result.AnswerInfo incorrectAnswer = incorrectAnswers.get(0);
        assertEquals("What is the capital of France?", incorrectAnswer.getQuestion());
        assertEquals("Madrid", incorrectAnswer.getUserAnswer());
        assertEquals("Paris", incorrectAnswer.getCorrectAnswer());
    }
}

