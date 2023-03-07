package model.Enemies;

import model.Enemy;

//enemy type goose with knife with 1 hp, 1 exp, and unique dialogue
public class GooseWithKnife extends Enemy {

    public GooseWithKnife() {
        hp = 1;
        dialogue = "A goose with a knife appeared! *Honk*";
        exp = 1;
    }
}
