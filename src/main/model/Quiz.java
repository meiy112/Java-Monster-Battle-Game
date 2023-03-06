package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

//represents a quiz that keeps track of the player's score, hp, level, exp, and has a list of monsters and questions
public class Quiz implements Writable {

    private int score;
    private int hp;
    private int level;
    private int exp;
    private final List<Question> questions;

    //EFFECT: creates a quiz with empty list of monsters and questions and default player stats
    public Quiz() {
        this.score = 0;
        this.hp = 3;
        this.level = 1;
        this.exp = 0;
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

    public List<Question> getQuestions() {
        return questions;
    }

    //MODIFIES: this
    //EFFECT: adds question to list of questions
    public void addQuestion(Question question) {
        questions.add(question);
    }

    //CONSTRAINT: monster must have hp <= 0
    //MODIFIES: this
    //EFFECT: increases score by 1 and increases exp based on the size of monster
    public void defeatEnemy(Enemy enemy) {
        score++;
        exp += enemy.getEnemyExp();
    }

    //MODIFIES: this
    //EFFECT: decreases hp by 1
    public void decreaseHpByOne() {
        hp--;
    }

    //MODIFIES: this
    //EFFECT: increases level by using up player's exp
    public void levelUp() {
        int levels = exp / 3;
        level += levels;
        exp -= 3 * levels;
    }

    //EFFECT: returns true if player hp is <= 0, otherwise false
    public boolean isGameOver() {
        return hp <= 0;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("questions", questionsToJson());
        return json;
    }

    // EFFECTS: returns quiz state and questions as a JSON array
    private JSONArray questionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Question q : questions) {
            jsonArray.put(q.toJson());
        }

        return jsonArray;
    }
}
