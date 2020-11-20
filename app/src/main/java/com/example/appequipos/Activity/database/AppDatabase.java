package com.example.appequipos.Activity.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.appequipos.Activity.Dao.DAOEquipo;
import com.example.appequipos.Activity.model.Equipo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Equipo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile com.example.appequipos.Activity.database.AppDatabase _INSTANCE;

    public abstract DAOEquipo daoPlato();


    private static final int NUMBER_OF_THREADS = 1;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static com.example.appequipos.Activity.database.AppDatabase getInstance(final Context context) {
        if (_INSTANCE == null) {
            synchronized (com.example.appequipos.Activity.database.AppDatabase.class) {
                if (_INSTANCE == null) {
                    _INSTANCE = Room.databaseBuilder(context.getApplicationContext(), com.example.appequipos.Activity.database.AppDatabase.class, "AppDatabase")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return _INSTANCE;
    }
}