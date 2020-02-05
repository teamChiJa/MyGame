package mygame;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import static mygame.Combat.*;
import static mygame.Insert.*;
import static mygame.MemberManager.*;
import java.sql.*;

public class Command {

    static ArrayList<Job> tmp_party = new ArrayList();
    static String GName_tmp = "";
    static String Job_tmp = "";
    static String name = "";
    static int HP = 0;
    static int MP = 0;
    static int MAXHP = 0;
    static int MAXMP = 0;
    static int ATK = 0;
    static int DEF = 0;
    static int MAXATK = 0;
    static int MAXDEF = 0;
    static int LEVEL = 0;
    static int EXP = 0;
    static int MAXEXP = 0;
    static int id = 0;
    static int cnt;
    static int tmp_cnt;

    public static void p(Object msg) {
        System.out.print(msg);
    }

    public static void pl(Object msg) {
        System.out.println(msg);
    }

    public static void read() {
        final String DB_URL = "jdbc:postgresql://localhost:5432/mydb";
        final String DB_USER = "postgres";
        final String PASSWORD = "password";
        final String JDBC_DRIVER = "org.postgresql.Driver";
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC ドライバのロードに失敗しました。");
            e.printStackTrace();
            return;
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD);
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select COUNT(*) cnt FROM mygame");
            rs.next();
            cnt = rs.getInt("cnt");
            tmp_cnt = cnt;
            if (cnt != 0) {
                rs = stmt.executeQuery("SELECT * FROM mygame ORDER BY id");
                boolean ena = false;
                String tmp_group = "";
                int p_cnt = 0;
                while (rs.next()) {
                    name = rs.getString("NAME");
                    HP = rs.getInt("HP");
                    MAXHP = rs.getInt("MAX_HP");
                    MAXMP = rs.getInt("MAX_MP");
                    ATK = rs.getInt("ATTACK");
                    DEF = rs.getInt("DEFENCE");
                    MAXATK = rs.getInt("MAX_ATTACK");
                    MAXDEF = rs.getInt("MAX_DEFENCE");
                    LEVEL = rs.getInt("LEVEL");
                    EXP = rs.getInt("EXP");
                    MAXEXP = rs.getInt("MAX_EXP");
                    id = rs.getInt("id");
                    if (ena == false) {
                        if (rs.getString("JOB").equals("Hero")) {
                            Hero h = new Hero(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                            tmp_party.add(h);
                        } else if (rs.getString("JOB").equals("Wizard")) {
                            Wizard w = new Wizard(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                            tmp_party.add(w);
                        } else if (rs.getString("JOB").equals("Mage")) {
                            Mage m = new Mage(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                            tmp_party.add(m);
                        } else if (rs.getString("JOB").equals("Fighter")) {
                            Fighter f = new Fighter(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                            tmp_party.add(f);
                        } else if (rs.getString("JOB").equals("Knight")) {
                            Knight k = new Knight(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                            tmp_party.add(k);
                        }
                        tmp_group = rs.getString("GROUP_NAME");
                        p_cnt = 1;
                        ena = true;
                    } else {
                        if (tmp_group.equals(rs.getString("GROUP_NAME"))) {
                            if (rs.getString("JOB").equals("Hero")) {
                                Hero h = new Hero(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                                tmp_party.add(h);
                            } else if (rs.getString("JOB").equals("Wizard")) {
                                Wizard w = new Wizard(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                                tmp_party.add(w);
                            } else if (rs.getString("JOB").equals("Mage")) {
                                Mage m = new Mage(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                                tmp_party.add(m);
                            } else if (rs.getString("JOB").equals("Fighter")) {
                                Fighter f = new Fighter(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                                tmp_party.add(f);
                            } else if (rs.getString("JOB").equals("Knight")) {
                                Knight k = new Knight(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                                tmp_party.add(k);
                            }
                            p_cnt++;
                        } else {
                            switch (p_cnt) {
                                case 1:
                                    hmmPut(tmp_group, tmp_party.get(0));
                                    tmp_party.clear();
                                    break;
                                case 2:
                                    hmmPut(tmp_group, tmp_party.get(0), tmp_party.get(1));
                                    tmp_party.clear();
                                    break;
                                case 3:
                                    hmmPut(tmp_group, tmp_party.get(0), tmp_party.get(1), tmp_party.get(2));
                                    tmp_party.clear();
                                    break;
                            }
                            tmp_group = rs.getString("GROUP_NAME");
                            if (tmp_group.equals(rs.getString("GROUP_NAME"))) {
                                if (rs.getString("JOB").equals("Hero")) {
                                    Hero h = new Hero(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                                    tmp_party.add(h);
                                } else if (rs.getString("JOB").equals("Wizard")) {
                                    Wizard w = new Wizard(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                                    tmp_party.add(w);
                                } else if (rs.getString("JOB").equals("Mage")) {
                                    Mage m = new Mage(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                                    tmp_party.add(m);
                                } else if (rs.getString("JOB").equals("Fighter")) {
                                    Fighter f = new Fighter(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                                    tmp_party.add(f);
                                } else if (rs.getString("JOB").equals("Knight")) {
                                    Knight k = new Knight(name, HP, MAXHP, MP, MAXMP, ATK, DEF, MAXATK, MAXDEF, LEVEL, EXP, MAXEXP, id);
                                    tmp_party.add(k);
                                }
                            }
                        }
                    }

                }
                switch (p_cnt) {
                    case 1:
                        hmmPut(tmp_group, tmp_party.get(0));
                        break;
                    case 2:
                        hmmPut(tmp_group, tmp_party.get(0), tmp_party.get(1));
                        break;
                    case 3:
                        hmmPut(tmp_group, tmp_party.get(0), tmp_party.get(1), tmp_party.get(2));
                        break;
                }
                pl("セーブデータの読み込みが完了しました。");
                // ResultSet を解放
                rs.close();
                // Statement を解放
                stmt.close();
                // Connection を解放
                con.close();
            }
        } catch (SQLException e) {
            //System.err.println("SQL:" + SQL);
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void save() {
        final String DB_URL = "jdbc:postgresql://localhost:5432/mydb";
        final String DB_USER = "postgres";
        final String PASSWORD = "password";
        final String JDBC_DRIVER = "org.postgresql.Driver";
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC ドライバのロードに失敗しました。");
            e.printStackTrace();
            return;
        }

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD);
            con.setAutoCommit(false);
            for (String group : hmm.keySet()) {
                for (int i = 0; i < hmm.get(group).size(); i++) {
                    if (hmm.get(group).get(i).getId() <= cnt) {
                        pstmt = con.prepareStatement("update mygame set group_name=?,job=?,name=?,hp=?,mp=?,attack=?,defence=?,max_hp=?,max_mp=?,max_attack=?,max_defence=?,level=?,exp=?,max_exp=?,id=? WHERE id=?");
                        pstmt.setString(1, group);
                        pstmt.setString(2, hmm.get(group).get(i).getJobName());
                        pstmt.setString(3, hmm.get(group).get(i).getName());
                        pstmt.setInt(4, hmm.get(group).get(i).getHp());
                        pstmt.setInt(5, hmm.get(group).get(i).getMp());
                        pstmt.setInt(6, hmm.get(group).get(i).getAttack());
                        pstmt.setInt(7, hmm.get(group).get(i).getDefence());
                        pstmt.setInt(8, hmm.get(group).get(i).getMAX_HP());
                        pstmt.setInt(9, hmm.get(group).get(i).getMAX_MP());
                        pstmt.setInt(10, hmm.get(group).get(i).getD_ATTACK());
                        pstmt.setInt(11, hmm.get(group).get(i).getD_DEFENCE());
                        pstmt.setInt(12, hmm.get(group).get(i).getLevel());
                        pstmt.setInt(13, hmm.get(group).get(i).getExp());
                        pstmt.setInt(14, hmm.get(group).get(i).getmaxexp());
                        pstmt.setInt(15, hmm.get(group).get(i).getId());
                        pstmt.setInt(16, hmm.get(group).get(i).getId());
                        pstmt.executeUpdate();
                    } else {
                        pstmt = con.prepareStatement("INSERT INTO mygame (group_name,job,name,hp,mp,attack,defence,max_hp,max_mp,max_attack,max_defence,level,exp,max_exp,id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        pstmt.setString(1, group);
                        pstmt.setString(2, hmm.get(group).get(i).getJobName());
                        pstmt.setString(3, hmm.get(group).get(i).getName());
                        pstmt.setInt(4, hmm.get(group).get(i).getHp());
                        pstmt.setInt(5, hmm.get(group).get(i).getMp());
                        pstmt.setInt(6, hmm.get(group).get(i).getAttack());
                        pstmt.setInt(7, hmm.get(group).get(i).getDefence());
                        pstmt.setInt(8, hmm.get(group).get(i).getMAX_HP());
                        pstmt.setInt(9, hmm.get(group).get(i).getMAX_MP());
                        pstmt.setInt(10, hmm.get(group).get(i).getD_ATTACK());
                        pstmt.setInt(11, hmm.get(group).get(i).getD_DEFENCE());
                        pstmt.setInt(12, hmm.get(group).get(i).getLevel());
                        pstmt.setInt(13, hmm.get(group).get(i).getExp());
                        pstmt.setInt(14, hmm.get(group).get(i).getmaxexp());
                        pstmt.setInt(15, hmm.get(group).get(i).getId());
                        pstmt.executeUpdate();
                    }
                }
            }
            con.commit();
            cnt = tmp_cnt;
        } catch (SQLException e) {
            //System.err.println("SQL:" + SQL);
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void monstersAttack() {
        int jbran;
        boolean l;
        for (int i = 0; i < monsterParty.size(); i++) {
            pl("");
            for (;;) {
                jbran = ThreadLocalRandom.current().nextInt(0, combatParty.size());
                if (!jobLive()) {
                    break;//みんなが死んでたら
                }
                if (combatParty.get(jbran).getHp() != 0) {
                    monsterParty.get(i).attack(combatParty.get(jbran));
                    break;
                }
            }

        }
    }

    public static void jobAttack(Job j) {
        if (j.getHp() > 0) {
            pl("");
            pl(j.getName() + "　の攻撃");
            pl("どのモンスターを攻撃しますか");
            j.attack(target());
        }
    }

    public static Monster target() {
        Monster ms;
        String mn = " ";
        for (int i = 0; i < monsterParty.size(); i++) {
            if (monsterParty.get(i).getHp() > 0) {
                mn += monsterParty.get(i).getEnemyNo();
                mn += ".";
                mn += monsterParty.get(i).getName();
                mn += "  ";
            }
        }
        mn += ">";
        int no;
        int targetNo = 0;
        for (;;) {
            if (!monsterLive()) {
                break;
            }
            no = insertNumber(mn);
            targetNo = no - 1;
            if (no > 0 && no <= monsterParty.size()) {
                if (monsterParty.get(targetNo).getHp() > 0) {
                    break;
                }
                pl("▽選択したモンスターは倒れています");
            }
        }

        ms = monsterParty.get(targetNo);
        return ms;
    }

    public static boolean jobLive() {
        boolean live = true;

        int count = 0;
        for (Job j : combatParty) {
            if (j.getHp() == 0) {
                count++;
            }
        }
        if (count == combatParty.size()) {
            live = false;
        }
        return live;//みんなが死んでたらFalse
    }

    public static boolean monsterLive() {
        boolean live = true;
        int count = 0;
        for (Monster m : monsterParty) {
            if (m.getHp() == 0) {
                count++;
            }
        }
        if (count == monsterParty.size()) {
            live = false;
        }
        return live;//みんなが死んでたらFalse
    }

    public static boolean monsterDeath() {
        boolean death = false;
        int count = 0;
        for (Monster m : monsterParty) {
            if (m.getHp() == 0) {
                count++;
            }
        }
        if (count > 0) {
            live = true;
        }
        return death;//一人でも死んでたらtrue
    }

    public static void full() { //全回復 HP & MP
        for (Job j : combatParty) {
            j.setHp(j.getMAX_HP());
            j.setMp(j.getMAX_MP());
        }
    }

    public static void monsterHpToString() { //モンスターリストとHPを表示
        String msg = "【敵】\r\n";
        for (Monster m : monsterParty) {
            if (m.getHp() != 0) {
                msg += m.getName();
                msg += " HP:";
                msg += m.getHp() + "/" + m.getMAX_HP();
                msg += "  ";
            }
        }
        pl(msg);
    }

    public static void playerDeathToString() {
        String msg;
        for (Job j : combatParty) {
            if (j.getHp() == 0) {
                pl("");
                p(combatParty.indexOf(j) + 1 + ":");
                p("【" + j.getJobName() + "】");
                pl(j.getName());
            }
        }
    }

    public static void playerHpToString() { //グループのメンバーリストとHPを表示
        pl("");
        String msg = "";
        msg += select_gName + "\r\n";
        for (Job j : combatParty) {
            if (j.getHp() != 0) {
                msg += j.getName() + "(Lv." + j.getLevel() + ")";
                msg += " HP:";
                msg += j.getHp() + "/" + j.getMAX_HP();
                msg += "  ";
            }
        }
        pl(msg);
    }

    public static void expset() {
        for (Job j : combatParty) {
            int getexp = ThreadLocalRandom.current().nextInt(10, 16) * monsterParty.size();
            pl(j.getName() + "は、" + getexp + "expを獲得した。");
            int exp_tmp = j.getExp() + getexp;
            if (exp_tmp < j.getmaxexp()) {
                j.setExp(exp_tmp);
                pl(j.getName() + ":EXP[ " + j.getExp() + "/" + j.getmaxexp() + " ]");
            } else {
                j.setExp(exp_tmp - j.getmaxexp());
                int lvup = j.getLevel() + 1;
                j.setLevel(lvup);
                j.setmaxexp(j.getmaxexp() + ThreadLocalRandom.current().nextInt(20, 31));
                pl("<" + j.getName() + ">");
                pl("*****LEVEL UP!*****");
                pl(j.getName() + "のレベルが" + j.getLevel() + "にアップしました。");
                pl(j.getLevel() - 1 + " → " + j.getLevel());
                pl(j.getName() + ":EXP[ " + j.getExp() + "/" + j.getmaxexp() + " ]");
                jobstup(j);
            }
        }
    }

    public static void jobstup(Job j) {
        pl("*****STATUS UP*****");
        int hptmp = j.getMAX_HP();
        int mptmp = j.getMAX_MP();
        int atktmp = j.getD_ATTACK();
        int deftmp = j.getD_DEFENCE();
        j.setAttack(j.getAttack() + 1);
        j.setDefence(j.getDefence() + 1);
        j.setHp(j.getHp() + 3);
        j.setMAX_HP(j.getMAX_HP() + 1);
        if (j.getJobName().equals("Hero")) {
            j.setAttack(j.getAttack() + 1);
            j.setDefence(j.getDefence() + 1);
            j.setMp(j.getMp() + 2);
            j.setMAX_MP(j.getMAX_MP() + 2);
        } else if (j.getJobName().equals("Wizard")) {
            j.setMp(j.getMp() + 4);
            j.setMAX_MP(j.getMAX_MP() + 4);
        } else if (j.getJobName().equals("Mage")) {
            j.setMp(j.getMp() + 4);
            j.setMAX_MP(j.getMAX_MP() + 4);
        } else if (j.getJobName().equals("Fighter")) {
            j.setAttack(j.getAttack() + 2);
        } else if (j.getJobName().equals("Knight")) {
            j.setAttack(j.getAttack() + 1);
            j.setDefence(j.getDefence() + 1);
            j.setHp(j.getHp() + 1);
            j.setMp(j.getMp() + 2);
            j.setMAX_HP(j.getMAX_HP() + 1);
            j.setMAX_MP(j.getMAX_MP() + 2);
        }
        j.setD_ATTACK(j.getAttack());
        j.setD_DEFENCE(j.getDefence());
        pl("HP:" + hptmp + "→" + j.getMAX_HP());
        pl("MP:" + mptmp + "→" + j.getMAX_MP());
        pl("ATK:" + atktmp + "→" + j.getD_ATTACK());
        pl("DEF:" + deftmp + "→" + j.getD_DEFENCE());
        pl("********************");
    }

    private static boolean checkBeforeReadfile(File file) {
        if (file.exists()) {
            if (file.isFile() && file.canRead()) {
                return true;
            }
        }
        return false;
    }
}
