package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Question;
import com.example.demo.model.Question.QuestionResponse;
import com.example.demo.model.TriviaApiResponse;

@Service
public class TriviaService {
    private static final String API_URL = "https://opentdb.com/api.php?amount=10";
    private final RestTemplate restTemplate;
    private List<Question> currentQuestions = Collections.emptyList(); // Shared storage

    public TriviaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<QuestionResponse> fetchQuestions() {
        TriviaApiResponse response = restTemplate.getForObject(API_URL, TriviaApiResponse.class);
        currentQuestions = response.getResults().stream()
                .map(this::convertToQuestion)
                .collect(Collectors.toList());
        return currentQuestions.stream()
                .map(Question::toQuestionResponse) // Convert each Question to QuestionResponse
                .collect(Collectors.toList());
    }

    public List<Question> getCurrentQuestions() {
        return currentQuestions;
    }

    private Question convertToQuestion(TriviaApiResponse.TriviaQuestion result) {
        if ("boolean".equals(result.getType())) {
            return new Question(result.getQuestion(), "True".equals(result.getCorrect_answer()));
        } else {
            return new Question(result.getQuestion(), result.getIncorrect_answers(), result.getCorrect_answer());
        }
    }
}
