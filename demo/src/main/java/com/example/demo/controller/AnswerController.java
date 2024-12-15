package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Question;
import com.example.demo.model.UserAnswer;
import com.example.demo.service.TriviaService;
import com.example.demo.model.Result;

@RestController
@RequestMapping("/checkanswers")
@CrossOrigin(origins = "${cors.allowed-origins}")
public class AnswerController {
    private final TriviaService triviaService;

    public AnswerController(TriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @PostMapping
    public Result checkAnswers(@RequestBody List<UserAnswer> userAnswers) {
        List<Question> currentQuestions = triviaService.getCurrentQuestions(); // Get questions from TriviaService
        int correctAnswers = (int) userAnswers.stream()
                .filter(userAnswer -> {
                    Question question = currentQuestions.stream()
                            .filter(q -> q.getQuestion().equals(userAnswer.getQuestion()))
                            .findFirst()
                            .orElse(null);
                    return question != null && userAnswer.getAnswer().equals(question.getCorrectAnswer());
                })
                .count(); // Count correct answers without explicitly incrementing

        List<Result.AnswerInfo> incorrectAnswerDetails = userAnswers.stream()
                .map(userAnswer -> {
                    Question question = currentQuestions.stream()
                            .filter(q -> q.getQuestion().equals(userAnswer.getQuestion()))
                            .findFirst()
                            .orElse(null);

                    if (question == null)
                        return null;

                    if (!userAnswer.getAnswer().equals(question.getCorrectAnswer())) {
                        return new Result.AnswerInfo(
                                question.getQuestion(),
                                userAnswer.getAnswer(),
                                question.getCorrectAnswer()
                        );
                    }
                    return null;
                })
                .filter(detail -> detail != null) // Only keep non-null details
                .collect(Collectors.toList());

        return new Result(correctAnswers, currentQuestions.size(), incorrectAnswerDetails);
    }
}
