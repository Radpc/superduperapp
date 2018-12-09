package tap.radpc.superduperapp.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import tap.radpc.superduperapp.database.entities.Produto;

@Dao
public interface ProdutoDAO {
    @Insert
    void insert(Produto produto);

    @Update
    void update(Produto produto);

    @Delete
    void delete(Produto produto);

    @Query("SELECT * FROM produto")
    List<Produto> getProdutos();

}
