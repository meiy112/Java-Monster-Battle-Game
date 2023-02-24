package model;

import java.util.List;

public class Monster {

    public static String smallMonsterDialogue = "a small monster appeared!";
    public static String mediumMonsterDialogue = "a moderate sized monster appeared!";
    public static String largeMonsterDialogue = "uh-oh... a large monster appeared!";

    private int size;
    private int hp;

    // CONSTRAINT: 0 < size < 4
    public Monster(int size) {
        this.size = size;

        if (size == 1) {
            this.hp = 1;
        } else if (size == 2) {
            this.hp = 2;
        } else if (size == 3) {
            this.hp = 3;
        }
    }

    public String getMonsterDialogue() {
        if(size == 1) {
            return smallMonsterDialogue;
        } else if(size == 2) {
            return mediumMonsterDialogue;
        } else if (size == 3) {
            return largeMonsterDialogue;
        } else {
            return "this monster has an invalid size!";
        }
    }

    public int getMonsterExp() {
        return size;
    }

    public boolean isDefeated() {
        if(hp <= 0) {
            return true;
        } else{
            return false;
        }
    }

    public void takeDamage() {
        hp -= 1;
    }



}
