package mygame;

import java.util.concurrent.ThreadLocalRandom;

public class Kajita extends Monster {

    private String name;
    private int attack;
    private int hp;
    private int mp;
    private int defence;
    private final String monsterJobName = "KAJITA";
    int kajiran;
    private String enemyNo = "敵";

    Kajita(String name) {
        this.name = name;
        hp = 80;
        mp = 75;
        attack = 50;
        defence = 10;
    }

    public void attack(Job jb) {
        int damage = this.getAttack() - jb.getDefence();
        if (damage <= 0) {
            damage = 1;
        }
        if (this.getHp() >= 40) {
            System.out.println(this.name + "の攻撃");
            System.out.println(jb.getName() + "に" + damage + "ダメージ");
            jb.setHp(jb.getHp() - damage);
            if (jb.getHp() < 0) {
                jb.setHp(0);
            }
            System.out.println(jb.getName() + " のHP： " + jb.getHp());
        }

        if (this.hp >= 20 && this.hp < 40) {
            kajiran = ThreadLocalRandom.current().nextInt(1, 6);
            switch (kajiran) {
                case 2:
                    System.out.println(this.name + " は、ゲップした");
                    break;
                default:
                    System.out.println(this.name + "の攻撃");
                    System.out.println(jb.getName() + "に" + damage + "ダメージ");
                    jb.setHp(jb.getHp() - damage);
                    if (jb.getHp() < 0) {
                        jb.setHp(0);
                    }
                    System.out.println(jb.getName() + " のHP： " + jb.getHp());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getMonsterJobName() {
        return monsterJobName;
    }

    public String getEnemyNo() {
        return enemyNo;
    }

    public void setEnemyNo(String enemyNo) {
        this.enemyNo = enemyNo;
    }
}
