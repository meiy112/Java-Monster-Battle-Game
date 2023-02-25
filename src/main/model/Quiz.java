package model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static int INITIAL_SCORE = 0;
    public static int INITIAL_hp = 3;
    public static int INITIAL_LEVEL = 1;
    public static int INITIAL_LEVEL_UP_POINTS = 0;
    public static int POINTS_NEEDED_TO_LEVEL_UP = 3;

    private int score;
    private int hp;
    private int level;
    private int exp;
    private final List<Monster> monsters;
    private final List<Question> questions;

    //EFFECT: creates a quiz with empty list of monsters and questions and default player stats
    public Quiz() {
        this.score = INITIAL_SCORE;
        this.hp = INITIAL_hp;
        this.level = INITIAL_LEVEL;
        this.exp = INITIAL_LEVEL_UP_POINTS;
        this.monsters = new ArrayList<>();
        this.questions = new ArrayList<>();
    }

    // getters
    public int getHp() {
        return hp;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public Monster getMonster(int i) {
        return monsters.get(i);
    }

    public List<Question> getQuestions() {
        return questions;
    }


    //MODIFIES: this
    //EFFECT: adds question to list of questions
    public void addQuestion(Question question) {
        questions.add(question);
    }

    //MODIFIES: this
    //EFFECT: adds monster to list of monsters
    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    //CONSTRAINT: monster must have hp <= 0
    //MODIFIES: this
    //EFFECT: increases score by 1 and increases exp based on the size of monster
    public void defeatMonster(Monster monster) {
        score++;
        exp += monster.getMonsterExp();
    }

    //MODIFIES: this
    //EFFECT: decreases hp by 1
    public void decreaseHpByOne() {
        hp--;
    }

    //MODIFIES: this
    //EFFECT: increases level by using up player's exp
    public void levelUp() {
        int levels = exp / POINTS_NEEDED_TO_LEVEL_UP;
        level += levels;
        exp -= POINTS_NEEDED_TO_LEVEL_UP * levels;
    }

    //EFFECT: returns true if player hp is <= 0, otherwise false
    public boolean isGameOver() {
        return hp <= 0;
    }
}
