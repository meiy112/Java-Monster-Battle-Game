package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


//quiz game application
public class QuizGame {

    private static final String JSON_STORE = "./data/myFile.json";
    private static final int NUM_ENEMIES_TO_GEN = 12;
    private static Quiz quiz;
    private static JsonReader jsonReader;
    private static JsonWriter jsonWriter;

    //EFFECT: runs the game menu
    public static void gameMenu() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("Select from: \n'n' > create new quiz \n'l' > load questions \n'q' > quit");
            Scanner keyboardInput = new Scanner(System.in);
            String input = keyboardInput.nextLine();

            if (Objects.equals(input, "n")) {
                quiz = new Quiz();
                quizMenu();
            } else if (Objects.equals(input, "l")) {
                loadQuiz();
                quizMenu();
            } else if (Objects.equals(input, "q")) {
                keepGoing = false;
            }
        }
        System.out.println("Goodbye!");
    }

    //EFFECT: runs the quiz menu
    public static void quizMenu() {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("'p' > play current quiz \n'e' > edit questions \n's' > save current quiz"
                    + " \n'b' > back \nThe quiz currently has " + quiz.getQuestions().size() + " questions.");
            Scanner keyboardInput = new Scanner(System.in);
            String input = keyboardInput.nextLine();
            if (Objects.equals(input, "p")) {
                System.out.println("Starting quiz with " + quiz.getQuestions().size() + " questions");
                keepGoing = false;
                runQuiz();
            } else if (Objects.equals(input, "e")) {
                editQuestions();
            } else if (Objects.equals(input, "s")) {
                saveQuiz();
            } else if (Objects.equals(input, "b")) {
                keepGoing = false;
            } else {
                System.out.println("Please enter a valid command");
            }
        }
    }

    //EFFECT: menu screen where user can choose to add or delete questions
    public static void editQuestions() {
        boolean keepGoing = true;

        while (keepGoing) {
            int n = 1;
            for (Question q : quiz.getQuestions()) {
                System.out.println("Q" + n + "\nq: " + q.getPrompt() + "\na: " + q.getAnswer());
                n++;
            }
            System.out.println("'a' > add question \n'd' > delete question \n'b' > back");
            Scanner keyboardInput = new Scanner(System.in);
            String input = keyboardInput.nextLine();

            if (Objects.equals(input, "a")) {
                addQuestion();
            } else if (Objects.equals(input, "d")) {
                deleteQuestion();
            } else if (Objects.equals(input, "b")) {
                keepGoing = false;
            } else {
                System.out.println("Please enter a valid command");
            }
        }
    }

    //MODIFIES: this
    //EFFECT: prompts the player to input a question and answer and adds it to quiz
    public static void addQuestion() {
        Question question = new Question();
        Scanner keyboardInput = new Scanner(System.in);

        System.out.println("Please enter a new question prompt");
        String prompt = keyboardInput.nextLine();
        question.setPrompt(prompt);

        System.out.println("Please enter the answer to the previous prompt");
        String answer = keyboardInput.nextLine();
        question.setAnswer(answer);

        quiz.addQuestion(question);
    }

    //CONSTRAINT: number entered must exist as a question number
    //MODIFIES: this
    //EFFECT: deletes question from index n-1 where n is the number entered
    public static void deleteQuestion() {
        System.out.println("Please enter the number of the question you wish to delete");
        Scanner keyboardInput = new Scanner(System.in);
        int question = keyboardInput.nextInt();
        quiz.getQuestions().remove(question - 1);
    }

    //CONSTRAINT: quiz must have at least one Enemy added
    //MODIFIES: this
    //EFFECT: starts the quiz game, updating player stats along the way
    public static void runQuiz() {
        Random rand = new Random();
        int n = rand.nextInt(NUM_ENEMIES_TO_GEN);
        Enemy currEnemy = generateEnemy(n);
        int isNewEnemy = 1;
        quiz.setContGame(true);

        while (quiz.getQuestionNum() < quiz.getQuestions().size() && quiz.getContGame()) {
            System.out.println("HP: " + quiz.getHp() + "\nLevel: " + quiz.getLevel());
            getDialogue(isNewEnemy, currEnemy);
            isNewEnemy = 0;

            evaluateQuizAnswer(quiz.getQuestions().get(quiz.getQuestionNum()), currEnemy);
            checkIfLevelUp();
            if (currEnemy.isDefeated()) {
                int i = rand.nextInt(NUM_ENEMIES_TO_GEN);
                currEnemy = generateEnemy(i);
                isNewEnemy = 1;
            }
            if (quiz.isGameOver()) {
                System.out.println("You've lost all your health. Game over!");
                break;
            }
        }
        printEnd();
    }

    //CONSTRAINT: isNewEnemy must be either 1 or 0
    //EFFECT: returns Enemy dialogue if isNewEnemy is 1
    private static void getDialogue(int isNewEnemy, Enemy enemy) {
        if (isNewEnemy == 1) {
            System.out.println(enemy.getEnemyDialogue());
        }
    }

    //EFFECT: compares inputted answer to the question's correct answer
    public static void evaluateQuizAnswer(Question question, Enemy enemy) {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("enter SPACE to pause\nQ " + (quiz.getQuestionNum() + 1) + "/"
                + quiz.getQuestions().size() + ": " + question.getPrompt());
        String answer = keyboardInput.nextLine();

        if (answer.equals(" ")) {
            pauseGame();
        } else if (answer.equals(question.getAnswer())) {
            enemy.attackEnemy();
            if (enemy.isDefeated()) {
                quiz.defeatEnemy(enemy);
                System.out.println("You've defeated the Enemy!");
                quiz.setQuestionNum(quiz.getQuestionNum() + 1);
            } else {
                System.out.println("You've hit the Enemy once!");
                quiz.setQuestionNum(quiz.getQuestionNum() + 1);
            }
        } else {
            quiz.decreaseHpByOne();
            System.out.println("Your attack missed, you were hit by the Enemy!");
            quiz.setQuestionNum(quiz.getQuestionNum() + 1);
        }
    }

    //EFFECT: runs game paused menu
    public static void pauseGame() {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("Quiz paused \nSelect from: \n's' > save game \n'c' > continue game "
                    + "\n'q' > quit to menu");
            Scanner keyboardInput = new Scanner(System.in);
            String input = keyboardInput.nextLine();

            switch (input) {
                case "s":
                    saveQuiz();
                    break;
                case "c":
                    keepGoing = false;
                    break;
                case "r":
                    quiz.setQuestionNum(0);
                    keepGoing = false;
                    break;
                case "q":
                    quiz.setContGame(false);
                    keepGoing = false;
                    break;
            }
        }
    }

    //MODIFIES: this
    //EFFECT: increases quiz level by one if it has enough points
    public static void checkIfLevelUp() {
        if (quiz.getExp() >= 3) {
            quiz.levelUp();
            System.out.println("You've leveled up to level " + quiz.getLevel() + " !");
        }
    }

    //CONSTRAINT: integer must be within bounds
    //EFFECT: returns randomly generated enemy
    public static Enemy generateEnemy(int i) {
        Enemy enemy = null;
        if (i == 0) {
            enemy = new Almond();
        } else if (i == 1) {
            enemy = new Assassin();
        } else if (i == 2) {
            enemy = new GrimReaper();
        } else if (i == 3) {
            enemy = new MagicUser();
        } else if (i == 4) {
            enemy = new MustardBottle();
        } else if (i == 5) {
            enemy = new Pirate();
        } else if (i == 6) {
            enemy = new Pokemon();
        } else if (i == 7) {
            enemy = new Raccoon();
        } else if (i == 8) {
            enemy = new Student();
        } else if (i == 9) {
            enemy = new Link();
        } else if (i == 10) {
            enemy = new God();
        } else if (i == 11) {
            enemy = new GooseWithKnife();
        }
        return enemy;
    }

    //EFFECTS: prints game ending statement
    public static void printEnd() {
        System.out.println("You've defeated " + quiz.getScore()
                + " opponents and gotten to level " + quiz.getLevel() + "! \n");
    }

    //EFFECTS: saves quiz to file
    private static void saveQuiz() {
        try {
            jsonWriter.open();
            jsonWriter.write(quiz);
            jsonWriter.close();
            System.out.println("Saved quiz to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //MODIFIES: this
    //EFFECTS: loads quiz from file
    private static void loadQuiz() {
        try {
            quiz = jsonReader.read();
            System.out.println("Loaded quiz from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}

