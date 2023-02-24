package ui;

import model.Monster;
import model.Question;
import model.Quiz;

import java.util.Scanner;

import static model.Quiz.*;

public class QuizApp {

    public static void runQuiz(Quiz quiz) {
            int monsterNumber = 0;
            int isNewMonster = 1;

            for(Question question : quiz.getQuestions()) {
                getDialogue(isNewMonster, quiz, monsterNumber);
                isNewMonster = 0;
                Scanner keyboardInput = new Scanner(System.in);
                System.out.println(question.getPrompt());
                String answer = keyboardInput.nextLine();

                evaluateQuizAnswer(answer, question, quiz, monsterNumber);
                checkIfLevelUp(quiz);

                if(quiz.getMonster(monsterNumber).isDefeated()) {
                    monsterNumber++;
                    isNewMonster = 1;
                }

                if(quiz.isGameOver()) {
                    System.out.println("You've lost all your health. Game over!");
                    break;
                }
                System.out.println("HP: " + quiz.getLife() + "\nLevel: " + quiz.getLevel());
            }

        System.out.println("You've defeated " + quiz.getScore() +
                " monsters and gotten to level " + quiz.getLevel() + "!");
    }

    // CONSTRAINT: isNewMonster must be either 1 or 0
    // EFFECT: returns monster dialogue if isNewMonster is 1
    private static void getDialogue(int isNewMonster, Quiz quiz, int monsterNumber) {
        if (isNewMonster == 1) {
            System.out.println(quiz.getMonster(monsterNumber).getMonsterDialogue());
        }
    }


    public static void evaluateQuizAnswer(String answer, Question question, Quiz quiz, int monsterNumber) {
        if(answer.equals(question.getAnswer())) {
            quiz.attackMonster(quiz.getMonster(monsterNumber));
            if(quiz.getMonster(monsterNumber).isDefeated()) {
                quiz.defeatMonster(quiz.getMonster(monsterNumber));
                System.out.println("You've defeated the monster!");
            } else {
                System.out.println("You've hit the monster once!");
            }
        } else {
            quiz.decreaseLifeByOne();
            System.out.println("Your attack missed, you were hit by the monster!");
        }
    }

    public static void checkIfLevelUp(Quiz quiz) {
        if(quiz.getExp() >= POINTS_NEEDED_TO_LEVEL_UP) {
            quiz.levelUp();
            System.out.println("You've leveled up!");
        }
    }
}

