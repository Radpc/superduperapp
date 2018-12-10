package tap.radpc.superduperapp.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "usuario")
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id = 0;
    private String usuario;
    private String senha;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    @NonNull
    public int getId() {

        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
