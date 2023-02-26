package model;

//represents a question with a prompt and answer
public class Question {
    private String prompt;
    private String answer;

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
