package com.example.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import com.example.demo.controller.QuestionController;
import com.example.demo.model.Question.QuestionResponse;
import com.example.demo.service.TriviaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class QuestionControllerTest {

    @Mock
    private TriviaService triviaService;

    private QuestionController questionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize the mocks
        questionController = new QuestionController(triviaService);
    }

    @Test
    public void testGetQuestions() {
        List<QuestionResponse> expectedQuestions = Arrays.asList(
                new QuestionResponse("What is 2+2?", Arrays.asList("3", "4", "5", "6")),
                new QuestionResponse("What is the capital of France?", Arrays.asList("Berlin", "Madrid", "Paris", "Rome"))
        );

        when(triviaService.fetchQuestions()).thenReturn(expectedQuestions);

        List<QuestionResponse> actualQuestions = questionController.getQuestions();

        assertEquals(expectedQuestions, actualQuestions); // Check if the fetched questions match the expected questions
    }
}
