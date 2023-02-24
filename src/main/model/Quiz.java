package model;

import java.util.List;

public class Quiz {
    public static int INITIAL_SCORE = 0;
    public static int INITIAL_LIFE = 3;
    public static int INITIAL_LEVEL = 1;
    public static int INITIAL_LEVEL_UP_POINTS = 0;
    public static int POINTS_NEEDED_TO_LEVEL_UP = 3;

    private int score;
    private int life;
    private int level;
    private int exp;
    private List<Monster> monsters;
    private List<Question> questions;

    public Quiz(List<Monster> monsters, List<Question> questions) {
        this.score = INITIAL_SCORE;
        this.life = INITIAL_LIFE;
        this.level = INITIAL_LEVEL;
        this.exp = INITIAL_LEVEL_UP_POINTS;
        this.monsters = monsters;
        this.questions = questions;
    }

    public int getLife() {
        return life;
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

    public int getQuizLength() {
        return questions.size();
    }

    public void defeatMonster(Monster monster) {
        score++;
        exp += monster.getMonsterExp();
    }

    public void attackMonster(Monster monster) {
        monster.takeDamage();
    }

    public void decreaseLifeByOne() {
        life--;
    }

    public void levelUp() {
        int levels = exp / POINTS_NEEDED_TO_LEVEL_UP;
        level += levels;
        exp -= POINTS_NEEDED_TO_LEVEL_UP * levels;
    }
    
    public boolean isGameOver() {
        if(life <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
