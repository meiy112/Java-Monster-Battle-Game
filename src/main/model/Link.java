package model;

import model.Enemy;

//enemy type link with 2 hp, 2 exp, and unique dialogue
public class Link extends Enemy {

    public Link() {
        hp = 2;
        dialogue = "Zelda appeared! ... Or is it Link?";
        exp = 2;
    }
}
