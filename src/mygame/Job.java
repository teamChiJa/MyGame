package mygame;

public class Job {
    private String name;
    private int HP;
    private int MP;
    private int Attack;
    private int Defence;

    public Job(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    public int getAttack() {
        return Attack;
    }

    public int getDefence() {
        return Defence;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public void setAttack(int Attack) {
        this.Attack = Attack;
    }

    public void setDefence(int Defence) {
        this.Defence = Defence;
    }
}
