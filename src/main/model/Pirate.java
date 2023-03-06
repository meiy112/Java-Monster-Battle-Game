package model;

//enemy type pirate with 3 hp, 3 exp, and unique dialogue
public class Pirate extends Enemy {

    public Pirate() {
        hp = 3;
        dialogue = "A pirate appeared, they look very strong!";
        exp = 3;
    }
}
