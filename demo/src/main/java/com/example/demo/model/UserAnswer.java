package com.example.demo.model;

public class UserAnswer {
    private String question;     // The question text (or an ID if used later)
    private String answer;       // The user's submitted answer

    // Constructor
    public UserAnswer(String question, String answer, String correctAnswer) {
        this.question = question;
        this.answer = answer;
    }

    // Getters and setters
    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
}
