package model;

public class Question {
    public String prompt;
    public String answer;

    //EFFECT: creates question with null prompt and answer
    public Question() {
        this.prompt = null;
        this.answer = null;
    }

    // getters
    public String getPrompt() {
        return prompt;
    }

    public String getAnswer() {
        return answer;
    }

    // setters
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
