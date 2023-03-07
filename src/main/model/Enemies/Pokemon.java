package model.Enemies;

import model.Enemy;

//enemy type pokemon with 2 hp, 2 exp, and unique dialogue
public class Pokemon extends Enemy {

    public Pokemon() {
        hp = 2;
        dialogue = "A pokemon appeared! Who's that pokemon?!";
        exp = 2;
    }
}
