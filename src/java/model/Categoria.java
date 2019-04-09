package model;

public abstract class Categoria {

    private int id;
    private String nome;
public abstract String getDescricao();
    public Categoria() {
    }

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String categoriaDescricao() {
        return "A categoria " +this.getNome()+ " " + this.getDescricao();
    }
}
