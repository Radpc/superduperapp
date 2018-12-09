package tap.radpc.superduperapp.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "produto")
public class Produto {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int serial;
    private String nome;
    private int descricao;
    private int preco;
    private int precoComprado;
    private int estoque;
    private String medida;
    private String categoria;

    @NonNull
    public int getSerial() {
        return serial;
    }

    public void setSerial(@NonNull int serial) {
        this.serial = serial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDescricao() {
        return descricao;
    }

    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getPrecoComprado() {
        return precoComprado;
    }

    public void setPrecoComprado(int precoComprado) {
        this.precoComprado = precoComprado;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Produto(@NonNull int serial, String nome, int descricao, int preco, int precoComprado, int estoque, String medida, String categoria) {

        this.serial = serial;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.precoComprado = precoComprado;
        this.estoque = estoque;
        this.medida = medida;
        this.categoria = categoria;
    }
}
