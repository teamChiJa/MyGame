package mygame;

public abstract class Job {
//抽象クラス

    private String name;
    private int hp;
    private int MAX_HP;
    private int mp;
    private int MAX_MP;
    private int attack;
    private int defence;
    private String jobName;
    private boolean magicList;
    private boolean spMoveList;
    private int D_ATTACK;
    private int D_DEFENCE;
    private int level;
    private int exp;
    private int maxexp;
    
    public Job() {
        MAX_HP = hp;
        MAX_MP = mp;
        D_ATTACK = attack;
        D_DEFENCE = defence;
        level = 1;
        exp = 0;
        maxexp = 128;
    }
    
    public void attack(Monster ms) {

    }

    public void setMAX_HP(int MAX_HP) {
        this.MAX_HP = MAX_HP;
    }

    public void setMAX_MP(int MAX_MP) {
        this.MAX_MP = MAX_MP;
    }

    public void setD_ATTACK(int D_ATTACK) {
        this.D_ATTACK = D_ATTACK;
    }

    public void setD_DEFENCE(int D_DEFENCE) {
        this.D_DEFENCE = D_DEFENCE;
    }
    
    public int getD_ATTACK() {
        return D_ATTACK;
    }

    public int getD_DEFENCE() {
        return D_DEFENCE;
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

    public void setJobName(String jobName) {
        this.jobName = jobName;
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

    public boolean isMagicList() {
        return magicList;
    }

    public void setMagicList(boolean magicList) {
        this.magicList = magicList;
    }

    public boolean isSpMoveList() {
        return spMoveList;
    }

    public void setSpMoveList(boolean spMoveList) {
        this.spMoveList = spMoveList;
    }

    public void magicToString() {
    }

    public void specialToString() {

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getmaxexp() {
        return maxexp;
    }

    public void setmaxexp(int maxexp) {
        this.maxexp = maxexp;
    }
    
}
