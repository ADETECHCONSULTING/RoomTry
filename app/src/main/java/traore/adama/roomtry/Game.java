package traore.adama.roomtry;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Game {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "score")
    private int score;

    public Game(String userName, int score) {
        this.userName = userName;
        this.score = score;
    }

    public int getUid() {
        return uid;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
