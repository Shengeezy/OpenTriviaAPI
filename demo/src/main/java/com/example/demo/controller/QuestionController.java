package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.model.Question.QuestionResponse;
import com.example.demo.service.TriviaService;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "${cors.allowed-origins}")
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

