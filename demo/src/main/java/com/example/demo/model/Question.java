package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;      // The question text
    private List<String> options; // List of options (including the correct answer)
    private String correctAnswer; // The correct answer (not exposed to the user)

    // Constructor for multiple-choice questions
    public Question(String question, List<String> incorrectAnswers, String correctAnswer) {
        this.question = question;
        this.options = new ArrayList<>(incorrectAnswers);
        this.options.add(correctAnswer); // Add the correct answer to the options
        this.correctAnswer = correctAnswer;
    }

    // Constructor for true/false questions
    public Question(String question, boolean correctAnswer) {
        this.question = question;
        this.options = List.of("True", "False");
        this.correctAnswer = correctAnswer ? "True" : "False";
    }

    // Getters and setters
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }

    // Publicly accessible method to get a QuestionResponse (without the correct answer)
    public QuestionResponse toQuestionResponse() {
        return new QuestionResponse(this.question, this.options);
    }

    public static class QuestionResponse {
        private String question;      // The question text
        private List<String> options; // List of options (excluding the correct answer)

        // Constructor
        public QuestionResponse(String question, List<String> options) {
            this.question = question;
            this.options = options;
        }

        // Getters
        public String getQuestion() { return question; }
        public List<String> getOptions() { return options; }
    }
}
