package mygame;

import java.util.concurrent.ThreadLocalRandom;

public class Hero extends Job {

    private String name;
    private int hp;
    private final int MAX_HP;
    private int mp;
    private final int MAX_MP;
    private int attack;
    private int defence;
    private final String jobName = "Hero";

    public Hero(String name) {
        this.name = name;
        hp = ThreadLocalRandom.current().nextInt(31, 41);
        MAX_HP = hp;
        mp = ThreadLocalRandom.current().nextInt(11, 21);
        MAX_MP = mp;
        attack = 20;
        defence = 20;
    }

    public void attack(Monster ms) {
        int acount;
        int damage = this.getAttack() - (int) (ms.getDefence() * 0.8);
        if (damage <= 0) {
            damage = 1;
        }
        if (this.hp > 0) {
            acount = ThreadLocalRandom.current().nextInt(1, 11);
            switch (acount) {

                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println(this.getName() + " の攻撃");
                    System.out.println(ms.getName() + "に" + damage + "ダメージ");
                    ms.setHp(ms.getHp() - damage);
                    if (ms.getHp() < 0) {
                        ms.setHp(0);
                    }
                    addAtack(ms,damage);
                    System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
                    break;
                case 5:
                case 6:
                case 7:
                    System.out.println(this.getName() + " の攻撃");
                    System.out.println(ms.getName() + "に" + damage + "ダメージ");
                    ms.setHp(ms.getHp() - damage);
                    if (ms.getHp() < 0) {
                        ms.setHp(0);
                    }
                    addAtack(ms,damage);
                    addAtack(ms,damage);
                    System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
                    break;
                case 8:
                case 9:
                    System.out.println(this.getName() + " の攻撃");
                    System.out.println(ms.getName() + "に" + damage + "ダメージ");
                    ms.setHp(ms.getHp() - damage);
                    if (ms.getHp() < 0) {
                        ms.setHp(0);
                    }
                    addAtack(ms,damage);
                    addAtack(ms,damage);
                    addAtack(ms,damage);
                    System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
                    break;
                case 10:
                    System.out.println(this.getName() + " の攻撃");
                    System.out.println(ms.getName() + "に" + damage + "ダメージ");
                    ms.setHp(ms.getHp() - damage);
                    if (ms.getHp() < 0) {
                        ms.setHp(0);
                    }
                    addAtack(ms,damage);
                    addAtack(ms,damage);
                    addAtack(ms,damage);
                    addAtack(ms,damage);
                    System.out.println(ms.getName() + "のHP： " + ms.getHp() + "/" + ms.getMAX_HP());
                    break;
            }
        }
    }
    
    public void addAtack(Monster ms,int damage){
        System.out.println(this.getName() + " の追加攻撃");
                    System.out.println(ms.getName() + "に" + damage + "ダメージ");
                    ms.setHp(ms.getHp() - damage);
                    if (ms.getHp() < 0) {
                        ms.setHp(0);
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

    /**
     * @return the MAX_HP
     */
    public int getMAX_HP() {
        return MAX_HP;
    }

    /**
     * @return the MAX_MP
     */
    public int getMAX_MP() {
        return MAX_MP;
    }

}
