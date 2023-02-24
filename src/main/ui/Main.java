package ui;

import model.Monster;
import model.Question;
import model.Quiz;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ui.QuizApp.runQuiz;


public class Main {
    public static void main(String[] args) {

        String q1 = "What is the answer?\n"
                + "(a)answer1\n(b)answer2\n(c)answer3\n(d)answer4\n";

        String q2 = "What is the answer now?\n"
                + "(a)answer1\n(b)answer2\n(c)answer3\n(d)answer4\n";

        String q3 = "What is the answer?\n"
                + "(a)answer1\n(b)answer2\n(c)answer3\n(d)answer4\n";

        String q4 = "What is the answer now?\n"
                + "(a)answer1\n(b)answer2\n(c)answer3\n(d)answer4\n";

        String q5 = "What is the answer?\n"
                + "(a)answer1\n(b)answer2\n(c)answer3\n(d)answer4\n";

        String q6 = "What is the answer now?\n"
                + "(a)answer1\n(b)answer2\n(c)answer3\n(d)answer4\n";

        Question question1 = new Question(q1, "a" );
        Question question2 = new Question(q2, "b");
        Question question3 = new Question(q3, "a");
        Question question4 = new Question(q4, "b");
        Question question5 = new Question(q5, "a");
        Question question6 = new Question(q6, "b");

        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);

        Monster monster1 = new Monster(1);
        Monster monster2 = new Monster(2);
        Monster monster3 = new Monster(3);

        List<Monster> monsters = new ArrayList<>();
        monsters.add(monster1);
        monsters.add(monster2);
        monsters.add(monster3);

        Quiz quiz = new Quiz(monsters, questions);

        runQuiz(quiz);
    }

}
