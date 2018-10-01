package traore.adama.roomtry.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import traore.adama.roomtry.database.dao.GameDao;
import traore.adama.roomtry.database.model.Game;

@Database(entities = {Game.class}, version = 1, exportSchema = false)
public abstract class GameDatabase  extends RoomDatabase {
    public abstract GameDao gameDao();
}
