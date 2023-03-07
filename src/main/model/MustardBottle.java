package model;

import model.Enemy;

//enemy type mustard bottle with 1 hp, 1 exp, and unique dialogue
public class MustardBottle extends Enemy {

    public MustardBottle() {
        hp = 1;
        dialogue = "A mustard bottle appeared! She sent a weather balloon down to earth and framed China.";
        exp = 1;
    }
}
