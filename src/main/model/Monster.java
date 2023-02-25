package model;

public class Monster {

    public static String smallMonsterDialogue = "a small monster appeared!";
    public static String mediumMonsterDialogue = "a moderate sized monster appeared!";
    public static String largeMonsterDialogue = "uh-oh... a large monster appeared!";

    private final int size;
    private int hp;
    private String dialogue;

    // CONSTRAINT: 0 < size < 4
    // EFFECT: creates monster with given size and assigns dialogue and hp depending on size
    public Monster(int size) {
        this.size = size;

        if (size == 1) {
            this.hp = 1;
            this.dialogue = smallMonsterDialogue;
        } else if (size == 2) {
            this.hp = 2;
            this.dialogue = mediumMonsterDialogue;
        } else if (size == 3) {
            this.hp = 3;
            this.dialogue = largeMonsterDialogue;
        }
    }

    // getters
    public String getMonsterDialogue() {
        return dialogue;
    }

    public int getMonsterExp() {
        return size;
    }

    //EFFECT: return true if monster hp <= 0, otherwise return false
    public boolean isDefeated() {
        return hp <= 0;
    }

    //CONSTRAINT: monster must have hp >= 0
    //MODIFIES: this
    public void attackMonster() {
        hp -= 1;
    }


}
