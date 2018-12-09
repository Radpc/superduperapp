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
    private boolean admin;

    public Usuario(String usuario, String senha, boolean admin) {
        this.usuario = usuario;
        this.senha = senha;
        this.admin = admin;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
