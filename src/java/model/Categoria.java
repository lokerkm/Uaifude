package model;

public abstract class Categoria {

    private int id;
    private String nome;
public abstract String getDescricao();
    public Categoria() {
    }

//    public Categoria(int id, String nome) {
//        this.id = id;
//        this.nome = nome;
//    }

    public int getId() {
        return id;
    }

    public Categoria setId(int id) {
        this.id = id;
   return this;}

    public String getNome() {
        return nome;
    }

    public Categoria setNome(String nome) {
        this.nome = nome;
   return this;}

    public String categoriaDescricao() {
        return "A categoria " +this.getNome()+ " " + this.getDescricao();
    }
}
