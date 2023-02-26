package ui;

import model.Monster;
import model.Question;
import model.Quiz;

import java.util.Objects;
import java.util.Scanner;

//quiz game application
public class QuizGame {

    private static int EXP_NEEDED_TO_LEVEL_UP = 3;

    //EFFECT: runs the game menu
    public static void playGame(Quiz quiz) {
        System.out.println("Enter 'start' to play the game or 'add' to add a new monster to the quiz. \nThe "
                + "quiz currently has " + quiz.getQuestions().size() + " questions.");
        Scanner keyboardInput = new Scanner(System.in);
        String input = keyboardInput.nextLine();
        if (Objects.equals(input, "start")) {
            System.out.println("Starting the game with " + quiz.getQuestions().size() + " questions");
            runQuiz(quiz);
        } else if (Objects.equals(input, "add")) {
            addingMonsters(quiz);
        } else {
            System.out.println("Please enter a proper command.");
            playGame(quiz);
        }
    }

    //EFFECT: runs the menu to add monsters to quiz
    public static void addingMonsters(Quiz quiz) {
        System.out.println("Choose the size of the monster you want to add: 1, 2, or 3.");
        Scanner newInput = new Scanner(System.in);
        int sizeInput = newInput.nextInt();
        if (sizeInput == 1) {
            addSmallMonster(quiz);
            playGame(quiz);
        } else if (sizeInput == 2) {
            addMediumMonster(quiz);
            playGame(quiz);
        } else if (sizeInput == 3) {
            addLargeMonster(quiz);
            playGame(quiz);
        } else {
            System.out.println("That's an invalid size!");
            playGame(quiz);
        }
    }

    //MODIFIES: this
    //EFFECT: prompts player to add small monster to quiz
    public static void addSmallMonster(Quiz quiz) {
        Monster smallMonster = new Monster(1);
        quiz.addMonster(smallMonster);
        System.out.println("You will need to add 1 question to the quiz.");
        addOneQuestion(quiz);
    }

    //MODIFIES: this
    //EFFECT: prompts player to add medium monster to quiz
    public static void addMediumMonster(Quiz quiz) {
        Monster mediumMonster = new Monster(2);
        quiz.addMonster(mediumMonster);
        System.out.println("You will need to add 2 questions to the quiz.");
        addOneQuestion(quiz);
        addOneQuestion(quiz);
    }

    //MODIFIES: this
    //EFFECT: prompts player to add large monster to quiz
    public static void addLargeMonster(Quiz quiz) {
        Monster largeMonster = new Monster(3);
        quiz.addMonster(largeMonster);
        System.out.println("You will need to add 3 questions to the quiz.");
        addOneQuestion(quiz);
        addOneQuestion(quiz);
        addOneQuestion(quiz);
    }

    //MODIFIES: this
    //EFFECT: prompts the player to input a question and answer and adds it to quiz
    public static void addOneQuestion(Quiz quiz) {
        Question question = new Question();
        Scanner keyboardInput = new Scanner(System.in);

        System.out.println("Please enter a new question prompt");
        String prompt = keyboardInput.nextLine();
        question.setPrompt(prompt);

        System.out.println("Please enter a new question answer");
        String answer = keyboardInput.nextLine();
        question.setAnswer(answer);

        quiz.addQuestion(question);
    }

    //CONSTRAINT: quiz must have at least one monster added
    //MODIFIES: this
    //EFFECT: starts the quiz game, updating player stats along the way
    public static void runQuiz(Quiz quiz) {
        int monsterNumber = 0;
        int isNewMonster = 1;

        for (Question question : quiz.getQuestions()) {
            getDialogue(isNewMonster, quiz, monsterNumber);
            isNewMonster = 0;
            Scanner keyboardInput = new Scanner(System.in);
            System.out.println("Answer the following question: " + question.getPrompt());
            String answer = keyboardInput.nextLine();

            evaluateQuizAnswer(answer, question, quiz, monsterNumber);
            checkIfLevelUp(quiz);
            if (quiz.getMonster(monsterNumber).isDefeated()) {
                monsterNumber++;
                isNewMonster = 1;
            }
            if (quiz.isGameOver()) {
                System.out.println("You've lost all your health. Game over!");
                break;
            }
            System.out.println("HP: " + quiz.getHp() + "\nLevel: " + quiz.getLevel());
        }
        System.out.println("You've defeated " + quiz.getScore()
                + " monsters and gotten to level " + quiz.getLevel() + "!");
    }

    //CONSTRAINT: isNewMonster must be either 1 or 0
    //EFFECT: returns monster dialogue if isNewMonster is 1
    private static void getDialogue(int isNewMonster, Quiz quiz, int monsterNumber) {
        if (isNewMonster == 1) {
            System.out.println(quiz.getMonster(monsterNumber).getMonsterDialogue());
        }
    }

    //EFFECT: compares inputted answer to the question's correct answer
    public static void evaluateQuizAnswer(String answer, Question question, Quiz quiz, int monsterNumber) {
        if (answer.equals(question.getAnswer())) {
            quiz.getMonster(monsterNumber).attackMonster();
            if (quiz.getMonster(monsterNumber).isDefeated()) {
                quiz.defeatMonster(quiz.getMonster(monsterNumber));
                System.out.println("You've defeated the monster!");
            } else {
                System.out.println("You've hit the monster once!");
            }
        } else {
            quiz.decreaseHpByOne();
            System.out.println("Your attack missed, you were hit by the monster!");
        }
    }

    //MODIFIES: this
    //EFFECT: increases quiz level by one if it has enough points
    public static void checkIfLevelUp(Quiz quiz) {
        if (quiz.getExp() >= EXP_NEEDED_TO_LEVEL_UP) {
            quiz.levelUp();
            System.out.println("You've leveled up to level " + quiz.getLevel() + " !");
        }
    }
}

