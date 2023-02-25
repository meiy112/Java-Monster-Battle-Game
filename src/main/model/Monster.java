package model;

public class Monster {

    private final int size;
    private int hp;
    private String dialogue;

    // CONSTRAINT: 0 < size < 4
    // EFFECT: creates monster with given size and assigns dialogue and hp depending on size
    public Monster(int size) {
        this.size = size;

        if (size == 1) {
            this.hp = 1;
            this.dialogue = "a small monster appeared!";
        } else if (size == 2) {
            this.hp = 2;
            this.dialogue = "a moderate sized monster appeared!";
        } else if (size == 3) {
            this.hp = 3;
            this.dialogue = "uh-oh... a large monster appeared!";
        }
    }

    // getters
    public String getMonsterDialogue() {
        return dialogue;
    }

    public int getMonsterExp() {
        return size;
    }

    public int getMonsterHp() {
        return hp;
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
