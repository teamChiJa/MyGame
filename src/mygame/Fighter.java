package mygame;

import java.util.concurrent.ThreadLocalRandom;

public class Fighter extends Job {

    private String name;
    private int hp;
    private int mp;
    private int attack;
    private int defence;
    private final String jobName = "Fighter";

    public Fighter(String name) {
        this.name = name;
        hp = ThreadLocalRandom.current().nextInt(31, 41);
        mp = 0;
        attack = ThreadLocalRandom.current().nextInt(41, 51);
        defence = 10;;

    }

    public void attack(Monster ms) {
        int w = this.getAttack();
        if (hp > 0 && hp <= 10) {
            w *= 1.5;
        }

        int damage = (int) (w - (ms.getDefence() * 0.8));
        if (damage < 0) {
            damage = 1;
        }
        if (this.hp > 0) {
            System.out.println(this.getName() + " の攻撃");
            System.out.println(ms.getHp() + "に" + damage + "ダメージ");
            ms.setHp(ms.getHp() - damage);
            if (ms.getHp() < 0) {
                ms.setHp(0);
            }
            System.out.println(ms.getName() + "のHP： " + ms.getHp());
        }
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getJobName() {
        return jobName;
    }

}
