package model;

//enemy type raccoon with 1 hp, 1 exp, and unique dialogue
public class Raccoon extends Enemy {

    public Raccoon() {
        hp = 1;
        dialogue = "A raccoon appeared! He wants to colonize your land with his cousins.";
        exp = 1;
    }
}
