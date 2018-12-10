package tap.radpc.superduperapp.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import tap.radpc.superduperapp.database.entities.Usuario;

@Dao
public interface UsuarioDAO {
    @Insert
    void insert(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Delete
    void delete(Usuario usuario);

    @Query("SELECT * FROM usuario")
    List<Usuario> getUsuarios();

    @Query("Select * FROM usuario WHERE usuario = :user")
    List<Usuario> getUsuario(String user);
}
