package traore.adama.roomtry;

import android.app.Application;
import android.arch.persistence.room.Room;

public class MyApplication extends Application {
    private GameDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(this, GameDatabase.class, "GameDatabase").build();
    }

    public GameDatabase getDb() {
        return db;
    }

}
