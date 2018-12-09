package tap.radpc.superduperapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import tap.radpc.superduperapp.database.daos.ProdutoDAO;
import tap.radpc.superduperapp.database.daos.UsuarioDAO;
import tap.radpc.superduperapp.database.entities.Produto;
import tap.radpc.superduperapp.database.entities.Usuario;

@Database(entities = {Produto.class, Usuario.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProdutoDAO getProdutoDAO();
    public abstract UsuarioDAO getUsuarioDAO();
}