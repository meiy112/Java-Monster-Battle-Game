package model;

//enemy type grim reaper with 3 hp, 3 exp, and unique dialogue
public class GrimReaper extends Enemy {

    public GrimReaper() {
        hp = 3;
        dialogue = "The grim reaper appeared, they look very strong!";
        exp = 3;
    }
}
