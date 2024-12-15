//package com.example.demo.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//import com.example.demo.model.Question;
//import com.example.demo.model.TriviaApiResponse;
//
//
//@RestController
//@RequestMapping("/questions")
//public class QuestionController {
//    private final String API_URL = "https://opentdb.com/api.php?amount=10";
//    private final RestTemplate restTemplate;
//    public QuestionController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @GetMapping
//    public List<Question> getQuestions() {
//        TriviaApiResponse response = restTemplate.getForObject(API_URL, TriviaApiResponse.class);
//        return Objects.requireNonNull(response).getResults().stream()
//                .map(this::convertToQuestion)
//                .collect(Collectors.toList());
//    }
//
//    private Question convertToQuestion(TriviaApiResponse.TriviaQuestion result) {
//        if (result.getType().equals("boolean")) {
//            return new Question(result.getQuestion(), "True".equals(result.getCorrect_answer()));
//        } else {
//            return new Question(result.getQuestion(), result.getIncorrect_answers(), result.getCorrect_answer());
//        }
//    }
//}
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.model.Question.QuestionResponse;
import com.example.demo.service.TriviaService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final TriviaService triviaService;

    public QuestionController(TriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @GetMapping
    public List<QuestionResponse> getQuestions() {
        return triviaService.fetchQuestions(); // Fetches and stores questions in the TriviaService
    }
}

