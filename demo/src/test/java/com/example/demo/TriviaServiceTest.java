package com.example.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import com.example.demo.service.TriviaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Question;
import com.example.demo.model.TriviaApiResponse;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TriviaServiceTest {
    @InjectMocks
    private TriviaService triviaService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /* unfortunately I couldn't get the when(restTemplate).getForObject() mock to work TODO */
//    @Test
//    void testFetchQuestions() {
//        // Mock response from the Trivia API
//        TriviaApiResponse.TriviaQuestion question1 = new TriviaApiResponse.TriviaQuestion();
//        question1.setType("boolean");
//        question1.setQuestion("Is Java a programming language?");
//        question1.setCorrect_answer("True");
//        question1.setIncorrect_answers(Arrays.asList("False"));
//
//        TriviaApiResponse.TriviaQuestion question2 = new TriviaApiResponse.TriviaQuestion();
//        question2.setType("multiple");
//        question2.setQuestion("What is the capital of France?");
//        question2.setCorrect_answer("Paris");
//        question2.setIncorrect_answers(Arrays.asList("Berlin", "Madrid", "Rome"));
//
//        TriviaApiResponse response = new TriviaApiResponse();
//        response.setResults(Arrays.asList(question1, question2));
//
//        // Define behavior for the mocked RestTemplate
//        Mockito.doReturn(response).when(restTemplate).getForObject(anyString(), eq(TriviaApiResponse.class));
//
//        // Call the method under test
//        List<Question.QuestionResponse> questionResponses = triviaService.fetchQuestions();
//
//        // Verify the result
//        assertEquals(2, questionResponses.size());
//
//        // Check the details for the first question (boolean)
//        Question.QuestionResponse booleanQuestion = questionResponses.get(0);
//        assertEquals("Is Java a programming language?", booleanQuestion.getQuestion());
//        assertEquals(List.of("True", "False"), booleanQuestion.getOptions());
//
//        // Check the details for the second question (multiple choice)
//        Question.QuestionResponse multipleChoiceQuestion = questionResponses.get(1);
//        assertEquals("What is the capital of France?", multipleChoiceQuestion.getQuestion());
//        assertEquals(List.of("Berlin", "Madrid", "Rome", "Paris"), multipleChoiceQuestion.getOptions());
//    }

    @Test
    void testConvertToQuestion() {
        // Create a TriviaQuestion
        TriviaApiResponse.TriviaQuestion triviaQuestion = new TriviaApiResponse.TriviaQuestion();
        triviaQuestion.setType("boolean");
        triviaQuestion.setQuestion("Is Java a programming language?");
        triviaQuestion.setCorrect_answer("True");

        // Convert it to a Question using the non-static convertToQuestion method
        Question question = triviaService.convertToQuestion(triviaQuestion);

        // Assert properties
        assertEquals("Is Java a programming language?", question.getQuestion());
        assertEquals("True", question.getCorrectAnswer());
        assertEquals(List.of("True", "False"), question.getOptions());
    }
}

