package model;

import model.Enemy;

//enemy type assassin with 2 hp, 2 exp, and unique dialogue
public class Assassin extends Enemy {

    public Assassin() {
        hp = 2;
        dialogue = "An assassin swiftly appeared, you never saw them coming!";
        exp = 2;
    }
}
