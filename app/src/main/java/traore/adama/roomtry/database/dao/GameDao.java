package traore.adama.roomtry.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import traore.adama.roomtry.database.model.Game;

@Dao
public interface GameDao {
    @Query("SELECT * FROM Game")
    List<Game> getAll();

    @Query("SELECT * FROM Game WHERE uid=:id LIMIT 1")
    Game getGameById(int id);

    @Insert
    void insert(Game game);

    @Delete
    void delete(Game game);

    @Update
    void update(Game game);
}
