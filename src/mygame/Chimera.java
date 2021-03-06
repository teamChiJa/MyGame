package mygame;

import java.util.concurrent.ThreadLocalRandom;
import static mygame.Command.pl;

public class Chimera extends Monster {

    private String name;
    private int hp;
    private final int MAX_HP;
    private int mp;
    private final int MAX_MP;
    private int attack;

    private int defence;
    private String enemyNo = "敵";
    private final String MonsterName = "Chimera";

    public Chimera(String name) {
        this.name = name;
        hp = ThreadLocalRandom.current().nextInt(16, 31);
        MAX_HP = hp;
        mp = ThreadLocalRandom.current().nextInt(11, 16);
        MAX_MP = mp;
        attack = 15;
        defence = 10;
    }

    public void attack(Job jb) {
        int damage = this.getAttack() - jb.getDefence();
        if (damage <= 0) {
            damage = 1;
        }
        if (this.getHp() > 0) {
            System.out.println(this.name + "の攻撃");
            System.out.println(jb.getName() + "に" + damage + "ダメージ");////
            jb.setHp(jb.getHp() - damage);
            if (jb.getHp() <= 0) {
                jb.setHp(0);
                pl(jb.getName() + "は倒れた");
            }
            System.out.println(jb.getName() + " のHP： " + jb.getHp()+"/"+jb.getMAX_HP());
        }
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

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getMonsterName() {
        return MonsterName;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public String getEnemyNo() {
        return enemyNo;
    }

    public void setEnemyNo(String enemyNo) {
        this.enemyNo = enemyNo;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public int getMAX_MP() {
        return MAX_MP;
    }
    
}
