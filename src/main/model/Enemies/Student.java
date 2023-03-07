package model.Enemies;

import model.Enemy;

//enemy type student with 1 hp, 1 exp, and unique dialogue
public class Student extends Enemy {

    public Student() {
        hp = 1;
        dialogue = "A student appeared! They look tired... as usual.";
        exp = 1;
    }
}
