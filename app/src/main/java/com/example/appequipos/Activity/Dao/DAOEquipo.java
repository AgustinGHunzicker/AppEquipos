package com.example.appequipos.Activity.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.example.appequipos.Activity.model.Equipo;
import java.util.List;


@Dao
public interface DAOEquipo {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertar(Equipo equipo);

    @Delete
    void borrar(Equipo equipo);

    @Update
    void actualizar(Equipo equipo);

    @Query("SELECT * FROM equipo WHERE id = :id LIMIT 1")
    Equipo buscar(long id);

    @Query("SELECT * FROM equipo")
    List<Equipo> buscarTodos();
}
