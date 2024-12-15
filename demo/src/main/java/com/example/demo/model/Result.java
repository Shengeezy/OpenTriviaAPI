package com.example.demo.model;

import java.util.List;

public class Result {
    private int score;
    private int totalQuestions;
    private List<AnswerInfo> answerInfo; // To store details of wrong answers


    public Result(int score, int totalQuestions, List<AnswerInfo> answerInfo) {
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.answerInfo = answerInfo;
    }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public int getTotalQuestions() { return totalQuestions; }
    public void setTotalQuestions(int totalQuestions) { this.totalQuestions = totalQuestions; }

    // Inner class to hold details of incorrect answers
    public static class AnswerInfo {
        private String question;
        private String userAnswer;
        private String correctAnswer;

        public AnswerInfo(String question, String userAnswer, String correctAnswer) {
            this.question = question;
            this.userAnswer = userAnswer;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() { return question; }
        public void setQuestion(String question) { this.question = question; }

        public String getUserAnswer() { return userAnswer; }
        public void setUserAnswer(String userAnswer) { this.userAnswer = userAnswer; }

        public String getCorrectAnswer() { return correctAnswer; }
        public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
    }
}
