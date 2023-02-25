package ui;


import model.Quiz;


import static ui.QuizApp.playGame;


public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        playGame(quiz);
    }

}
