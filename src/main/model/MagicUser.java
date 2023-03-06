package model;

//enemy type magic user with 3 hp, 3 exp, and unique dialogue
public class MagicUser extends Enemy {

    public MagicUser() {
        hp = 3;
        dialogue = "A magic user appeared, they look very strong!";
        exp = 3;
    }
}
