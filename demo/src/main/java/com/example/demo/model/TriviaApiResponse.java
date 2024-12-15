package com.example.demo.model;

import java.util.List;

public class TriviaApiResponse {
    private List<TriviaQuestion> results;

    public List<TriviaQuestion> getResults() { return results; }
    public void setResults(List<TriviaQuestion> results) { this.results = results; }

    public static class TriviaQuestion {
        private String type;
        private String question;
        private String correct_answer;
        private List<String> incorrect_answers;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public String getQuestion() { return question; }
        public void setQuestion(String question) { this.question = question; }
        public String getCorrect_answer() { return correct_answer; }
        public void setCorrect_answer(String correct_answer) { this.correct_answer = correct_answer; }
        public List<String> getIncorrect_answers() { return incorrect_answers; }
        public void setIncorrect_answers(List<String> incorrect_answers) { this.incorrect_answers = incorrect_answers; }
    }
}
